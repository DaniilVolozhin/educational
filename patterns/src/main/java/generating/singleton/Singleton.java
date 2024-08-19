package generating.singleton;

public class Singleton {

    public int x;
    private static Singleton object;

    private Singleton() {
        this.x = 10;
    }

    public static Singleton getSingleton() {
        if (object == null) {
            object = new Singleton();
        }
        return object;
    }
}
