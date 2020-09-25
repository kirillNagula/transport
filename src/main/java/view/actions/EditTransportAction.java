package view.actions;

import controller.CountryController;
import controller.SelectTransportController;
import controller.TransportController;
import exception.ExitException;
import org.springframework.stereotype.Component;

@Component("editTransport")
public class EditTransportAction extends BaseAction implements Action {

    public EditTransportAction(CountryController countryController, SelectTransportController selectTransportController, TransportController transportController) {
        super(countryController, selectTransportController, transportController);
    }

    @Override
    public void action() throws ExitException {
        transportController.editTransport(writeInTransport());
    }

    @Override
    public String getName() {
        return "Изменить транспортную информацию";
    }
}
