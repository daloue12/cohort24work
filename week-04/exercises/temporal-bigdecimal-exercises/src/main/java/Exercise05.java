import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Exercise05 {

    // THE GODMOTHER
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. Your Godmother gives you $10 every other Friday throughout the year.
    // Payments start on the first Friday of the year.
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateGiftsTilEndOfYear(LocalDate date) {
        //Define the Fridays for a provided year
        int year = date.getYear();
        List<LocalDate> everyOtherFriday = new ArrayList<>();
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);

        while (startDate.compareTo(endDate) <= 0) {
            if (everyOtherFriday.size() == 0) {
                if (startDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                    everyOtherFriday.add(startDate);
                    startDate = startDate.plusWeeks(2);
                } else {
                    startDate = startDate.plusDays(1);
                }
            }
        }

        BigDecimal result = BigDecimal.ZERO;
        for (LocalDate friday : everyOtherFriday) {
            if(friday.compareTo(date) >= 0) {
                result = result.add(BigDecimal.TEN);
            }
        }
        return result;
    }

    // 2. Your Godmother is getting quirky. She adjusted her payment schedule.
    // She still pays every other Friday throughout the year, starting on the first Friday of the year.
    // But now, she pays a number of dollars equal to the day of the month.
    // Examples
    // Jan 31 == $31
    // Mar 1 == $1
    // July 12 == $12
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateQuirkyGiftsTilEndOfYear(LocalDate date) {
        return null;
    }

}
