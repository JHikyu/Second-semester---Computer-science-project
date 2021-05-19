import java.util.Random;

public class Wuerfel {
    private static Random random = new Random();

    private int zahl;
    private boolean abgelegt = false;

    Wuerfel() {}

    public boolean istAbgelegt() {
        return this.abgelegt;
    }

    public void setAblegen(boolean abgelegt) {
        this.abgelegt = abgelegt;
    }

    public int wuerfeln() {
        this.zahl = 1 + random.nextInt(6);
        return this.zahl;
    }

    public int getZahl() {
        return this.zahl;
    }
}
