package view.actions;

import controller.SaveDistanceInfoController;
import exception.ExitException;
import exception.NoCityException;
import model.DistanceInfo;
import model.TransportInfo;
import view.Input;


public class TransportServicesAction extends BaseAction implements Action {
    private SaveDistanceInfoController saveDistanceInfoController = new SaveDistanceInfoController();

    @Override
    public void action() throws ExitException {
        String cityFrom = Input.getString("Введите город отправления");
        String cityTo = Input.getString("Введите город назначения");
        int numPassenger = Input.getInt("Введите кол-во пассажиров");
        int numWeight = Input.getInt("Введите кол-во груза");
        TransportInfo transportInfo = new TransportInfo(cityFrom, cityTo, numPassenger, numWeight);
        try {
            countryController.checkCity(transportInfo);//проверка нужных городов в базе
        } catch (NoCityException e) {
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            return;
    }
        selectTransportController.getTransportInfo(transportInfo);
        try {
            //вывод самого быстрого и создание его объекта
            System.out.println("Самый бвстрый транспорт для доставка " + numPassenger +" человек и " + numWeight + "кг. груза, с города " + cityFrom + " в город " + cityTo +
                    "\n- это " + selectTransportController.mostFaster().getTransport().getName() + ". Время пути " + selectTransportController.mostFaster().getTime() +
                    "ч. Стоимость " + selectTransportController.mostFaster().getPrice() + " тугриков.");
            System.out.println("-----");
            DistanceInfo fastDistance = new DistanceInfo();
            fastDistance.setCityFrom(cityFrom);
            fastDistance.setCityTo(cityTo);
            fastDistance.setDistance(selectTransportController.mostFaster().getDistance());
            fastDistance.setPrice(selectTransportController.mostFaster().getPrice());
            fastDistance.setTime(selectTransportController.mostFaster().getTime());
            fastDistance.setTransport(selectTransportController.mostFaster().getTransport());

            //вывод самого дешевого и создание его объекта
            System.out.println("Самый дешевый транспорт для доставка " + numPassenger +" человек и " + numWeight + "кг. груза, с города " + cityFrom + " в город " + cityTo +
                    "\n- это " + selectTransportController.mostCheaper().getTransport().getName() + ". Время пути " + selectTransportController.mostCheaper().getTime() +
                    "ч. Стоимость " + selectTransportController.mostCheaper().getPrice() + " тугриков.");
            System.out.println("-----");
            DistanceInfo cheapDistance = new DistanceInfo();
            cheapDistance.setCityFrom(cityFrom);
            cheapDistance.setCityTo(cityTo);
            cheapDistance.setDistance(selectTransportController.mostCheaper().getDistance());
            cheapDistance.setPrice(selectTransportController.mostCheaper().getPrice());
            cheapDistance.setTime(selectTransportController.mostCheaper().getTime());
            cheapDistance.setTransport(selectTransportController.mostCheaper().getTransport());

            //проверка, чтоб не записывать в бд и дешевые и быстрые, когда они одни и те же
            if (fastDistance.getTransport().getId() == cheapDistance.getTransport().getId()){
                saveDistanceInfoController.addInfoToSql(fastDistance);
            } else {
                saveDistanceInfoController.addInfoToSql(fastDistance);
                saveDistanceInfoController.addInfoToSql(cheapDistance);
            }
        } catch (Exception e){
            System.out.println("Нет варинтов для перевозки!");
        }

    }

    @Override
    public String getName() {
        return "Подбор транспорта";
    }
}
