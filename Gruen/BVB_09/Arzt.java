public class Arzt extends Mitglied {
    private String fachgebiet;

    Arzt(String name, String vorname, String fachgebiet) {
        super(name, vorname, 15000, 'A');
        this.fachgebiet = fachgebiet;
    }

    public String getFachgebiet() {
        return this.fachgebiet;
    }
}
