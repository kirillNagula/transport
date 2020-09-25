package view.actions;

import controller.CountryController;
import controller.SelectTransportController;
import controller.TransportController;
import exception.ExitException;
import model.Country;
import org.springframework.stereotype.Component;
import view.Input;

@Component("removeCountry")
public class RemoveCountryAction extends BaseAction implements Action{

    public RemoveCountryAction(CountryController countryController, SelectTransportController selectTransportController, TransportController transportController) {
        super(countryController, selectTransportController, transportController);
    }

    @Override
    public void action() throws ExitException {
        countryController.removeCity(new Country(Input.getInt("Введите Id для удаления")));
    }

    @Override
    public String getName() {
        return "Удалить город";
    }
}
