package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;

import java.io.IOException;
import java.util.List;

public interface EncounterRepository {
    List<Encounter> findAll() throws DataAccessException;

    Encounter add(Encounter encounter) throws DataAccessException;

    boolean deleteById(int encounterId) throws DataAccessException;

    boolean update(Encounter encounter) throws DataAccessException;

    List findByType(EncounterType type) throws DataAccessException;
}
