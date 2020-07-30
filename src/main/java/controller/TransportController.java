package controller;


import model.Transport;

import java.util.List;

public class TransportController extends BaseController {

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
