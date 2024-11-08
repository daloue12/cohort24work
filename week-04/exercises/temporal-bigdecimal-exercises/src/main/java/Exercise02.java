import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Exercise02 {

    // LocalTime
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. return the current time as a LocalTime
    LocalTime getNow() {

        return LocalTime.now();
    }

    // 2. return 4PM (tea time!) as a LocalTime.
    LocalTime getTeaTime() {
        return LocalTime.of(16, 0);
    }

    // 3. add 12 hours to the time parameter and return the value
    LocalTime add12Hours(LocalTime time) {
        return null;
    }

    // 4. given a time parameter, return a list of the next 4
    // quarter-hour appointments available after the time.
    // appointment times should not include seconds even if the time parameter does.
    // ignore seconds.
    // Examples:
    // time == 16:07:32
    // appointments == 16:15, 16:30, 16:45, 17:00
    //
    // time == 03:00:01
    // appointments == 03:00, 03:15, 03:30, 03:45
    //
    // time == 04:30:00
    // appointments == 04:30, 04:45, 05:00, 05:15
    List<LocalTime> getQuarterHourAppointments(LocalTime time) {
        List<LocalTime> appointments = new ArrayList<>();
        LocalTime startTime = LocalTime.of(time.getHour(), time.getMinute());
        while (true) {
            if (startTime.getMinute() % 15 > 0) {
                startTime = startTime.plusMinutes(1);
            }
            appointments.add(startTime);
            appointments.add(startTime.plusMinutes(15));
            appointments.add(startTime.plusMinutes(30));
            appointments.add(startTime.plusMinutes(45));
            return appointments;
        }
    }
}
