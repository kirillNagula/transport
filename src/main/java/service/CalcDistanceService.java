package service;

public class CalcDistanceService {
    private double latitudeFrom;
    private double longitudeFrom;
    private double latitudeTo;
    private double longitudeTo;
    private static final int RADIUS = 6371008;


    public CalcDistanceService(double latitudeFrom, double longitudeFrom, double latitudeTo, double longitudeTo) {
        this.latitudeFrom = latitudeFrom;
        this.longitudeFrom = longitudeFrom;
        this.latitudeTo = latitudeTo;
        this.longitudeTo = longitudeTo;
    }

    public double CalcDist(CalcDistanceService calcDistanceService){
        double radL1F = calcDistanceService.latitudeFrom;// * Math.PI / 180;
        double radL2F = calcDistanceService.longitudeFrom; //* Math.PI / 180;
        double radL1T = calcDistanceService.latitudeTo;// * Math.PI / 180;
        double radL2T = calcDistanceService.longitudeTo;// * Math.PI / 180;
        double dLat = (radL1F - radL1T) * Math.PI / 180;
        double dLon = (radL2F - radL2T) * Math.PI / 180;
        double rad = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(radL1F*Math.PI/180) * Math.cos(radL1T*Math.PI/180) * Math.sin(dLon/2) * Math.sin(dLon/2);
        double radDis = 2 * Math.atan2(Math.sqrt(rad), Math.sqrt(1 - rad));
        return  Math.ceil(radDis * RADIUS/1000);
    }

}
