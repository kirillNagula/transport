package view.actions;

import exception.ExitException;

public class AddCountryAction extends BaseAction implements Action {

    @Override
    public void action() throws ExitException {
        countryController.addCity(writeInCountry());
    }

    @Override
    public String getName() {
        return "Добавить город в базу";
    }
}
