import collection.Car;
import collection.list.CarArrayList;
import collection.list.CarList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mainnn {

    public static void main(String[] args) {
        var list = new ArrayList<String>(3);
        list.add(null);
        System.out.println(list.isEmpty());
        System.out.println(list.size() > 0);
        System.out.println(list);

        /*
        CarList carList = new CarArrayList();

        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }

        for (Car car : carList) {
            System.out.println(car.getBrand() + " " + car.getNumber());
        }
*/
    }

}
