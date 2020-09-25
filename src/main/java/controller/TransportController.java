package controller;


import dao.DbCountryDao;
import dao.DbTransportDao;
import model.Transport;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransportController extends BaseController {

    public TransportController(DbCountryDao dbCountryDao, DbTransportDao dbTransportDao) {
        super(dbCountryDao, dbTransportDao);
    }

    public List<Transport> get(){
        return dbTransportDao.get();
    }

    public void addTransport(Transport transport){
        dbTransportDao.addTransport(transport);
    }

    public void editTransport(Transport transport){
        dbTransportDao.editTransport(transport);
    }

    public void removeTransport(Transport transport){
        dbTransportDao.removeTransport(transport);
    }
}
