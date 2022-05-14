package learn.foraging.domain;

import learn.foraging.data.DataException;
import learn.foraging.data.ForagerRepository;
import learn.foraging.models.Forager;
import learn.foraging.ui.ConsoleIO;
import learn.foraging.ui.Controller;

import java.util.List;
import java.util.stream.Collectors;

public class ForagerService {

    private final ForagerRepository repository;
    private static final List<String> validStateAbbreviations = List.of(new String[]{"WY", "WI", "WV", "WA", "VA", "VT", "UT", "TX", "TN", "SD", "SC", "RI", "PA", "OR", "OK", "OH", "ND", "NC", "NY", "NM", "NJ", "NH", "NV", "NE", "MT", "MO", "MS", "MN", "MI", "MA", "MD", "ME", "LA", "KY", "KS", "IA", "IN", "IL", "ID", "HI", "GA", "FL", "DE", "CT", "CO", "CA", "AR", "AZ", "AK", "AL"});

    public ForagerService(ForagerRepository repository) {
        this.repository = repository;
    }

    public List<Forager> findByState(String stateAbbr) {return repository.findByState(stateAbbr);}

    public List<Forager> findByLastName(String prefix) {
        return repository.findAll().stream()
                .filter(i -> i.getLastName().startsWith(prefix))
                .collect(Collectors.toList());
    }

    public Result<Forager> add(Forager forager) throws DataException {
        Result<Forager> result = validate(forager);
        if (!result.isSuccess()) {
            return result;
        }
        result.setPayload(repository.add(forager));
        return result;
    }

    private Result<Forager> validate(Forager forager) {
        Result<Forager> result = validateAllPossibleNullEntries(forager);
        if (!result.isSuccess()) {
            return result;
        } //TODO while this ensures that a valid forager is created, it does not ensure that a duplicate isn't created which still needs to be addressed.
        return result;
    }

    private Result<Forager> validateAllPossibleNullEntries(Forager forager) {
        Result<Forager> result = new Result<>();
        if (forager == null) {
            result.addErrorMessage("There is nothing to save.");
        }
        if (forager.getFirstName() == null) {
            result.addErrorMessage("Forager's first name is required.");
        }
        if (forager.getLastName() == null) {
            result.addErrorMessage("Forager's last name is required.");
        }
        if (forager.getState() == null) {
            result.addErrorMessage("Forager's state is required.");
        }
        return result;
    }

}
