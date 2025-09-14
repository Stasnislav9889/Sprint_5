package tests;

import com.example.Feline;
import com.example.Lion;
import constants.AnimalGender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static constants.ExceptionMessages.INVALID_GENDER_EXCEPTION_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class LionParameterizedTest {

    @Mock
    private Feline feline;

    @ParameterizedTest
    @DisplayName("Проверка зависимости hasMane от гендера при создании объекта Lion")
    @EnumSource
    public void checkHasManeInGenderTest(AnimalGender gender) throws Exception {
        Lion lion = new Lion(gender.getGender(), feline);
        Assertions.assertEquals(gender.doesHaveMane(), lion.doesHaveMane());
    }

    @ParameterizedTest
    @DisplayName("Проверка выброса исключения, если передан неизвестный гендер")
    @MethodSource("utils.RandomGenerator#getRandomString")
    public void shouldThrowExceptionWhenInvalidGenderTest(String invalidGender) {
        Exception exception = assertThrows(Exception.class, () -> new Lion(invalidGender, feline));
        assertEquals(INVALID_GENDER_EXCEPTION_MESSAGE, exception.getMessage());
    }
}