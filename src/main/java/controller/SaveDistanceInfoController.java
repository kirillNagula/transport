package controller;

import dao.DbDistanceInfoDao;
import model.DistanceInfo;
import service.ExportToXml;

import java.util.List;

public class SaveDistanceInfoController {
    private DbDistanceInfoDao distanceInfoDao = new DbDistanceInfoDao();


    public void addInfoToSql(DistanceInfo distanceInfo){
        distanceInfoDao.addDistanceInfo(distanceInfo);
    }

    private List<DistanceInfo> getOrder(){
        return distanceInfoDao.get();
    }

    public void reportToXml(){
        List<DistanceInfo> distanceInfo = getOrder();
        ExportToXml exportToXml = new ExportToXml(distanceInfo);
        new Thread(exportToXml).start();

    }

}
