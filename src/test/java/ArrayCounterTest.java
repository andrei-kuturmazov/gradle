import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Class for ArrayCounter test, using parameterized tests with Method and Class refer
 */

class ArrayCounterTest {

    @BeforeAll
    static void setUp() {
        System.out.println("BeforeAll annotation test");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("AfterAll annotation test");
    }

    private static Stream<Arguments> parameterizedInput() {
        return Stream.of(
                Arguments.of(3, new int[]{3}),
                Arguments.of(5, new int[]{5, -1, 4}),
                Arguments.of(-3, new int[]{-5, -3, -18}),
                Arguments.of(11, new int[]{5, 11, 11, 10, 0, -3}),
                Arguments.of(4, new int[]{2, 0, 4})
        );
    }

    static class Params implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(1, new int[] {3, 1, 1, 5, 7}),
                    Arguments.of(-1, new int[] {1, -1, 13, 4}),
                    Arguments.of(0, new int[] {5, 7, 19, 0}),
                    Arguments.of(-8, new int[] {-8, -1, -2, -2}),
                    Arguments.of(-5, new int[] {-5})
            );
        }
    }

    @ParameterizedTest
    @MethodSource("parameterizedInput")
    void findMaxTest(int result, int[] numbers) {
        assertEquals(result, ArrayCounter.findMax(numbers));
    }

    @ParameterizedTest
    @ArgumentsSource(Params.class)
    void findMinTest(int result, int[] numbers) {
        assertEquals(result, ArrayCounter.findMin(numbers));
    }

    @Test
        //Just for me
    void exceptionThrowTest() {
        assertThrows(NumberFormatException.class, ()-> {
            Integer.parseInt("Hello world");
        });
    }

    @Test
    @Disabled
    void disabledTest() {
        assertEquals(0, 1);
    }
}