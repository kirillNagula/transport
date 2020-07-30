package model;

import java.util.Objects;

public class Country {
    private int id;
    private String name;
    private double latitude;
    private double longitude;
    private boolean isAirport;
    private boolean isSeaPort;

    public Country(int id, String name, double latitude, double longitude, boolean isAirport, boolean isSeaPort) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isAirport = isAirport;
        this.isSeaPort = isSeaPort;
    }

    public Country() {
    }

    public Country(int id) {
        this.id = id;
    }

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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isAirport() {
        return isAirport;
    }

    public void setAirport(boolean airport) {
        isAirport = airport;
    }

    public boolean isSeaPort() {
        return isSeaPort;
    }

    public void setSeaPort(boolean seaPort) {
        isSeaPort = seaPort;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", isAirport=" + isAirport +
                ", isSeaPort=" + isSeaPort +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
