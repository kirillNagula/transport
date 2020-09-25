package controller;

import dao.DbDistanceInfoDao;
import model.DistanceInfo;
import org.springframework.stereotype.Component;
import service.ExportToXml;

import java.util.List;

@Component
public class SaveDistanceInfoController {
    private DbDistanceInfoDao distanceInfoDao;

    public SaveDistanceInfoController(DbDistanceInfoDao distanceInfoDao) {
        this.distanceInfoDao = distanceInfoDao;
    }

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
