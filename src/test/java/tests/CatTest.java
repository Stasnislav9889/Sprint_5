package tests;

import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static constants.AnimalKind.PREDATOR;
import static constants.CommonConstants.CAT_SOUND;
import static constants.ExceptionMessages.INVALID_KIND_EXCEPTION_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    Feline mockFeline;

    Cat cat;

    @BeforeEach
    public void setUp() {
        cat = new Cat(mockFeline);
    }

    @Test
    @DisplayName("Проверка метода getSound")
    public void shouldReturnCorrectSoundTest() {
        String actualSound = cat.getSound();
        assertEquals(CAT_SOUND, actualSound);
    }

    @Test
    @DisplayName("Проверка метода getFood")
    public void shouldReturnFoodFromCatTest() throws Exception {
        when(mockFeline.eatMeat()).thenReturn(PREDATOR.getListFood());
        List<String> actualCatFood = cat.getFood();
        assertEquals(PREDATOR.getListFood(), actualCatFood);
        Mockito.verify(mockFeline).eatMeat();
    }

    @Test
    @DisplayName("Проверка выброса исключения в getFood")
    void shouldThrowExceptionWhenPredatorThrowsException() throws Exception {

        when(mockFeline.eatMeat()).thenThrow(new Exception(INVALID_KIND_EXCEPTION_MESSAGE));

        Exception exception = assertThrows(Exception.class, () -> cat.getFood());
        assertEquals(INVALID_KIND_EXCEPTION_MESSAGE, exception.getMessage());
        verify(mockFeline).eatMeat();
    }
}