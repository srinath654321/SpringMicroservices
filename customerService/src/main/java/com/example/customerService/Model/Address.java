package com.example.customerService.Model;

public class Address {

    private final String addressInfo;
    private final String state;
    private final int zipCode;
    private final String city;

    public Address(String addressInfo, String state, int zipCode, String city) {
        this.addressInfo = addressInfo;
        this.state = state;
        this.zipCode = zipCode;
        this.city = city;
    }


    public String getAddressInfo() {
        return addressInfo;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressInfo='" + addressInfo + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                ", city='" + city + '\'' +
                '}';
    }
}
