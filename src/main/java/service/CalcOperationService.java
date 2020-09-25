package service;

import controller.CountryController;
import model.DistanceInfo;
import model.Transport;
import model.TransportInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CalcOperationService {
    private List<Transport> transports;
    private TransportInfo transportInfo;
    private CountryController countryController;

    public CalcOperationService(List<Transport> transports, TransportInfo transportInfo) {
        this.transports = transports;
        this.transportInfo = transportInfo;
    }

    @Autowired
    public CalcOperationService(CountryController countryController) {
        this.countryController = countryController;
    }

    //создается новые сущности которые хранят от и до
    public List<DistanceInfo> sortTransport(){
        CalcDistanceService calcDistanceService = countryController.getCoordinate(transportInfo);
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
