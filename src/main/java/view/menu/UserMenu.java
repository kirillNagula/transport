package view.menu;

import view.actions.*;


public class UserMenu extends Menu  {

    static {
        map.put(2, new ShowCountryAction());
        map.put(3, new ShowTransportAction());
        map.put(1, new TransportServicesAction());
        map.put(0, new ExitAction());

    }
}
