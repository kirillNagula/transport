package exception;

public class NoUserException extends Exception {

    public String getMessage(){
        return "Неверный имя пользователя или пароль";
    }
}
