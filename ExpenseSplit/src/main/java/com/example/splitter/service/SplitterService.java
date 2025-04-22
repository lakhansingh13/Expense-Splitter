package com.example.splitter.service;

import com.example.splitter.model.ExpenseType;
import com.example.splitter.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SplitterService {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Map<String, Double>> balances = new HashMap<>();

    public void addUser(String id, String name) {
        users.put(id, new User(id, name));
    }

    public void addExpense(String paidBy, double amount, ExpenseType type, Map<String, Double> splits) {
        if (type == ExpenseType.EXACT) {
            for (Map.Entry<String, Double> entry : splits.entrySet()) {
                String user = entry.getKey();
                double share = entry.getValue();
                if (!user.equals(paidBy)) {
                    balances.computeIfAbsent(user, k -> new HashMap<>())
                            .merge(paidBy, share, Double::sum);
                }
            }
        }
    }

    public Map<String, Map<String, Double>> getBalances() {
        return balances;
    }

    public void settleDebt(String from, String to) {
        if (balances.containsKey(from)) {
            balances.get(from).remove(to);
        }
    }

    public Collection<User> getAllUsers() {
        return users.values();
    }
}
