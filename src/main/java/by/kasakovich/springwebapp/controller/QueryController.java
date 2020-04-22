package by.kasakovich.springwebapp.controller;

import by.kasakovich.springwebapp.model.Query;
import by.kasakovich.springwebapp.model.DbTable;
import by.kasakovich.springwebapp.service.QueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QueryController {
    private QueryService queryService;

    //private List<Table> tables = new ArrayList<>();

    @Autowired
    public void setQueryService(QueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/query")
    public ModelAndView showQuery(){
        ModelAndView modelAndView = new ModelAndView("query");
        modelAndView.addObject("query", new Query());
        modelAndView.addObject("query", new Query());
        return modelAndView;
    }

    @PostMapping("/scanProcess")
    public ModelAndView showTables(){
        ModelAndView modelAndView = new ModelAndView("query");
        modelAndView.addObject("query", new Query());
        List<DbTable> tables = new ArrayList<>();
        tables = queryService.scanTables();
        modelAndView.addObject("tables", tables);
        return modelAndView;
    }
    /*@PostMapping("/queryProcess")
    public ModelAndView queryProcess(@ModelAttribute("query")Query query){
        ModelAndView modelAndView = new ModelAndView("query");
        modelAndView.addObject()
    }*/
}
