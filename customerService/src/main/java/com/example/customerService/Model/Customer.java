package com.example.customerService.Model;

public class Customer {

    private final int custId;
    private final String name;
    private final Address address;
    private final PaymentInfo paymentInfo;
    private final String message;

    private Customer(CustomerBuilder customerBuilder) {
        this.custId = customerBuilder.custId;
        this.name = customerBuilder.name;
        this.address = customerBuilder.address;
        this.paymentInfo = customerBuilder.paymentInfo;
        this.message = customerBuilder.message;
    }

    public static class CustomerBuilder{

        private int custId;
        private String name;
        private Address address;
        private PaymentInfo paymentInfo;
        private String message;

        public CustomerBuilder setCustId(int custId) {
            this.custId = custId;
            return this;
        }

        public CustomerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public CustomerBuilder setPaymentInfo(PaymentInfo paymentInfo) {
            this.paymentInfo = paymentInfo;
            return this;
        }

        public CustomerBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }


    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public int getCustId() {
        return custId;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        if(this.message != null) {
            return "Customer{" +
                    "message='" + message + '\'' +
                    '}';
        }
        return "Customer{" +
                "custId=" + custId +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", paymentInfo=" + paymentInfo +
                ", message='" + message + '\'' +
                '}';
    }
}
