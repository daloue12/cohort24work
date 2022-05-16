package learn.foraging.data;

import learn.foraging.models.Forager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ForagerFileRepositoryTest {

    @Test
    void shouldFindAll() {
        ForagerFileRepository repo = new ForagerFileRepository("./data/foragers.csv");
        List<Forager> all = repo.findAll();
        assertEquals(1000, all.size());
    }

    @Test
    void shouldFindByValidState() {
        ForagerFileRepository repo = new ForagerFileRepository("./data/foragers.csv");
        List<Forager> allByState = repo.findByState("CO");
        assertEquals(20, allByState.size());
    }

    @Test
    void shouldNotFindAnyByInvalidState() {
        ForagerFileRepository repo = new ForagerFileRepository("./data/foragers.csv");
        List<Forager> allByState = repo.findByState("NYY");
        assertEquals(0, allByState.size());
    }

    @Test
    void shouldFindByValidId() {
        ForagerFileRepository repo = new ForagerFileRepository("./data/foragers.csv");
        Forager actual = repo.findById("0e4707f4-407e-4ec9-9665-baca0aabe88c");
        assertTrue(actual.getFirstName().equalsIgnoreCase("Jilly"));
        assertTrue(actual.getLastName().equalsIgnoreCase("Sisse"));
    }

    @Test
    void shouldNotFindByInvalidId() {
        ForagerFileRepository repo = new ForagerFileRepository("./data/foragers.csv");
        Forager actual = repo.findById("0e4707f4-407e-4ec9-123-9665-baca0654123be88c");
        assertTrue(actual == null);
    }


    @BeforeEach
    void setup() throws IOException {
        Path seedPath = Paths.get("./data/foragers-test-seed.csv");
        Path testPath = Paths.get("./data/foragers-test.csv");
        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }
    ForagerFileRepository repository = new ForagerFileRepository("./data/foragers-test.csv");
    @Test
    void shouldAddNewValidForager() throws DataException {
        Forager forager = new Forager();
        forager.setId(String.valueOf(UUID.randomUUID()));
        forager.setFirstName("Donkey");
        forager.setLastName("Kong");
        forager.setState("CO");

        Forager actual = repository.add(forager);
        assertEquals("Donkey", actual.getFirstName());
        assertEquals("Kong", actual.getLastName());
    }

    @Test
    void shouldNotAddInvalidForager() throws DataException {
        Forager forager = new Forager();
        forager.setId(String.valueOf(UUID.randomUUID()));
        forager.setFirstName(null);
        forager.setLastName("Parky");
        forager.setState("CO");

        List<Forager> all = repository.findAll();
        assertEquals(1, repository.findAll().size());
    }
}