package view.actions;

import controller.CountryController;
import controller.SelectTransportController;
import controller.TransportController;
import exception.ExitException;
import org.springframework.stereotype.Component;

@Component("addCountry")
public class AddCountryAction extends BaseAction implements Action {

    public AddCountryAction(CountryController countryController, SelectTransportController selectTransportController, TransportController transportController) {
        super(countryController, selectTransportController, transportController);
    }

    @Override
    public void action() throws ExitException {
        countryController.addCity(writeInCountry());
    }

    @Override
    public String getName() {
        return "Добавить город в базу";
    }
}
