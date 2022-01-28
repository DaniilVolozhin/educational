package generating.prototype;

public class Prototype {
    private int x = 5;
    private int y = 10;

    public Prototype(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    protected Prototype clone() {
        return new Prototype(x, y);
    }

    public String toString() {
        return x + " " + y;
    }
}
