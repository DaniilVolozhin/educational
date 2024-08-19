package collection.list;

import collection.Car;
import collection.CarCollection;

public interface CarList extends CarCollection {

  Car get(int index);

  void add(Car car, int index);

  boolean removeAt(int index);
}
