package ru.job4j.collection.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)){
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> value = users.get(user);
        for (Account found : value) {
            if (!found.getRequisite().equals(account.getRequisite())) {
                value.add(account);
            } else {
                System.out.println("Account already created");
            }
        }
    }

    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
            }
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        for (Account found : accounts) {
          if (found.getRequisite().equals(requisite)) {
              result = found;
          }
        }
        return result;
    }
}
