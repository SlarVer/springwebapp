package by.kasakovich.springwebapp.controller;

import by.kasakovich.springwebapp.model.*;
import by.kasakovich.springwebapp.service.QueryService;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value = "user")
public class QueryController {
    private QueryService queryService;

    @Autowired
    public void setQueryService(QueryService queryService) {
        this.queryService = queryService;
    }

    @PostMapping("/scan")
    public ModelAndView showTables(){
        ModelAndView modelAndView = new ModelAndView("query");
        modelAndView.addObject("query", new Query());
        List<DbTable> tables = queryService.scanTables();
        modelAndView.addObject("tables", tables);
        return modelAndView;
    }

    @PostMapping("/logs")
    public ModelAndView showLogs(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView("query");
        modelAndView.addObject("query", new Query());
        List<Query> queries = queryService.showLogs(user);
        modelAndView.addObject("logs", queries);
        return modelAndView;
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/queryprocess")
    public ModelAndView queryProcess(@ModelAttribute("query") Query query, @ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView("query");
        try {
            String condition;
            List resultSet = new ArrayList();
            if (user.getRole().equals("User") && !query.getQuery().contains("SELECT")){
                resultSet.add("Insufficient authority for this request!");
                condition = "string";
            } else {
                resultSet = queryService.execute(query, user);
                if (resultSet.get(0) instanceof RoosterTable) {
                    condition = "rooster";
                } else if (resultSet.get(0) instanceof StafflistTable) {
                    condition = "stafflist";
                } else {
                    condition = "string";
                }
            }
            modelAndView.addObject("condition", condition);
            modelAndView.addObject("resultset", resultSet);
        } catch (SQLGrammarException ex){
            modelAndView.addObject("resultset", ex.getMessage());
        }
        return modelAndView;
    }
}
