package view.actions;

import exception.ExitException;
import model.Country;
import view.Input;

public class RemoveCountryAction extends BaseAction implements Action{

    @Override
    public void action() throws ExitException {
        countryController.removeCity(new Country(Input.getInt("Введите Id для удаления")));
    }

    @Override
    public String getName() {
        return "Удалить город";
    }
}
