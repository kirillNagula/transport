package service;

import controller.CountryController;
import model.DistanceInfo;
import model.Transport;
import model.TransportInfo;

import java.util.ArrayList;
import java.util.List;

public class CalcOperationService {
    private List<Transport> transports;
    private TransportInfo transportInfo;
    private CountryController countryController = new CountryController();

    public CalcOperationService(List<Transport> transports, TransportInfo transportInfo) {
        this.transports = transports;
        this.transportInfo = transportInfo;
    }

    public CalcOperationService() {
    }

    //создается новые сущности которые хранят от и до
    public List<DistanceInfo> sortTransport(){
        CalcDistanceService calcDistanceService = countryController.getCoardinat(transportInfo);
        double distance = calcDistanceService.CalcDist(calcDistanceService);
        List<DistanceInfo> distanceInfo = new ArrayList<>();
        for (Transport transport: transports){
            distanceInfo.add(new DistanceInfo(transport,
                    distance,
                    (int)(transport.getPriceByKm()*distance),
                    transportInfo.getCityFrom(),
                    transportInfo.getCityTo(),
                    (double) Math.round((distance/transport.getSpeed()) *10)/10d));
        }
        return distanceInfo;
    }
}
