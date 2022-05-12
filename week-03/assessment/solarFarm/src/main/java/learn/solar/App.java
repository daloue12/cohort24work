package learn.solar;

import learn.solar.data.DataException;
import learn.solar.data.PanelFileRepository;
import learn.solar.domain.PanelService;
import learn.solar.ui.Controller;
import learn.solar.ui.View;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws DataException {
        PanelFileRepository repository = new PanelFileRepository("data/solarFarm-production.csv");
        View view = new View();
        PanelService service = new PanelService(repository);
        Controller controller = new Controller(view, service);
        controller.run();
    }
}
