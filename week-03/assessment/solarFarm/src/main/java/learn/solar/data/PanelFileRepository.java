package learn.solar.data;

import learn.solar.models.Material;
import learn.solar.models.Panel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PanelFileRepository implements PanelRepository {
    private final String filePath;

    private final String delimiter = ",";

    public PanelFileRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Panel> findBySection(String section) throws DataException {
        List<Panel> all = findAll();
        List<Panel> result = new ArrayList<>();
        for (Panel panel : all) {
            if (panel.getSection().equalsIgnoreCase(section)) {
                result.add(panel);
            }
        }
        return result;
    }

    @Override
    public Panel add(Panel panel) throws DataException {
        List<Panel> all = findAll();
        int maxId = 0;
        for (Panel panels : all) {
            if (maxId < panels.getPanelId()) {
                maxId = panels.getPanelId() + 1;
            }
        }
        panel.setPanelId(maxId);
        all.add(panel);
        writeToFile(all);
        return panel;
    }

    @Override
    public boolean update(Panel panel) throws DataException {
        List<Panel> all = findAll();
        for (int i = 0; i < all.size(); i ++) {
            if (all.get(i).getPanelId() == panel.getPanelId()) {
                all.set(i, panel);
                writeToFile(all);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) throws DataException {
        List<Panel> all = findAll();
        for (int i = 0; i < all.size(); i ++) {
            if (all.get(i).getPanelId() == id) {
                all.remove(i);
                writeToFile(all);
                return true;
            }
        }
        return false;
    }

    private void writeToFile(List<Panel> panel) throws DataException {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (Panel panels : panel) {
                writer.println(serialize(panels));
            }
        } catch (IOException ex) {
            throw new DataException("Could not write to file path: " + filePath, ex);
        }
    }

    @Override
    public List<Panel> findAll() throws DataException {
        List<Panel> allPanels = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                Panel panel = deserialize(line);
                if (panel != null) {
                    allPanels.add(panel);
                }
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
            throw new DataException("Could not open the file path: " + filePath, ex);
        }
        return allPanels;
    }

    private String serialize(Panel panel) {
        StringBuilder string = new StringBuilder(100);
        string.append(panel.getPanelId()).append(delimiter);
        string.append(panel.getSection()).append(delimiter);
        string.append(panel.getRow()).append(delimiter);
        string.append(panel.getColumn()).append(delimiter);
        string.append(panel.getYear()).append(delimiter);
        string.append(panel.getMaterial()).append(delimiter);
        string.append(panel.isTracking());
        return string.toString();
    }

    private Panel deserialize(String line) {
        String[] fields = line.split(delimiter);
        if (fields.length != 7) {
            return null;
        } else {
            return new Panel(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), Material.valueOf(fields[5]),"true".equals(fields[6]));
        }
    }
}