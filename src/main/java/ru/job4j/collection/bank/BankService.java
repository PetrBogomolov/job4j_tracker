package ru.job4j.collection.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(Optional<User> user) {
        if (!users.containsKey(user.get())) {
            users.put(user.get(), new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> value = users.get(user.get());
            boolean result = value.contains(account);
            if (!result) {
                value.add(account);
            }
        } else {
            System.out.println("User not found");
        }
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst();
    }

    public Account findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.map(value -> users.get(value).stream()
                .filter(e -> e.getRequisite().equals(requisite))
                .findFirst()
                .orElse(null)).orElse(null);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account sourse = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (sourse != null && dest != null) {
            if (amount <= sourse.getBalance()) {
                sourse.setBalance(sourse.getBalance() - amount);
                dest.setBalance(dest.getBalance() + amount);
                result = true;
            }
        } else {
            System.out.println("Account not found");
        }
        return result;
    }
}
