package structure.bridge;

public class Linux implements Bridge {
    @Override
    public void startWifi() {
        System.out.println("Start Linux wifi");
    }

    @Override
    public void stopWifi() {
        System.out.println("Stop Linux wifi");
    }
}
