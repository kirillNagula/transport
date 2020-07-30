package service;

import model.DistanceInfo;

import java.util.Comparator;

public class TimeComparator implements Comparator<DistanceInfo> {


    @Override
    public int compare(DistanceInfo o1, DistanceInfo o2) {
        return (int) (o1.getTime() - o2.getTime());
    }
}
