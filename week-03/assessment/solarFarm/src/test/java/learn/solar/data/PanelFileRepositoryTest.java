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
        assertEquals(2, actual.size());
        assertNotNull(actual);
    }

    @Test
    void shouldAddANewPanel() throws DataException {
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
        assertEquals(3, all.size());
    }

    @Test
    void update() throws DataException {
       Panel doesNotExist = new Panel();
       doesNotExist.setPanelId(1234);
       assertFalse(repository.update(doesNotExist));
    }

    @Test
    void shouldDeletePanelAndLowerTotalCountByOne() throws DataException {
        int count = repository.findAll().size();
        assertTrue(repository.findAll().size() == 2);
        repository.deleteById(1);
        assertTrue(repository.findAll().size() == 1);

    }

    @Test
    void shouldFindAllPanelsAndCorrectTotal() throws DataException {
        List<Panel> allPanels = repository.findAll();
        assertEquals(2, allPanels.size());
        assertNotEquals(1, allPanels.size());
    }
}