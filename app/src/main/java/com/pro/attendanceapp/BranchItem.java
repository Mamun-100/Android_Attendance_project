package com.pro.attendanceapp;

public class BranchItem {
    String branchName;
    String departmentName;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public BranchItem(String branchName, String departmentName) {
        this.branchName = branchName;
        this.departmentName = departmentName;
    }
}
