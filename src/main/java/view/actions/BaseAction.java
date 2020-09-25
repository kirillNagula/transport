package view.actions;

import controller.CountryController;
import controller.SelectTransportController;
import controller.TransportController;
import model.Country;
import model.Transport;
import model.TransportType;
import view.Input;

public abstract class BaseAction {
    public CountryController countryController;
    public SelectTransportController selectTransportController;
    public TransportController transportController;

    public BaseAction(CountryController countryController, SelectTransportController selectTransportController, TransportController transportController) {
        this.countryController = countryController;
        this.selectTransportController = selectTransportController;
        this.transportController = transportController;
    }

    public Country writeInCountry(){
        int id = Input.getInt("Введите id");
        String name = Input.getString("Введите город!");
        double latitude = Input.getDouble("Введите широту");
        double longitude = Input.getDouble("Введите долготу");
        boolean isAirport = Input.getBoolean("Наличие аэропорта");
        boolean isSeaPort = Input.getBoolean("Наличие морского порта");
        return new Country(id, name,latitude, longitude, isAirport, isSeaPort);
    }

    public Transport writeInTransport(){
        int id = Input.getInt("Введите id");
        String name = Input.getString("Введите название!");
        int speed = Input.getInt("Введите скорость");
        int numPas = Input.getInt("Введите кол-во пассажиров");
        int numWeight = Input.getInt("Введите грузоподъемность");
        int price = Input.getInt("Стоимость одного км.");
        int type = Input.getInt("Введите тип транспорта");
        TransportType transportType = new TransportType(type);
        return new Transport(id, name, speed, numPas, numWeight, price, transportType);
    }
}
