package model;

public class TransportInfo {
    private String cityFrom;
    private String cityTo;
    private int numPassenger;
    private int numWeight;

    public TransportInfo(String cityFrom, String cityTo, int numPassenger, int numWeight) {
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.numPassenger = numPassenger;
        this.numWeight = numWeight;
    }

    public TransportInfo() {
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
}
