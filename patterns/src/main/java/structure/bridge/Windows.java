package structure.bridge;

public class Windows implements Bridge {
    @Override
    public void startWifi() {
        System.out.println("Start Windows wifi");
    }

    @Override
    public void stopWifi() {
        System.out.println("Stop Windows wifi");
    }
}
