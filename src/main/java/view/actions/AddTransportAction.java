package view.actions;

import controller.CountryController;
import controller.SelectTransportController;
import controller.TransportController;
import exception.ExitException;
import org.springframework.stereotype.Component;

@Component("addTransport")
public class AddTransportAction extends BaseAction implements Action {

    public AddTransportAction(CountryController countryController, SelectTransportController selectTransportController, TransportController transportController) {
        super(countryController, selectTransportController, transportController);
    }

    @Override
    public void action() throws ExitException {
        transportController.addTransport(writeInTransport());
    }

    @Override
    public String getName() {
        return "Добавить новый транспорт";
    }
}
