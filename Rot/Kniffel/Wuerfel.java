import java.util.Random;

public class Wuerfel {
    private static Random random = new Random();

    private int zahl;
    private boolean abgelegt = false;

    Wuerfel() {}

    public boolean isAbgelegt() {
        return this.abgelegt;
    }

    public int roll() {
        this.zahl = 1 + random.nextInt(6);
        return this.zahl;
    }

    public int getZahl() {
        return this.zahl;
    }
}
