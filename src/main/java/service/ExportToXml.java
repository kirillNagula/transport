package service;

import model.DistanceInfo;
import model.DistanceInfoWrapper;
import model.Transport;
import model.TransportType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class ExportToXml implements Runnable {
    private List<DistanceInfo> distanceInfo;

    public ExportToXml(List<DistanceInfo> distanceInfo) {
        this.distanceInfo = distanceInfo;
    }


    public void exportService(List<DistanceInfo> distanceInfo) {
        DistanceInfoWrapper distanceInfoWrapper = new DistanceInfoWrapper(distanceInfo);
        try {
            JAXBContext context = JAXBContext.newInstance(DistanceInfoWrapper.class, DistanceInfo.class, Transport.class, TransportType.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(distanceInfoWrapper, new File("orders.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        exportService(distanceInfo);
    }
}
