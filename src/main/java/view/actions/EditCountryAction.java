package view.actions;

import controller.CountryController;
import controller.SelectTransportController;
import controller.TransportController;
import exception.ExitException;
import org.springframework.stereotype.Component;

@Component("editCountry")
public class EditCountryAction extends BaseAction implements Action {

    public EditCountryAction(CountryController countryController, SelectTransportController selectTransportController, TransportController transportController) {
        super(countryController, selectTransportController, transportController);
    }

    @Override
    public void action() throws ExitException {
        countryController.editCity(writeInCountry());
    }

    @Override
    public String getName() {
        return "Изменение города";
    }
}
