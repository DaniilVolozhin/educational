package collection.set;

import collection.Car;

import java.util.Iterator;

public class CarHashSet implements CarSet {

  private static final int INITIAL_CAPACITY = 16;
  private static final double LOAD_FACTOR = 0.75;
  private int size = 0;
  private Entry[] array = new Entry[INITIAL_CAPACITY];

  @Override
  public boolean add(Car car) {
    if (size >= (array.length * LOAD_FACTOR)) {
      increaseArray();
    }
    boolean added = add(car, array);
    if (added) {
      size++;
    }
    return added;
  }

  public boolean add(Car car, Entry[] array) {
    int position = getElementPosition(car, array.length);
    if (array[position] == null) {
      Entry entry = new Entry(car, null);
      array[position] = entry;
      return true;
    } else {
      Entry existedElement = array[position];
      while (true) {
        if (existedElement.value.equals(car)) {
          return false;
        } else if (existedElement.next == null) {
          existedElement.next = new Entry(car, null);
          return true;
        } else {
          existedElement = existedElement.next;
        }
      }
    }
  }

  @Override
  public boolean remove(Car car) {
    int position = getElementPosition(car, array.length);

    if (array[position] == null) {
      return false;
    }

    Entry secondLast = array[position];
    Entry last = secondLast.next;

    if (secondLast.value.equals(car)) {
      array[position] = last;
      size--;
      return true;
    }

    while (last != null) {
      if (last.value.equals(car)) {
        secondLast.next = last.next;
        size--;
        return true;
      } else {
        secondLast = last;
        last = last.next;
      }
    }

    return false;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void clear() {
    array = new Entry[INITIAL_CAPACITY];
    size = 0;
  }

  @Override
  public boolean contains(Car car) {
    int position = getElementPosition(car, array.length);

    if (array[position] == null) {
      return false;
    }

    Entry secondLast = array[position];
    Entry last = secondLast.next;

    if (secondLast.value.equals(car)) {
      return true;
    }

    while (last != null) {
      if (last.value.equals(car)) {
        return true;
      } else {
        last = last.next;
      }
    }

    return false;
  }

  private int getElementPosition(Car car, int arrayLength) {
    return Math.abs(car.hashCode() % arrayLength);
  }

  private void increaseArray() {
    Entry[] newArray = new Entry[array.length * 2];
    for (Entry entry : array) {
      Entry existedElement = entry;
      while (existedElement != null) {
        add(existedElement.value, newArray);
        existedElement = existedElement.next;
      }
    }
  }

  @Override
  public Iterator<Car> iterator() {
    return new Iterator<Car>() {

      final int index = 0;
      final int arrayIndex = 0;
      Entry entry;

      @Override
      public boolean hasNext() {
        return false;
      }

      @Override
      public Car next() {
        return null;
      }
    };
  }

  private static class Entry {

    private final Car value;
    private Entry next;

    public Entry(Car value, Entry next) {
      this.value = value;
      this.next = next;
    }
  }
}
