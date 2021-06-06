package com.shabsudemy.recyclerviewpoc.SwipeItemRecyclerView;

public class EmployeeModel {

    String name;
    int registerNum;

    public EmployeeModel(String name, int registerNum) {
        this.name = name;
        this.registerNum = registerNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegisterName() {
        return registerNum;
    }

    public void setRegisterName(int registerNum) {
        this.registerNum = registerNum;
    }
}
