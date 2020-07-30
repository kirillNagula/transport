package view.actions;

import exception.ExitException;
import model.Transport;
import view.Input;

public class RemoveTransportAction extends BaseAction implements Action {

    @Override
    public void action() throws ExitException {
        transportController.removeTransport(new Transport(Input.getInt("Введите ID")));
    }

    @Override
    public String getName() {
        return "Удалить транспорт";
    }
}
