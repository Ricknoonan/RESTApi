package com.company.rest;

public class MyRequest {

    private User user;
    private Elevator elevator;
    private Building building;
    private String httpFunction;
    private int id;

    public String getHttpFunction(){
        return httpFunction;
    }

    public APIObjects getObject(){
        if(user != null){
            return user;
        }
        else if(elevator != null){
            return elevator;
        }
        else if(building != null){
            return building;
        }
        return null;
    }

    public int getId() {
        return id;
    }
}
