package exception;

public class NoCityException extends Exception {

    public String getMessage(){
        return "Нет такого города в базе";
    }
}
