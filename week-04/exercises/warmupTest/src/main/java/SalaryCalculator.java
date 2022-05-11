import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class SalaryCalculator {

    public static BigDecimal getGrossSalary(BigDecimal yearlySalary, LocalDate startDate) {
        if (yearlySalary == null || yearlySalary.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO;
        }

        if (startDate == null || startDate.getDayOfMonth() != 1) {
            throw new IllegalArgumentException();
        }

        LocalDate current = startDate;
        BigDecimal yearlyIncome = BigDecimal.ZERO;
        int months = 0;

        while (current.getYear() == startDate.getYear()) {
            yearlyIncome =yearlyIncome.add(yearlySalary.divide(new BigDecimal(12), 2, RoundingMode.HALF_UP));
            current = current.plusMonths(1);
            months ++;
            if (months == 3) {
                yearlySalary = yearlySalary.multiply(new BigDecimal("1.03")).setScale(2);
            }
            if (months == 6) {
                yearlySalary = yearlySalary.multiply(new BigDecimal("1.06")).setScale(2);
            }

        }
        return yearlyIncome;

    }
}
