package collection.list;

import collection.Car;

import java.util.Iterator;

public class CarLinkedList implements CarList {

  private Node first;
  private Node last;
  private int size;

  @Override
  public Car get(int index) {
    return getNode(index).value;
  }

  @Override
  public boolean add(Car car) {
    if (size == 0) {
      first = new Node(null, car, null);
      last = first;
    } else {
      Node oldLast = last;
      last = new Node(oldLast, car, null);
      oldLast.next = last;
    }
    size++;
    return true;
  }

  @Override
  public void add(Car car, int index) {
    if (index == size) {
      add(car);
      return;
    }
    Node nodeNext = getNode(index);
    Node nodePrevious = nodeNext.previous;
    Node newNode = new Node(nodePrevious, car, nodeNext);
    nodeNext.previous = newNode;
    if (nodePrevious != null) {
      nodePrevious.next = newNode;
    } else {
      first = newNode;
    }
    size++;
  }

  @Override
  public boolean remove(Car car) {
    int index = findElement(car);
    if (index != -1) {
      return removeAt(index);
    }
    return false;
  }

  @Override
  public boolean removeAt(int index) {
    Node node = getNode(index);
    Node nodeNext = node.next;
    Node nodePrevious = node.previous;
    if (nodeNext != null) {
      nodeNext.previous = nodePrevious;
    } else {
      last = nodePrevious;
    }
    if (nodePrevious != null) {
      nodePrevious.next = nodeNext;
    } else {
      first = nodeNext;
    }
    size--;

    return true;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void clear() {
    last = null;
    first = null;
    size = 0;
  }

  @Override
  public boolean contains(Car car) {
    return findElement(car) != -1;
  }

  private int findElement(Car car) {
    Node node = first;
    for (int i = 0; i < size; i++) {
      if (node.value.equals(car)) {
        return i;
      }
      node = node.next;
    }
    return -1;
  }

  private Node getNode(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node node = first;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }
    return node;
  }

  @Override
  public Iterator<Car> iterator() {
    return new Iterator<Car>() {

      private Node node = first;

      @Override
      public boolean hasNext() {
        return node != null;
      }

      @Override
      public Car next() {
        Car car = node.getValue();
        node = node.getNext();
        return car;
      }
    };
  }

  private static class Node {

    private Node previous;
    private Car value;
    private Node next;

    private Node(Node previous, Car value, Node next) {
      this.previous = previous;
      this.value = value;
      this.next = next;
    }

    public Node getPrevious() {
      return previous;
    }

    public void setPrevious(Node previous) {
      this.previous = previous;
    }

    public Car getValue() {
      return value;
    }

    public void setValue(Car value) {
      this.value = value;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }
  }

}
