package by.kasakovich.springwebapp.model;

import java.sql.Date;


public class RoosterTable {
    private String nickname;
    private String firstname;
    private String surname;
    private String position;
    private Date birthday;
    private int weight;
    private int height;
    private String birthstate;

    public RoosterTable(Object[] array){
        nickname = (String)array[0];
        firstname = (String)array[1];
        surname = (String)array[2];
        position = (String)array[3];
        birthday = (Date)array[4];
        weight = (Integer)array[5];
        height = (Integer)array[6];
        birthstate = (String)array[7];
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String getBirthstate() {
        return birthstate;
    }
    public void setBirthstate(String birthstate) {
        this.birthstate = birthstate;
    }
}
