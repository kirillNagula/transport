package controller;

import dao.DbCountryDao;
import dao.DbTransportDao;

public abstract class BaseController {
    protected DbCountryDao dbCountryDao = new DbCountryDao();
    protected DbTransportDao dbTransportDao = new DbTransportDao();

}
