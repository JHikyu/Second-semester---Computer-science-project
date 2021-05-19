public class Spieler extends Mitglied {
    private String spielposition;
    private int einsaetze;

    Spieler(String name, String vorname, String spielposition, int einsaetze) {
        super(name, vorname, 250000, 'S');
        this.spielposition = spielposition;
        this.einsaetze = einsaetze;
    }

    public int getJahresgehalt() {
        return super.getJahresgehalt() + (this.einsaetze * 10000);
    }
    public String getSpielposition() {
        return this.spielposition;
    }
    public int getEinsaetze() {
        return this.einsaetze;
    }
}
