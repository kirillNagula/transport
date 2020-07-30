package view.actions;


import model.Country;

import java.util.List;

public class ShowCountryAction extends BaseAction implements Action {

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
