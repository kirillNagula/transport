package view.actions;

import controller.SaveDistanceInfoController;
import exception.ExitException;

public class MakeReportAction implements Action{
    private SaveDistanceInfoController saveDistanceInfoController = new SaveDistanceInfoController();

    public void action() throws ExitException {
        saveDistanceInfoController.reportToXml();
    }

    public String getName() {
        return "Сгенерировать отчет";
    }
}
