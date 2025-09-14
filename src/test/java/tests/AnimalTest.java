package tests;

import com.example.Animal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static constants.CommonConstants.ANIMAL_FAMILY;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalTest {

    @Test
    @DisplayName("Проверка получения списка еды для {0}")
    public void shouldReturnAnimalFamily() {
        Animal animal = new Animal();
        String actualFamily = animal.getFamily();
        assertEquals(ANIMAL_FAMILY, actualFamily);
    }
}