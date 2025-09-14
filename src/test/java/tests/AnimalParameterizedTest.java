package tests;

import com.example.Animal;
import constants.AnimalKind;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static constants.ExceptionMessages.INVALID_KIND_EXCEPTION_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnimalParameterizedTest {

    Animal animal;

    @BeforeEach
    public void setUp() {
        animal = new Animal();
    }

    @ParameterizedTest
    @DisplayName("Проверка получения списка еды в зависимости от типа животного")
    @EnumSource()
    public void shouldReturnAnimalFoodList(AnimalKind animalKind) throws Exception {
        List<String> actualListFood = animal.getFood(animalKind.getAnimalKind());
        assertEquals(animalKind.getListFood(), actualListFood);
    }

    @ParameterizedTest
    @DisplayName("Проверка выброса исключения, если передан неизвестный тип животного")
    @MethodSource("utils.RandomGenerator#getRandomString")
    public void shouldThrowExceptionWhenInvalidGenderTest(String invalidGender) {
        Exception exception = assertThrows(Exception.class, () -> animal.getFood(invalidGender));
        assertEquals(INVALID_KIND_EXCEPTION_MESSAGE, exception.getMessage());
    }
}