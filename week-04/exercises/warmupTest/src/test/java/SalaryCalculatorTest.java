import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SalaryCalculatorTest {

    @Test
    void shouldReturnZeroWithNoSalary() {
        BigDecimal salary = BigDecimal.ZERO;
        LocalDate startDate = LocalDate.of(2022,  12, 1);
        assertEquals(salary, SalaryCalculator.getGrossSalary(salary, startDate));
    }

    @Test
    void shouldThrowErrorIfNotStartOfMonth() {
        BigDecimal salary = BigDecimal.ZERO;
        LocalDate startDate = null;
        boolean IllegalArgumentException = false;

        assertEquals("IllegalArgumentException", SalaryCalculator.getGrossSalary(salary, null));
    }
}