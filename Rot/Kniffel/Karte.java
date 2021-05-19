public class Karte {
    private int einer = 0;
    private int zweier = 0;
    private int dreier = 0;
    private int vierer = 0;
    private int fuenfer = 5;
    private int sechser = 0;
    private int bonus = 0;
    private Spieler spieler;

    Karte(Spieler spieler) {
        this.spieler = spieler;
    }

    public int nichtBelegt() {
        int c = 0;
        if(einer == 0) c++;
        if(zweier == 0) c++;
        if(dreier == 0) c++;
        if(vierer == 0) c++;
        if(fuenfer == 0) c++;
        if(sechser == 0) c++;
        if(bonus == 0) c++;
        return c;
    }
    public boolean vollBeschrieben() {
        return (nichtBelegt() == 0);
    }

    public int punkte() {
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

        if(this.punkte() > 0)
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
