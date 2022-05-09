package learn.solar.ui;

import learn.solar.data.DataException;
import learn.solar.domain.PanelResult;
import learn.solar.domain.PanelService;
import learn.solar.models.Panel;

import javax.xml.crypto.Data;
import java.util.List;

public class Controller {

    private final View view;
    private final PanelService service;

    public Controller(View view, PanelService service) {
        this.view = view;
        this.service = service;
    }

    public void run() throws DataException {
        view.printHeader("Welcome to the Solar Farm!");
        try {
            boolean keepRunning = false;
            do {
                int option = view.chooseOptionFromMenu();
                switch(option) {
                    case 0:
                        keepRunning = true;
                        break;
                    case 1:
                        viewBySection();
                        break;
                    case 2:
                        addPanel();
                        break;
                    case 3:
                        updatePanel();
                        break;
                    case 4:
                        deletePanel();
                        break;
                }
            } while(!keepRunning);
        } catch (DataException ex) {
            view.printHeader("Error: " + ex.getMessage());
        }
        view.printHeader("Exiting. Have a nice day!");
    }

    public void viewBySection() throws DataException {
        view.printHeader("View Panels by Section");
        String userChoice = view.readSection();
        List<Panel> panels = service.findBySection(userChoice);
        view.printPanels(userChoice, panels);
    }

    private void addPanel() throws DataException {
        view.printHeader("Add Panel");
        Panel newPanel = view.makePanel();
        PanelResult result = service.add(newPanel);
        view.printResult(result);
    }

    private void updatePanel() throws DataException {
        view.printHeader("View Panels by Section & Update");
        String userChoice = view.readSection();
        List<Panel> panels = service.findBySection(userChoice);
        view.printPanels(userChoice, panels);
        Panel panel = view.choosePanel(panels);
        view.update(panel);
        PanelResult result = service.update(panel);
        view.printResult(result);
    }

    private void deletePanel() throws DataException {
    }
}
