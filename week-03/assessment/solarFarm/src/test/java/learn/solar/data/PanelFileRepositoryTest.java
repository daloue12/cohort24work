package learn.solar.data;

import learn.solar.models.Material;
import learn.solar.models.Panel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PanelFileRepositoryTest {

    static final String SeedFilePath = "./data/solarFarm-seed.csv";
    static final String TestFilePath = "./data/solarFarm-test.csv";

    PanelFileRepository repository = new PanelFileRepository(TestFilePath);

    @BeforeEach
    void setUp() throws IOException {
        Path seedPath = Paths.get(SeedFilePath);
        Path testPath = Paths.get(TestFilePath);

        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void findBySection() throws DataException {
        List<Panel> actual = repository.findBySection("middle");
        assertEquals(1, actual.size());
        assertNotNull(actual);
    }

    @Test
    void add() throws DataException {
        Panel panel = new Panel();
        panel.setSection("upper");
        panel.setRow(1);
        panel.setColumn(2);
        panel.setMaterial(Material.AMORPHOUS_SILICON);
        panel.setTracking(false);

        Panel actual = repository.add(panel);
        assertEquals("upper", actual.getSection());
        assertEquals(1, actual.getRow());
        assertEquals(2, actual.getColumn());
        assertEquals(Material.AMORPHOUS_SILICON, actual.getMaterial());
        assertFalse(actual.isTracking());

        List<Panel> all = repository.findAll();
        assertEquals(2, all.size());
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findAll() {
    }
}