package com.xuhh.foundation.reflection;


import org.springframework.context.annotation.Bean;


public class Config {
    @Bean
    public Customer customer(){
        return new Customer("xuhh","xuhh@123.com");
    }
    @Bean
    public Address address(){
        return new Address("345 spear street","945105");
    }
    @Bean
    public Message message(){
        return new Message("Hi there!");
    }
}
