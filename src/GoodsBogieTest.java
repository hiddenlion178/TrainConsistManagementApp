import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GoodsBogieTest {

    private boolean isSafe(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical") ||
                                b.getCargo().equalsIgnoreCase("Petroleum")
                );
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );
        assertTrue(isSafe(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(isSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );
        assertTrue(isSafe(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal"),
                new GoodsBogie("Box", "Grain")
        );
        assertFalse(isSafe(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> bogies = new ArrayList<>();
        assertTrue(isSafe(bogies));
    }
}