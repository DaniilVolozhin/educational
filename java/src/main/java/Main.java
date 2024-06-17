import java.util.ArrayList;

public class Main {

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
