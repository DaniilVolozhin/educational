package generating.builder;

public class House {

    private boolean isWood;
    private boolean isElec;
    private int area = 10;
    private int countFloors = 1;

    public boolean isWood() {
        return isWood;
    }

    public void setWood(boolean wood) {
        isWood = wood;
    }

    public boolean isElec() {
        return isElec;
    }

    public void setElec(boolean elec) {
        isElec = elec;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getCountFloors() {
        return countFloors;
    }

    public void setCountFloors(int countFloors) {
        this.countFloors = countFloors;
    }

    public int getValuePool() {
        return valuePool;
    }

    public void setValuePool(int valuePool) {
        this.valuePool = valuePool;
    }

    public int getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(int areaPool) {
        this.areaPool = areaPool;
    }

    private int valuePool;
    private int areaPool;

    @Override
    public String toString() {
        return "House{" +
                "isWood=" + isWood +
                ", isElec=" + isElec +
                ", area=" + area +
                ", countFloors=" + countFloors +
                ", valuePool=" + valuePool +
                ", areaPool=" + areaPool +
                '}';
    }
}
