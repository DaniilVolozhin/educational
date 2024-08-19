package servlets.methodForCorrectArgument;

import dao.DaoMock;
import servlets.exception.ArgumentIsNoCorrectException;
import servlets.exception.ArgumentIsNullException;

public class MethodCorrectArgument {
    private static DaoMock daoMock = DaoMock.getInstance();

    public static void isCorrectForLogic(String login, String pass) throws ArgumentIsNullException, ArgumentIsNoCorrectException {
        if (login == null || pass == null || login.isEmpty() || pass.isEmpty()) {
            throw new ArgumentIsNullException("login : " + (login==null? " не может быть пустой строкой " : login) +
                    ", pass : " + (pass==null? " не может быть пустой строкой " : pass));
        }


        if (login.trim().length() < 3 || pass.trim().length() < 3) {
            throw new ArgumentIsNoCorrectException("login : " + login + " и пароль : " + pass + " должны содежать минимум 3 символа");
        }


        for (int i = 0; i < login.length(); i++) {
            byte[] buff = login.getBytes();
            if (buff[i] < 65 && buff[i] > 122) {
                throw new ArgumentIsNoCorrectException("Используйте анлийский алфавит для создания логина");
            }
        }

        for (int i = 0; i < pass.length(); i++) {
            byte[] buff = pass.getBytes();
            if (buff[i] < 48 && buff[i] > 122) {
                throw new ArgumentIsNoCorrectException("Используйте цифры и анлийский алфавит для создания пароля");
            }
        }

        if (login.equals(pass)) {
            throw new ArgumentIsNoCorrectException("login не может быть равен паролю : login-" + login + "пароль-" + pass);
        }

    }

    public static void isCorrectForDao(String login) throws ArgumentIsNoCorrectException {
        for (String s : daoMock.keysProfile()) {
            if (login.equals(s)) {
                throw new ArgumentIsNoCorrectException("Такой логин уже сущетсвует: " + login);
            }
        }

    }

    public static Long parsingSum(String sum) throws ArgumentIsNoCorrectException {
        if (sum.equals("NaN")) {
            throw new ArgumentIsNoCorrectException(sum + " это не число");
        }
        if (sum.contains(".")) {
            throw new ArgumentIsNoCorrectException("Используйте целые числа");
        } else {
            try {
                return Long.parseLong(sum);
            } catch (Exception e) {
                throw new ArgumentIsNoCorrectException("Не корректное число -" + e.getMessage());
            }
        }
    }
}
