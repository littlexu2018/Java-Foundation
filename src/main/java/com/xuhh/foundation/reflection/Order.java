package com.xuhh.foundation.reflection;

import org.springframework.beans.factory.annotation.Autowired;

public class Order {
    private  Address address;
    private  Customer customer;

    @Autowired
    public Order(Address address, Customer customer) {
        this.address = address;
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public Customer getCustomer() {
        return customer;
    }
}


