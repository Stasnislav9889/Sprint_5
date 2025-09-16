package tests;

import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FelineParameterizedTest {

    private Feline feline;

    @BeforeEach
    public void setUp() {
        feline = new Feline();
    }

    @ParameterizedTest
    @DisplayName("Проверка возврата количества котят с параметром")
    @ValueSource(ints = {1, 2, 9, 10})
    public void shouldReturnSameKittensCount(int count) {
        int actualCount = feline.getKittens(count);
        assertEquals(count, actualCount);
    }
}