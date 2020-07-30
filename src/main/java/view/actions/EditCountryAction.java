package view.actions;

import exception.ExitException;

public class EditCountryAction extends BaseAction implements Action {

    @Override
    public void action() throws ExitException {
        countryController.editCity(writeInCountry());
    }

    @Override
    public String getName() {
        return "Изменение города";
    }
}
