package structure.bridge;

public class Main {
    public static void main(String[] args) {
        boolean isWindows = false;
        Bridge b;
        if (isWindows) {
            b = new Windows();
        } else {
            b = new Linux();
        }
        b.startWifi();
        b.stopWifi();
    }
}
