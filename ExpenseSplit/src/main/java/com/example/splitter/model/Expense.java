package com.example.splitter.model;

import java.util.Map;

public class Expense {
    private String paidBy;
    private double amount;
    private ExpenseType type;
    private Map<String, Double> splits; // userId → amount

    public Expense(String paidBy, double amount, ExpenseType type, Map<String, Double> splits) {
        this.paidBy = paidBy;
        this.amount = amount;
        this.type = type;
        this.splits = splits;
    }

    public String getPaidBy() { return paidBy; }
    public double getAmount() { return amount; }
    public ExpenseType getType() { return type; }
    public Map<String, Double> getSplits() { return splits; }
}
