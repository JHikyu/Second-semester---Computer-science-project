public class Karte {
    public final static int LEER=-1;
    public final static int EINER=0;
    public final static int ZWEIER=1;
    public final static int DREIER=2;
    public final static int VIERER=3;
    public final static int FUENFER=4;
    public final static int SECHSER=5;
    public final static int BONUS=6; //TODO - wenn sum min 63 dann bonus 35
    //private int[] werte = new int[] {LEER, LEER, LEER, LEER, LEER, LEER, LEER};

    private Spieler spieler;

    Karte(Spieler spieler) {
        this.spieler = spieler;
    }


    public int nichtBelegt() {
        int c = 0;
        if(einer <= 0) c++;
        if(zweier <= 0) c++;
        if(dreier <= 0) c++;
        if(vierer <= 0) c++;
        if(fuenfer <= 0) c++;
        if(sechser <= 0) c++;
        if(bonus <= 0) c++;
        return c;
    }
    public boolean vollBeschrieben() {
        return (nichtBelegt() == 0);
    }

    public int endPunkte() {
        return einer+zweier+dreier+vierer+fuenfer+sechser+bonus;
    }

    public void print() {
        System.out.printf("\nKarte von %s", this.spieler.getName());
        System.out.println("\n-------------------------");
        
        if(einer > 0)
            System.out.printf("\n(x) Einer:   %d", einer);
        if(zweier > 0)
            System.out.printf("\n(x) Zweier:  %d", zweier);
        if(dreier > 0)
            System.out.printf("\n(x) Dreier:  %d", dreier);
        if(vierer > 0)
            System.out.printf("\n(x) Vierer:  %d", vierer);
        if(fuenfer > 0)
            System.out.printf("\n(x) Fuenfer: %d", fuenfer);
        if(sechser > 0)
            System.out.printf("\n(x) Sechser: %d", sechser);
        if(bonus > 0)
            System.out.printf("\n(x) Bonus:   %d", bonus);

        if(this.endPunkte() > 0)
            System.out.println("\n-------------------------");

        if(einer <= 0)
            System.out.printf("\n( ) Einer:   %d", einer);
        if(zweier <= 0)
            System.out.printf("\n( ) Zweier:  %d", zweier);
        if(dreier <= 0)
            System.out.printf("\n( ) Dreier:  %d", dreier);
        if(vierer <= 0)
            System.out.printf("\n( ) Vierer:  %d", vierer);
        if(fuenfer <= 0)
            System.out.printf("\n( ) Fuenfer: %d", fuenfer);
        if(sechser <= 0)
            System.out.printf("\n( ) Sechser: %d", sechser);
        if(bonus <= 0)
            System.out.printf("\n( ) Bonus:   %d", bonus);
    }


}
