package kiady;

import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;
import java.util.stream.Stream;

import kiady.Calculs;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 */
@RunWith(Parameterized.class)
public class TriTableauTest {

    void test() { fail("Not yet implemented"); }

    static Stream<Arguments> chargerJeuDeTestTriDecroissant() throws  Throwable
    {
        return Stream.of(
                Arguments.of(new int[]{4, 6, 3, 8, 0, 2}, new int[]{8, 6, 4, 3, 2, 0}),
                Arguments.of(new int[]{8, 6, 3, 8, 0, 1}, new int[]{8, 8, 6, 3, 1, 0}),
                Arguments.of(new int[]{4, 6, -3, 8, 0, 2}, new int[]{8, 6, 4, 2, 0, -3})
        );
    }

    static Stream<Arguments> chargerJeuDeTestTriCroissant() throws  Throwable
    {
        return Stream.of(
                Arguments.of(new int[]{4, 6, 3, 8, 0, 2}, new int[]{0, 2, 3, 4, 6, 8}),
                Arguments.of(new int[]{8, 6, 3, 8, 0, 1}, new int[]{0, 1, 3, 6, 8, 8}),
                Arguments.of(new int[]{4, 6, -3, 8, 0, 2}, new int[]{-3, 0, 2, 4, 6, 8})
        );
    }

    static Stream<Arguments> chargerJeuDeTestTrier() throws  Throwable
    {
        return Stream.of(
                Arguments.of(new int[]{4, 6, 3, 8, 0, 2}, new int[]{8, 6, 4, 3, 2, 0}),
                Arguments.of(new int[]{8, 6, 3, 8, 0, 1}, new int[]{8, 8, 6, 3, 1, 0}),
                Arguments.of(new int[]{4, 6, -3, 8, 0, 2}, new int[]{8, 6, 4, 2, 0, -3})
        );
    }

    @ParameterizedTest(name="TriCroissant numéro {index}: nombre1={0}, résultat attendu = {1}")
    @MethodSource("chargerJeuDeTestTriCroissant")
    void testTrieCroissant(int firstTab[], int expectedResult[])
    {
        // Partie paramétrée
        TriTableau monTri = new TriTableau();
        monTri.triCroissant(firstTab);
        assertArrayEquals(expectedResult, firstTab, "test en échec pour le tri de " + displayTab(firstTab) + " != " + displayTab(expectedResult));
    }

    @ParameterizedTest(name="TriDécroissant numéro {index}: nombre1={0}, résultat attendu = {1}")
    @MethodSource("chargerJeuDeTestTriDecroissant")
    void testTrieDecroissant(int firstTab[], int expectedResult[])
    {
        // Partie paramétrée
        TriTableau monTri = new TriTableau();
        monTri.triDecroissant(firstTab);
        assertArrayEquals(expectedResult, firstTab, "test en échec pour le tri de " + displayTab(firstTab) + " != " + displayTab(expectedResult));
    }

    @ParameterizedTest(name="Trier numéro {index}: nombre1={0}, résultat attendu = {1}")
    @MethodSource("chargerJeuDeTestTrier")
    void testTrier(int firstTab[], int expectedResult[]) throws IOException {
        // Partie paramétrée
        TriTableau monTri = new TriTableau();
        monTri.trier(firstTab);
        assertArrayEquals(expectedResult, firstTab, "test en échec pour le tri de " + displayTab(firstTab) + " != " + displayTab(expectedResult));
    }



    String displayTab(int tab[])
    {
        String result = "[";
        for (int i = 0; i < tab.length - 1; i++)
        {
            result += tab[i];
            if (i != tab.length - 2)
            {
                result += ",";
            }
        }
        result+="]";
        return result;
    }
}
