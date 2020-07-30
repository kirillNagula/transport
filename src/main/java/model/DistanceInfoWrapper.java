package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement (name = "orders")
public class DistanceInfoWrapper {
    private List<DistanceInfo> distanceInfo;

    public DistanceInfoWrapper(List<DistanceInfo> distanceInfo) {
        this.distanceInfo = distanceInfo;
    }

    public DistanceInfoWrapper() {
    }

    @XmlElement(name = "order")
    public List<DistanceInfo> getDistanceInfo() {
        return distanceInfo;
    }

    public void setDistanceInfo(List<DistanceInfo> distanceInfo) {
        this.distanceInfo = distanceInfo;
    }
}
