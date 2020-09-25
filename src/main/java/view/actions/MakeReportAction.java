package view.actions;

import controller.SaveDistanceInfoController;
import exception.ExitException;
import org.springframework.stereotype.Component;

@Component("report")
public class MakeReportAction implements Action{
    private SaveDistanceInfoController saveDistanceInfoController;

    public MakeReportAction(SaveDistanceInfoController saveDistanceInfoController) {
        this.saveDistanceInfoController = saveDistanceInfoController;
    }

    public void action() throws ExitException {
        saveDistanceInfoController.reportToXml();
    }

    public String getName() {
        return "Сгенерировать отчет";
    }
}
