package model;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;


public class DistanceInfo {
    private int id;
    private Transport transport;
    private double distance;
    private int price;
    private String cityFrom;
    private String cityTo;
    private double time;

    public DistanceInfo(Transport transport, double distance, int price, String cityFrom, String cityTo, double time) {
        this.transport = transport;
        this.distance = distance;
        this.price = price;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.time = time;
    }

    public DistanceInfo() {
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getTime() {
        return time;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "DistanceInfo{" +
                "transport=" + transport +
                ", distance=" + distance +
                ", price=" + price +
                ", cityFrom='" + cityFrom + '\'' +
                ", cityTo='" + cityTo + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistanceInfo that = (DistanceInfo) o;
        return transport.equals(that.transport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transport);
    }
}
