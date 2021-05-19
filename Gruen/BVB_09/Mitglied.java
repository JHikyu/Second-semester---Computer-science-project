public abstract class Mitglied {
    private String name;
    private String vorname;
    private int gehalt;
    private char typ;

    Mitglied(String name, String vorname, int gehalt, char typ) {
        this.name = name;
        this.vorname = vorname;
        this.gehalt = gehalt;
        this.typ = typ;
    }

    public char getTyp() {
        return this.typ;
    }
    public String getName() {
        return this.name;
    }
    public String getVorname() {
        return this.vorname;
    }
    public int getGehalt() {
        return this.gehalt;
    }
    public int getJahresgehalt() {
        return this.gehalt * 12;
    }

    public String getSpielposition() {
        return null;
    }

    public int getEinsaetze() {
        return -1;
    }

    public String getLieblingsSpielerName() {
        return null;
    }

    public String getFachgebiet() {
        return null;
    }
}
