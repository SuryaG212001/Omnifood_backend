package com.springrest.omnifood;

public class DevDB implements DB {
    @Override
    public String getData(){
        return "Dev data";
    }
}
