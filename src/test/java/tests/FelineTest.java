package tests;

import com.example.Feline;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static constants.AnimalKind.PREDATOR;
import static constants.CommonConstants.KITTENS_DEFAULT;
import static constants.CommonConstants.KITTENS_FAMILY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FelineTest {

    @Spy
    private Feline spyFeline;

    @Test
    @DisplayName("Проверка возврата списка еды для хищника")
    void shouldReturnListFoodForPredator() throws Exception {
        List<String> listFood = spyFeline.eatMeat();
        assertEquals(PREDATOR.getListFood(), listFood);
        verify(spyFeline).getFood(PREDATOR.getAnimalKind());
    }

    @Test
    @DisplayName("Проверка метода getFamily")
    void shouldReturnFelineFamily() {
        String actualFamily = spyFeline.getFamily();
        assertEquals(KITTENS_FAMILY, actualFamily);
    }

    @Test
    @DisplayName("Проверка возврата дефолтного количества котят")
    public void shouldCallGetKittensWithDefaultValue() {
        int actualCount = spyFeline.getKittens();
        assertEquals(KITTENS_DEFAULT, actualCount);
        verify(spyFeline).getKittens(KITTENS_DEFAULT);
    }
}