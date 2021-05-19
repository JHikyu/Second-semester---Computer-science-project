public class Trainer extends Mitglied {
    private Spieler lieblingsSpieler;
    private int gehalt = 170000;

    Trainer(String name, String vorname, Spieler lieblingsSpieler) {
        super(name, vorname, 170000, 'T');
        this.lieblingsSpieler = lieblingsSpieler;
    }

    public String getLieblingsSpielerName() {
        String s = "Keiner";

        if(this.lieblingsSpieler != null) {
            s = lieblingsSpieler.getVorname() + " " + lieblingsSpieler.getName();
        }

        return s;
    }
}
