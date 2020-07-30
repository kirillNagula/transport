package model;

import com.sun.xml.txw2.annotation.XmlAttribute;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

public class TransportType {
    private int id;
    private String name;
    private List<Transport> transports;

    public TransportType(int id, String name, List<Transport> transports) {
        this.id = id;
        this.name = name;
        this.transports = transports;
    }

    public TransportType(int id, String name) {
        this.id = id;
        this.name = name;
        this.transports = new ArrayList<>();
    }

    public TransportType(int id){
        this.id = id;
    }

    public TransportType() {
    }

    @XmlTransient
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "type_transport")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Transport> getTransports() {
        return transports;
    }

    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }

    @Override
    public String toString() {
        return "TransportType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
