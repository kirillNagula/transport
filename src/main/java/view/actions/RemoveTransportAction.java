package view.actions;

import controller.CountryController;
import controller.SelectTransportController;
import controller.TransportController;
import exception.ExitException;
import model.Transport;
import org.springframework.stereotype.Component;
import view.Input;

@Component("removeTransport")
public class RemoveTransportAction extends BaseAction implements Action {

    public RemoveTransportAction(CountryController countryController, SelectTransportController selectTransportController, TransportController transportController) {
        super(countryController, selectTransportController, transportController);
    }

    @Override
    public void action() throws ExitException {
        transportController.removeTransport(new Transport(Input.getInt("Введите ID")));
    }

    @Override
    public String getName() {
        return "Удалить транспорт";
    }
}
