package com.tejaswi.accessiblepayments;

public class Transaction {

    public String amount;
    public String merchant;

    public Transaction() {
        // Required for Gson
    }

    public Transaction(String amount, String merchant) {
        this.amount = amount;
        this.merchant = merchant;
    }
}
