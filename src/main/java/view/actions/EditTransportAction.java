package view.actions;

import exception.ExitException;

public class EditTransportAction extends BaseAction implements Action {
    @Override
    public void action() throws ExitException {
        transportController.editTransport(writeInTransport());
    }

    @Override
    public String getName() {
        return "Изменить транспортную информацию";
    }
}
