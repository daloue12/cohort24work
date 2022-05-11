import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Exercise01 {

    // LocalDate
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. return today's date
    LocalDate getToday() {

        return LocalDate.now();
    }

    // 2. return December 17, 1903 as a LocalDate
    LocalDate getFirstFlightDate() {

        LocalDate date = LocalDate.of(1903, Month.DECEMBER, 17);
        return date;
    }

    // 3. if parameter is in the future, return null.
    // Otherwise, add 5 days to the parameter and return the result.
    LocalDate makeFutureNullShiftThePast(LocalDate date) {
        if (date.isAfter(LocalDate.now())) {
            return null;
        } else {
            return date.plusDays(5);
        }
    }

    // 4. return the fifth Friday from the parameter date.
    // if the date is Friday, don't count it.
    LocalDate fiveFridaysFromDate(LocalDate date) {
        int numberOfFridays = 0;
        LocalDate startDate = date.plusDays(1);
        for (;numberOfFridays < 5; date = startDate.plusDays(1)) {
            if (startDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                numberOfFridays++;
            }
        }
        startDate = startDate.minusDays(1);
        return startDate;
    }

    // 5. given a date and a count,
    // return a list of the next `fridayCount` Fridays after the date.
    // if the date is Friday, don't include it.
    List<LocalDate> getNextFridays(LocalDate date, int fridayCount) {
        List<LocalDate> fridays = new ArrayList<>();
        LocalDate startDate = date.plusDays(1);

        while (fridays.size() < fridayCount) {
            if (startDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridays.add(startDate);
            }
            startDate = startDate.plusDays(1);
        }
        return fridays;
    }

    // 6. return the absolute value of the days between two dates.
    // one may be before two, two may be before one, but neither will be null
    int getDaysBetween(LocalDate one, LocalDate two) {
        long result = ChronoUnit.DAYS.between(one, two);
        if (result > Integer.MAX_VALUE) {
            throw new RuntimeException("Error");

        }
        return (int) ChronoUnit.DAYS.between(one, two);
    }

}
