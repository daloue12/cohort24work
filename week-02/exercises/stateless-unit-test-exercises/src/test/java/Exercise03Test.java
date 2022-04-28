import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise03Test {

    @Test
    void hasAllVowels() {
        assertEquals(false, Exercise03.hasAllVowels("hi"));
        assertEquals(false, Exercise03.hasAllVowels(null));
        assertEquals(true, Exercise03.hasAllVowels("eutopia"));
    }
}