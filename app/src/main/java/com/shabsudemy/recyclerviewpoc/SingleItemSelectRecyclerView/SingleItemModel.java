package com.shabsudemy.recyclerviewpoc.SingleItemSelectRecyclerView;

public class SingleItemModel {

    private String Name;
    private boolean isChecked=false;
    private String regNumber;

    public SingleItemModel(String name, boolean isChecked, String regNumber) {
        Name = name;
        this.isChecked = isChecked;
        this.regNumber = regNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }
}
