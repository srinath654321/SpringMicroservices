package com.example.customerService.Model;

public class PaymentInfo {

    private final String cardNumber;
    private final String cvvNumber;

    public PaymentInfo(String cardNumber, String cvvNumber) {
        this.cardNumber = cardNumber;
        this.cvvNumber = cvvNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvvNumber() {
        return cvvNumber;
    }

    @Override
    public String toString() {
        return "PaymentInfo{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cvvNumber='" + cvvNumber + '\'' +
                '}';
    }
}
