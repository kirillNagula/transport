package controller;

import model.*;
import service.CalcOperationService;
import service.PriceComparator;
import service.TimeComparator;

import java.util.ArrayList;
import java.util.List;

public class SelectTransportController extends BaseController {
    private CalcOperationService calcOperationService;

    public SelectTransportController() {
    }

    public List<Transport> transportOptions(){
        return null;
    }



    public void getTransportInfo(TransportInfo transportInfo){
        Country countryFrom;
        countryFrom = dbCountryDao.getCityParameters(transportInfo.getCityFrom());
        Country countryTo;
        countryTo = dbCountryDao.getCityParameters(transportInfo.getCityTo());
        List<Transport> transports = new ArrayList<>();
        if (countryFrom.isAirport() && countryTo.isAirport()){
            transports.addAll(dbTransportDao.getWhereAirport(transportInfo.getNumPassenger(),transportInfo.getNumWeight()));
        }
        if (countryFrom.isSeaPort() && countryTo.isSeaPort()){
            transports.addAll(dbTransportDao.getWhereSeaPort(transportInfo.getNumPassenger(),transportInfo.getNumWeight()));
        }
        transports.addAll(dbTransportDao.getWhereRoad(transportInfo.getNumPassenger(),transportInfo.getNumWeight()));
        calcOperationService = new CalcOperationService(transports, transportInfo);

    }

    public DistanceInfo mostCheaper() throws  Exception {
        List<DistanceInfo> distanceInfo = calcOperationService.sortTransport();
        return distanceInfo.stream().min(new PriceComparator()).get();
    }

    public DistanceInfo mostFaster() throws  Exception {
        List<DistanceInfo> distanceInfo = calcOperationService.sortTransport();
        return distanceInfo.stream().min(new TimeComparator()).get();
    }
}
