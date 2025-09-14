package tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static constants.AnimalKind.PREDATOR;
import static constants.CommonConstants.KITTENS_DEFAULT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.RandomGenerator.getRandomGender;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Feline feline;

    private Lion lion;

    @BeforeEach
    public void setUp() throws Exception {
        lion = new Lion(getRandomGender(), feline);
    }

    @Test
    @DisplayName("Проверка вызова метода getKittens с параметром")
    public void shouldReturnOneKitten() {
        Mockito.when(feline.getKittens()).thenReturn(KITTENS_DEFAULT);
        int actualCount = lion.getKittens();
        assertEquals(KITTENS_DEFAULT, actualCount);
        Mockito.verify(feline).getKittens();
    }

    @Test
    @DisplayName("Проверка вызова метода getFood для Льва")
    public void shouldReturnFoodFromLion() throws Exception {
        Mockito.when(feline.getFood(PREDATOR.getAnimalKind())).thenReturn(PREDATOR.getListFood());
        List<String> actualFood = lion.getFood();
        assertEquals(PREDATOR.getListFood(), actualFood);
        Mockito.verify(feline).getFood(PREDATOR.getAnimalKind());
    }
}