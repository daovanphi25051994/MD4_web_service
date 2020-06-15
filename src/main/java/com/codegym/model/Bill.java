package com.codegym.model;

public class Bill {

    private int quantity;

    private float salary;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Bill(int quantity, float salary) {
        this.quantity = quantity;
        this.salary = salary;
    }
}