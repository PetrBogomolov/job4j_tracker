package ru.job4j.collection.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> value = users.get(user);
            boolean result = value.contains(account);
            if (!result) {
                value.add(account);
            }
        } else {
            System.out.println("User not found");
        }
    }

    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(e -> e.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
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
