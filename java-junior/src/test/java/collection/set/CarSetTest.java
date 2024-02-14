package collection.set;

import collection.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarSetTest {

    private CarSet carSet;

    @BeforeEach
    public void init() {
        carSet = new CarHashSet();

        //add elem
        for (int i = 0; i < 100; i++) {
             carSet.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdd3SimilarObjetsThenSizeIncreaseBy1() {
        assertEquals(100, carSet.size());
        carSet.add(new Car("BMW", 100));
        carSet.add(new Car("BMW", 100));
        carSet.add(new Car("BMW", 100));
        assertEquals(101, carSet.size());
    }

    @Test
    public void whemElementRemovedThenSizeDecreased() {
        assertTrue(carSet.remove(new Car("Brand30", 30)));
        assertEquals(99, carSet.size());
        assertFalse(carSet.remove(new Car("Brand30", 30)));
        assertEquals(99, carSet.size());
    }

}