package view.actions;

import exception.ExitException;

public class AddTransportAction extends BaseAction implements Action {

    @Override
    public void action() throws ExitException {
        transportController.addTransport(writeInTransport());
    }

    @Override
    public String getName() {
        return "Добавить новый транспорт";
    }
}
