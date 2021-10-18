package HW11;

import java.util.HashMap;
import java.util.Map;

public class LoginUtil {
    private static Map<String, String> loginData = new HashMap<>();


    static {
        loginData.put("baklajan241", "468s4afsas");
        loginData.put("login2", "password2");
        loginData.put("login3", "password3");
        loginData.put("login4", "password4");
        loginData.put("login5", "password5");
    }

    static boolean isUserAuthentic(String login, String password, String confirmPassword) {
        try {
            if (!password.equals(confirmPassword)) throw new WrongPasswordException("Confirm password doesn't match");
            isLoginValid(login);
            isPasswordValid(password);
            if (!password.equals(loginData.get(login))) throw new WrongPasswordException("Wrong password");
        } catch (WrongPasswordException | WrongLoginException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }

    private static void isLoginValid(String login) throws WrongLoginException{
        if (!login.matches("[a-zA-Z0-9|_]{5,20}") || !loginData.containsKey(login)) {
            throw new WrongLoginException("Wrong login");
        }
    }

    private static void isPasswordValid(String password) throws WrongPasswordException{
        if (!password.matches("[a-zA-Z0-9|_]{5,20}")) {
            throw new WrongLoginException("Incorrect password");
        }
    }

}
