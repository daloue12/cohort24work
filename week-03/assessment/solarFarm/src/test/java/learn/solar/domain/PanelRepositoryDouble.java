package learn.solar.domain;

import learn.solar.data.DataException;
import learn.solar.data.PanelRepository;
import learn.solar.models.Material;
import learn.solar.models.Panel;
import org.junit.jupiter.api.Test;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class PanelRepositoryDouble implements PanelRepository {

    private List<Panel> panels = new ArrayList<>();

    public PanelRepositoryDouble() {
        panels.add(new Panel(1, "top", 1, 1, 2000, Material.AMORPHOUS_SILICON, false));
        panels.add(new Panel(2, "top", 1, 2, 1999, Material.AMORPHOUS_SILICON, false));
        panels.add(new Panel(3, "bottom", 1, 1, 2000, Material.CADMIUM_TELLURIDE, true));
        panels.add(new Panel(4, "bottom", 1, 2, 1999, Material.CADMIUM_TELLURIDE, true));

    }


    @Override
    public List<Panel> findBySection(String section) throws DataException {
        List<Panel> results = new ArrayList<>();
        for (Panel p : panels) {
            if (p.getSection().equalsIgnoreCase(section)) {
                results.add(p);
            }
        }
        return results;
    }

    @Override
    public Panel add(Panel panel) throws DataException {
        panels.add(panel);
        return panel;
    }

    @Override
    public boolean update(Panel panel) throws DataException {
        return findBySection(panel.getSection()) != null;
    }

    @Override
    public boolean deleteById(int id) throws DataException {
        return id != 0;
    }

    @Override
    public List<Panel> findAll() throws DataException {
        return new ArrayList<>(panels);
    }
}