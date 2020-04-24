package by.kasakovich.springwebapp.model;

import java.sql.Date;

public class StafflistTable {
    private String name;
    private String position;
    private Date contractFrom;
    private Date contractTo;
    private String email;
    private String phone;

    public StafflistTable(Object[] array){
        name = (String)array[0];
        position = (String)array[1];
        contractFrom = (Date)array[2];
        contractTo = (Date)array[3];
        email = (String)array[4];
        phone = (String)array[5];
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public Date getContractFrom() {
        return contractFrom;
    }
    public void setContractFrom(Date contractFrom) {
        this.contractFrom = contractFrom;
    }
    public Date getContractTo() {
        return contractTo;
    }
    public void setContractTo(Date contractTo) {
        this.contractTo = contractTo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
