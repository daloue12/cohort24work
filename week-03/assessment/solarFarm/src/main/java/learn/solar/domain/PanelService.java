package learn.solar.domain;

import learn.solar.data.DataException;
import learn.solar.data.PanelRepository;
import learn.solar.models.Panel;
import java.util.List;
public class PanelService {

    private final PanelRepository repository;
    public PanelService(PanelRepository repository) {
        this.repository = repository;
    }

    public List<Panel> findBySection(String section) throws DataException {
        return repository.findBySection(section);
    }

    public PanelResult add(Panel panel) throws DataException {
        PanelResult result = validate(panel);

        List<Panel> allPanels = repository.findAll();
        for(Panel test : allPanels) {
            if (panel.getSection().equals(test.getSection()) && panel.getRow() == test.getRow() && panel.getColumn() == test.getColumn()) {
                result.addMessages("A panel at already exists at that row, column, and section");
                return result;
            }
        }
        panel = repository.add(panel);
        result.setPanel(panel);
        System.out.println("Panel Added.");
        return result;
    }

    public PanelResult update(Panel panel) throws DataException {
        PanelResult result = validate(panel);

        if (panel.getPanelId() < 0) {
            result.addMessages("Solar panel 'id' is required and cannot be negative.");
        }
        if (result.isSuccess()) {
            if (repository.update(panel)) {
                result.setPanel(panel);
                System.out.printf("Panel %s has been updated%n", panel.getPanelId());
            } else {
                String message = String.format("Panel 'id' %s was not found.", panel.getPanelId());
                result.addMessages(message);
            }
        }
        return result;
    }

    public PanelResult deleteById(int panelId) throws DataException {
        PanelResult result = new PanelResult();
        boolean isDeleted = repository.deleteById(panelId);
        if (!isDeleted) {
            String message = String.format("Solar panel id %s was not found.", panelId);
            result.addMessages(message);
        }
        System.out.println();
        System.out.printf("Panel %s has been deleted", panelId);
        return result;
    }

    public PanelResult validate(Panel panel) throws DataException {
        PanelResult result = new PanelResult();

        if (panel == null) {
            result.addMessages("Solar panel cannot be null.");
        }
        if (panel.getSection() == null || panel.getSection().isBlank()) {
            result.addMessages("Solar panel 'section' is required.");
            return result;
        }
        if (panel.getYear() == null || panel.getYear().isBlank()) {
            result.addMessages("Solar panel's installation year is required.");
            return result;
        }
        if (panel.getRow() > 250 || panel.getRow() <= 0) {
            result.addMessages("Solar panel 'row' " + panel.getRow() + " is not in valid range [1-250].");
        }
        if (panel.getColumn() > 250 || panel.getColumn() <= 0) {
            result.addMessages("Solar panel 'column' " + panel.getColumn() + " is not in valid range [1-250].");
        }
        if (Integer.parseInt(panel.getYear()) > 2022) {
            result.addMessages("Solar panel 'year installed' is not in range [2022 or earlier].");
        }
        return result;
    }
}
