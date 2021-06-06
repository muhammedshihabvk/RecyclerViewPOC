package com.shabsudemy.recyclerviewpoc.MultiSelectionRecyclerView;

public class MultiSelectEmployeeModel {
    String name;
    int age;
    int registerNumber;
    boolean isChecked;

    public MultiSelectEmployeeModel(String name, int age, int registerNumber,boolean isChecked) {
        this.name = name;
        this.age = age;
        this.registerNumber = registerNumber;
        this.isChecked=isChecked;
    }

    public String getName() {
        return name;
    }

    public boolean isIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }
}
