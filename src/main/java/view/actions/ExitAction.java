package view.actions;

import exception.ExitException;
import org.springframework.stereotype.Component;

@Component("exit")
public class ExitAction  implements Action {

    @Override
    public void action() throws  ExitException {
        throw new ExitException();
    }

    @Override
    public String getName() {
        return "Выход";
    }
}
