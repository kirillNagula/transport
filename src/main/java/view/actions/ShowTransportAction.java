package view.actions;

import exception.ExitException;
import model.Transport;

import java.util.List;

public class ShowTransportAction extends BaseAction implements Action {

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
