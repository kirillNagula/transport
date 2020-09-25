package controller;

import dao.DbCountryDao;
import dao.DbTransportDao;

public abstract class BaseController {
    protected DbCountryDao dbCountryDao;
    protected DbTransportDao dbTransportDao;

    public BaseController(DbCountryDao dbCountryDao, DbTransportDao dbTransportDao) {
        this.dbCountryDao = dbCountryDao;
        this.dbTransportDao = dbTransportDao;
    }
}
