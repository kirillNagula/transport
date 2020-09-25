package view.actions;


import controller.CountryController;
import controller.SelectTransportController;
import controller.TransportController;
import model.Country;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("showCountry")
public class ShowCountryAction extends BaseAction implements Action {

    public ShowCountryAction(CountryController countryController, SelectTransportController selectTransportController, TransportController transportController) {
        super(countryController, selectTransportController, transportController);
    }

    @Override
    public void action() {
        List<Country> countries = countryController.get();
        System.out.println("-------");
        for (Country country: countries){
            System.out.println(country);
        }
        System.out.println("-------");
    }

    @Override
    public String getName() {
        return "Вывести все города";
    }
}
