package com.daniel.server.beans;

public class Customer {
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private int amountOfChildren;


    public Customer(long id, String firstName, String lastName, String address, int amountOfChildren) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.amountOfChildren = amountOfChildren;
    }

    public Customer(String firstName, String lastName, String address, int amountOfChildren) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.amountOfChildren = amountOfChildren;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAmountOfChildren() {
        return amountOfChildren;
    }

    public void setAmountOfChildren(int amountOfChildren) {
        this.amountOfChildren = amountOfChildren;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", firstName=" + firstName + '\'' +
                ", lastName=" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", amountOfChildren=" + amountOfChildren +
                '}';
    }
}
