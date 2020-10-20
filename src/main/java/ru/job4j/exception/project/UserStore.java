package ru.job4j.exception.project;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User user : users) {
            if (user.getUserName().equals(login)) {
                result = user;
                break;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("User was not found");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUserName().length() < 3 || !user.isValid()) {
            throw new UserInvalidException("User is not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            ui.printStackTrace();
        } catch (UserNotFoundException uf) {
            uf.printStackTrace();
        }
    }
}