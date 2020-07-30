package view.actions;

import exception.ExitException;

public interface Action {

    void action() throws ExitException;
    String getName();
}
