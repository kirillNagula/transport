package service;

import model.DistanceInfo;

import java.util.Comparator;

public class PriceComparator implements Comparator<DistanceInfo> {
    @Override
    public int compare(DistanceInfo o1, DistanceInfo o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
