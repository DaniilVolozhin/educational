package generating.builder;

public class ArchitectHouse {

    public static House getWoodHouse() {
        BuilderHouse builder = new BuilderHouse();
        builder.setWood(true);
        builder.setArea(50);
        return builder.getHouse();
    }

    public static House getRichHouse() {
        BuilderHouse builderHouse = new BuilderHouse();
        builderHouse.setArea(570);
        builderHouse.setWood(false);
        builderHouse.setELec(true);
        builderHouse.setPool(1000000, 300);
        builderHouse.setCountFloors(3);
        return builderHouse.getHouse();
    }
}
