package com.example.udanthui;

class Customer {
    private String firstName;
    private String lastName;
    private int burgers;

    public Customer(String firstName, String lastName, int burgers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.burgers = burgers;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBurgers() {
        return burgers;
    }

    public void setBurgers(int burgers) {
        this.burgers = burgers;
    }
}
