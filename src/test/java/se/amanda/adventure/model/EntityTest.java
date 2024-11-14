package se.amanda.adventure.model;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    @org.junit.jupiter.api.Test
    @DisplayName("Should decrease subjects health with 3p")
    void testTakeHit() {
        Burglar burglar = new Burglar("burglar", 10, 5);
        Resident resident = new Resident("Amanda", 10, 3);
        burglar.takeHit(3);
        assertEquals(7, burglar.getHealth());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Should decrease subjects health with 5p")
    void testPunch() {
        Burglar burglar = new Burglar("burglar", 10, 5);
        Resident resident = new Resident("Amanda", 10, 3);
        burglar.punch(resident);
        assertEquals(5, resident.getHealth());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Should return true, subject is conscious")
    void testIsConscious() {
        Burglar burglar = new Burglar("burglar", 10, 5);
        Resident resident = new Resident("Amanda", 10, 3);
        burglar.punch(resident);
        assertTrue(resident.isConscious());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Should return false, subject is unconscious")
    void isConscious() {
        Burglar burglar = new Burglar("burglar", 10, 5);
        Resident resident = new Resident("Amanda", 10, 3);
        burglar.punch(resident);
        burglar.punch(resident);
        assertFalse(resident.isConscious());
    }

}