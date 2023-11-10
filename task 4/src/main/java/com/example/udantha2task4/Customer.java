package com.example.udantha2task4;

class Customer {
    public String firstName;
    public String lastName;
    public int burgers;
    private int waiting;

    public Customer(String firstName, String lastName, int burgers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.burgers = burgers;
    }

    public int getWating(){
        return waiting;
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

    public void setWating(int cashier){
        this.waiting = cashier;
    }

}
