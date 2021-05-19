public class Spieler {
    private String name;
    private Karte karte = new Karte(this);
    private Wuerfel[] wuerfel = new Wuerfel[5];

    Spieler(String name) {
        this.name = name;

        for(int i = 0 ; i < this.wuerfel.length ; i++) {
            wuerfel[i] = new Wuerfel();
        }
    }

    public String getName() {
        return this.name;
    }

    public Karte getKarte() {
        return this.karte;
    }

    public void printKarte() {
        this.karte.print();
    }

    public void rollAll() {
        //? Gehe durch alle wuerfel vom Spieler
        for(int i = 0 ; i < this.wuerfel.length ; i++) {

            //? Wenn wuerfel nicht abgelegt -> rollen!
            if(wuerfel[i].isAbgelegt() == false)
                wuerfel[i].roll();
        }
    }

    public int getAugenzahl() {
        //? Zaehle alle augenzahlen auf
        int c = 0;
        for(int i = 0 ; i < this.wuerfel.length ; i++) {
            c += this.wuerfel[i].getZahl();
        }
        return c;
    }

}
