package test;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Test {

@Test
void testExecutionTimeMeasurement() {
    List<Bogie> bogies = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
        bogies.add(new Bogie("T" + i, i % 200));
    }

    long start = System.nanoTime();
    List<Bogie> streamResult = Train.filterBogiesByCapacity(bogies, 60);
    long end = System.nanoTime();

    long elapsed = end - start;

    assertTrue(elapsed > 0);
    assertNotNull(streamResult);
}

@Test
void testLargeDatasetProcessing() {
    List<Bogie> bogies = new ArrayList<>();
    for (int i = 0; i < 100000; i++) {
        bogies.add(new Bogie("T" + i, i % 200));
    }

    List<Bogie> loopResult = filterWithLoop(bogies, 60);
    List<Bogie> streamResult = Train.filterBogiesByCapacity(bogies, 60);

    assertNotNull(loopResult);
    assertNotNull(streamResult);
    assertEquals(loopResult.size(), streamResult.size());
}

}