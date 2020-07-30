package model;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;

public class Transport {
    private int id;
    private String name;
    private int speed;
    private int numPassenger;
    private int numWeight;
    private int priceByKm;
    private TransportType transportType;

    public Transport(int id, String name, int speed, int numPassenger, int numWeight, int priceByKm, TransportType transportType) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.numPassenger = numPassenger;
        this.numWeight = numWeight;
        this.priceByKm = priceByKm;
        this.transportType = transportType;
    }

    public Transport(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Transport() {
    }

    public Transport(int id) {
        this.id = id;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getNumPassenger() {
        return numPassenger;
    }

    public void setNumPassenger(int numPassenger) {
        this.numPassenger = numPassenger;
    }

    public int getNumWeight() {
        return numWeight;
    }

    public void setNumWeight(int numWeight) {
        this.numWeight = numWeight;
    }

    public int getPriceByKm() {
        return priceByKm;
    }

    public void setPriceByKm(int priceByKm) {
        this.priceByKm = priceByKm;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", numPassenger=" + numPassenger +
                ", numWeight=" + numWeight +
                ", priceByKm=" + priceByKm +
                ", transportType=" + transportType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return id == transport.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
