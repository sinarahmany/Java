package com.company;

public abstract class Staff {
    private  String fullname;
    private  int id;
    private String  typeofjob;

    public Staff() {
    }

    public Staff(String fullname, int id, String typeofjob, String shifts) {
        this.fullname = fullname;
        this.id = id;
        this.typeofjob = typeofjob;
        this.shifts = shifts;
    }

     private String shifts;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeofjob() {
        return typeofjob;
    }

    public void setTypeofjob(String typeofjob) {
        this.typeofjob = typeofjob;
    }

    public String getShifts() {
        return shifts;
    }

    public void setShifts(String shifts) {
        this.shifts = shifts;
    }
}
