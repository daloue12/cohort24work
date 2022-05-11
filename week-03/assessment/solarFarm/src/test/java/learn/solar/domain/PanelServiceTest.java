package learn.solar.domain;

import learn.solar.data.DataException;
import learn.solar.data.PanelFileRepository;
import learn.solar.data.PanelRepository;
import learn.solar.models.Material;
import learn.solar.models.Panel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PanelServiceTest {
       private PanelRepository repository = new PanelRepositoryDouble();
        PanelService service = new PanelService(repository);


    @Test
    void shouldFindTwoExistingSections() throws DataException {
        List<Panel> actual = service.findBySection("top");
        assertEquals(2, actual.size());

        actual = service.findBySection("bottom");
        assertEquals(2, actual.size());

        actual  = service.findBySection("middle");
        assertEquals(0,actual.size());
    }
    @Test
    void shouldNotFindNonexistantSection() throws DataException {
        List<Panel> actual = service.findBySection("middle");
        assertEquals(0,actual.size());
    }

    @Test
    void ShouldAddValidPanel() throws DataException {
        Panel validPanel = new Panel(5, "bottom", 1, 3, 2020, Material.AMORPHOUS_SILICON,false);
        PanelResult result = service.add(validPanel);
        assertTrue(result.isSuccess());
    }

    @Test
    void ShouldNotAddInvalidPanel() throws DataException {
        Panel invalidPanel = new Panel(5, "bottom", 1, 1, 2020, Material.AMORPHOUS_SILICON,false);
        PanelResult result = service.add(invalidPanel);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotDeleteNonexistentPanel() throws DataException {
        PanelResult result = service.deleteById(1000);
        assertFalse(!result.isSuccess());
        PanelResult secondResult = service.deleteById(-1);
        assertFalse(!secondResult.isSuccess());
    }
    @Test
    void shouldDeleteExistingPanel() throws DataException {
        PanelResult result = service.deleteById(1);
        assertTrue(result.isSuccess());
    }

    @Test
    void shouldNotValidateInvalidPanel() throws DataException {
        Panel invalidPanel =  new Panel(10, "bottom", 1, 10, 2023, Material.AMORPHOUS_SILICON, false);
        PanelResult result = service.validate(invalidPanel);
        assertFalse(result.isSuccess());
        Panel secondInvalidPanel = new Panel(100, "top", 10, 251, 2000, Material.AMORPHOUS_SILICON, true);
        PanelResult secondResult = service.validate(secondInvalidPanel);
        assertFalse(secondResult.isSuccess());
    }

    @Test
    void shouldValidateValidPanel() throws DataException {
        Panel invalidPanel =  new Panel(10, "bottom", 1, 10, 2022, Material.AMORPHOUS_SILICON, false);
        PanelResult result = service.validate(invalidPanel);
        assertTrue(result.isSuccess());
    }
}