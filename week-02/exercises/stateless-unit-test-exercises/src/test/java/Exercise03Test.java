import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise03Test {

    @Test
    void shouldFindAllVowels() {
        assertEquals(false, Exercise03.hasAllVowels("hi"));
        assertEquals(false, Exercise03.hasAllVowels("LKJLKASJDFLKJLAJKSDF"));
        assertEquals(false, Exercise03.hasAllVowels(null));
        assertEquals(true, Exercise03.hasAllVowels("eutopia"));
        assertEquals(true, Exercise03.hasAllVowels("EUTOPIA"));
        assertEquals(true, Exercise03.hasAllVowels("EUTO PIA"));
    }
}