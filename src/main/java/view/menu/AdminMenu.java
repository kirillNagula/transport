package view.menu;

import view.actions.*;

import java.util.HashMap;
import java.util.Map;

public class AdminMenu extends Menu {

    static {
        map.put(2, new ShowCountryAction());
        map.put(6, new ShowTransportAction());
        map.put(1, new TransportServicesAction());
        map.put(3, new AddCountryAction());
        map.put(4, new EditCountryAction());
        map.put(5, new RemoveCountryAction());
        map.put(7, new AddTransportAction());
        map.put(8, new EditTransportAction());
        map.put(9, new RemoveTransportAction());
        map.put(10, new MakeReportAction());
        map.put(0, new ExitAction());
    }
}
