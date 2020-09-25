package view.actions;

import exception.ExitException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface Action {

    void action() throws ExitException;
    String getName();
}
