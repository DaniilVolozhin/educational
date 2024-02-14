package generating.builder;

public class BuilderHouse {

    private House house;

    public BuilderHouse() {
        reset();
    }

    private void reset() {
        house = new House();
    }

    public void setWood(boolean isWood) {
        house.setWood(isWood);
    }

    public void setELec(boolean isElec) {
        house.setElec(isElec);
    }

    public void setArea(int area) {
        house.setArea(area);
    }

    public void setCountFloors(int countFloors) {
        house.setCountFloors(countFloors);
    }

    public void setPool(int valuePool, int areaPool) {
        house.setValuePool(valuePool);
        house.setAreaPool(areaPool);
    }

    public House getHouse() {
        return house;
    }
}
