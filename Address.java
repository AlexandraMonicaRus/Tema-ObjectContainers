package com.assignment5.java;


public class Address {
    private String country;
    private String city;
    private String street;
    private String number;

    public Address(String country, String city, String street, String number) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "\n" + "Address {" +
                "country='" + country + '\'' +
                ", county='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
