package generating;

import generating.builder.ArchitectHouse;
import generating.builder.BuilderHouse;
import generating.builder.House;

public class Main {
    public static void main(String[] args) {

        BuilderHouse builderHouse = new BuilderHouse();
        builderHouse.setWood(true);
        builderHouse.setArea(50);
        House house = builderHouse.getHouse();
        System.out.println(house);


        System.out.println(ArchitectHouse.getRichHouse());
        System.out.println(ArchitectHouse.getWoodHouse());

    }
}
