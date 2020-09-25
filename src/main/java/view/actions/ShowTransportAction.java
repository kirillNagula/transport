package view.actions;

import controller.CountryController;
import controller.SelectTransportController;
import controller.TransportController;
import exception.ExitException;
import model.Transport;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("showTransport")
public class ShowTransportAction extends BaseAction implements Action {

    public ShowTransportAction(CountryController countryController, SelectTransportController selectTransportController, TransportController transportController) {
        super(countryController, selectTransportController, transportController);
    }

    @Override
    public void action() throws ExitException {
        List<Transport> transports = transportController.get();
        System.out.println("------");
        for (Transport transport: transports)
            System.out.println(transport);
        System.out.println("------");
    }

    @Override
    public String getName() {
        return "Вывести весь список транспорта";
    }
}
