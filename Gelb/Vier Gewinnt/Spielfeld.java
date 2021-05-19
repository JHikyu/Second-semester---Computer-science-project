class Spielfeld {
    private char[][] spielfeld = new char[6][7];
    private char leerZeichen = '.';


    Spielfeld() {}
    Spielfeld(int reihen, int spalten) {
        this.spielfeld = new char[reihen][spalten];
    }

    public void init() {
        for(int r = 0 ; r < this.spielfeld.length ; r++)
            for(int s = 0 ; s < this.spielfeld[r].length ; s++)
                this.spielfeld[r][s] = this.leerZeichen;
    }

    public void map() {
        System.out.println("\n");
        for(int r = 0 ; r < this.spielfeld.length ; r++) {
            System.out.print(r+1 + "| ");
            for(int s = 0 ; s < this.spielfeld[r].length ; s++) {
                System.out.printf("%c | ", this.spielfeld[r][s]);
            }
            System.out.println();
        }
        for(int r = 0 ; r < this.spielfeld.length ; r++)
            System.out.print("¯¯¯¯¯");
        System.out.print("\n ");
        for(int r = 0 ; r <= this.spielfeld.length ; r++)
            System.out.print(" ‌‌ " + (r+1) + " ");
    }

    public void put(Player p, int spalte) {
        if(spalte-1 >= this.spielfeld[0].length)
            return;

        //! From bottom to top
        for(int i = this.spielfeld.length-1 ; i >= 0 ; i--) {
            if(spielfeld[i][spalte-1] == this.leerZeichen) {
                this.spielfeld[i][spalte-1] = p.getZeichen();
                checkReihen(p);
                break;
            }
        }


    }

    public boolean checkReihen(Player p) {
        int richtige = 0;

        //! Links nach rechts
        for(int r = 0 ; r < this.spielfeld.length ; r++) {
            for(int s = 0 ; s < this.spielfeld[r].length ; s++) {
                if(this.spielfeld[r][s] == p.getZeichen()) {
                    richtige++;
                    if(richtige >= 4)
                        return true;
                }
                else {
                    richtige = 0;
                }
            }
            richtige = 0;
        }

        //! Oben nach unten
        for(int x = 0 ; x < this.spielfeld[0].length ; x++) {
            for(int i = 0 ; i < this.spielfeld.length ; i++) {
                if(this.spielfeld[i][x] == p.getZeichen()) {
                    richtige++;
                    if(richtige >= 4)
                        return true;
                }
                else {
                    richtige = 0;
                }
            }
            richtige = 0;
        }

        //! Diagonal von oben nach rechts
        for(int i = -5 ; i < this.spielfeld[0].length ; i++) {
            for(int x = 0 ; x < this.spielfeld[0].length ; x++) {
                if(x >= 0 && x < this.spielfeld.length && x+i >= 0 && x+i < this.spielfeld[x].length) {
                    if(this.spielfeld[x][x+i] == p.getZeichen()) {
                        richtige++;
                        if(richtige >= 4)
                            return true;
                    }
                    else {
                        richtige = 0;
                    }
                }
            }
            richtige = 0;
        }

        //! Diagonal von unten nach links
        for(int x = 5 ; x > -5 ; x--) {
            for(int i = 0 ; i < this.spielfeld[0].length-1 ; i++) {
                if(i >= 0 && i < this.spielfeld[0].length && this.spielfeld[0].length-1-i+x >= 0 && this.spielfeld[0].length-1-i+x <= this.spielfeld.length) {
                    if(this.spielfeld[i][this.spielfeld[0].length-1-i+x] == p.getZeichen()) {
                        richtige++;
                        if(richtige >= 4)
                            return true;
                    }
                    else {
                        richtige = 0;
                    }
                }
            }
            richtige = 0;
        }

        this.map();

        return false;
    }
    public void check(Player p, int zeile, int spalte) {
        int richtige = 0;
        System.out.println(zeile + " - " + spalte);

        //! Checke oben
        for(int i = zeile ; i > zeile-4 ; i--) {
            if(i >= 0 && i < this.spielfeld.length) {
                if(this.spielfeld[i][spalte] == p.getZeichen()) {
                    richtige++;
                }
            }
        }
        gewonnen(p, richtige);
        richtige = 0;

        //! Checke oben
        for(int i = zeile ; i < zeile+4 ; i++) {
            if(i >= 0 && i < this.spielfeld.length) {
                if(this.spielfeld[i][spalte] == p.getZeichen()) {
                    richtige++;
                }
            }
        }
        gewonnen(p, richtige);
        richtige = 0;

        //! Checke links
        for(int i = spalte ; i > spalte-4 ; i--) {
            if(i >= 0 && i < this.spielfeld[zeile].length) {
                if(this.spielfeld[zeile][i] == p.getZeichen()) {
                    richtige++;
                }
            }
        }
        gewonnen(p, richtige);
        richtige = 0;

        //! Checke rechts
        // for(int i = spalte ; i < spalte+4 ; i++) {
        // gewonnen(p, richtige);
        // richtige = 0;


        this.map();
    }
}
