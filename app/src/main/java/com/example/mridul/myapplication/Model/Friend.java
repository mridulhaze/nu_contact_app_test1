package com.example.mridul.myapplication.Model;

/**
 * Created by mridul on 5/23/2018.
 */

public class Friend {
    public int id;
    public String name,address,phone,email,designation,department,status,c_status,d_status,date,group;


   /*
    public Friend(int id, String name, String address, String phone, String email, String designation, String department, String status, String c_status, String d_status, String date, String group) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.designation = designation;
        this.department = department;
        this.status = status;
        this.c_status = c_status;
        this.d_status = d_status;
        this.date = date;
        this.group = group;
    }

    */


    public Friend(int id, String name, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;

    }

    public Friend() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getC_status() {
        return c_status;
    }

    public void setC_status(String c_status) {
        this.c_status = c_status;
    }

    public String getD_status() {
        return d_status;
    }

    public void setD_status(String d_status) {
        this.d_status = d_status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    */
}
