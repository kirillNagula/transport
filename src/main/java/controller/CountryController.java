package controller;

import dao.DbCountryDao;
import dao.DbTransportDao;
import exception.NoCityException;
import model.Country;
import model.TransportInfo;
import org.springframework.stereotype.Component;
import service.CalcDistanceService;

import java.util.List;

@Component
public class CountryController extends BaseController {

    public CountryController(DbCountryDao dbCountryDao, DbTransportDao dbTransportDao) {
        super(dbCountryDao, dbTransportDao);
    }

    public List<Country> get(){
        return dbCountryDao.get();
    }

    public CalcDistanceService getCoordinate(TransportInfo transportInfo) {
        Country countryFrom = dbCountryDao.getCityParameters(transportInfo.getCityFrom());
        Country countryTo = dbCountryDao.getCityParameters(transportInfo.getCityTo());
        return new CalcDistanceService(countryFrom.getLatitude(),countryFrom.getLongitude(),countryTo.getLatitude(),countryTo.getLongitude());
    }

    public void checkCity(TransportInfo transportInfo) throws NoCityException {
        Country country = dbCountryDao.getCityParameters(transportInfo.getCityFrom());
        if (country.getName() == null){
            throw new NoCityException();
        }
        dbCountryDao.getCityParameters(transportInfo.getCityTo());
        if (country.getName() == null){
            throw new NoCityException();
        }
    }

    public void addCity(Country country){
        dbCountryDao.addCity(country);
    }

    public void editCity(Country country){
        dbCountryDao.editCity(country);
    }

    public void removeCity(Country country){
        dbCountryDao.removeCity(country);
    }
}
