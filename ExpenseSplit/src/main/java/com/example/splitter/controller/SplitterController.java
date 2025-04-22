package com.example.splitter.controller;

import com.example.splitter.model.ExpenseType;
import com.example.splitter.model.User;
import com.example.splitter.service.SplitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SplitterController {

    @Autowired
    private SplitterService service;

    @PostMapping("/user")
    public String addUser(@RequestParam String id, @RequestParam String name) {
        service.addUser(id, name);
        return "User added successfully";
    }

    @PostMapping("/expense")
    public String addExpense(@RequestParam String paidBy,
                             @RequestParam double amount,
                             @RequestParam ExpenseType type,
                             @RequestBody Map<String, Double> splits) {
        service.addExpense(paidBy, amount, type, splits);
        return "Expense added successfully";
    }

    @GetMapping("/balances")
    public Map<String, Map<String, Double>> getBalances() {
        return service.getBalances();
    }

    @PostMapping("/settle")
    public String settle(@RequestParam String from, @RequestParam String to) {
        service.settleDebt(from, to);
        return "Debt settled between " + from + " and " + to;
    }

    @GetMapping("/users")
    public Collection<User> getAllUsers() {
        return service.getAllUsers();
    }
}