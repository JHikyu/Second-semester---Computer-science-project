class Spielblock {
    private int[][] punkte;

    public final static int LEER = -1;
    public final static int EINER = 0;
    public final static int ZWEIER = 1;
    public final static int DREIER = 2;
    public final static int VIERER = 3;
    public final static int FUENFER = 4;
    public final static int SECHSER = 5;
    public final static int BONUS = 6;
    public final static int DREIERPASCH = 7;
    public final static int VIERERPASCH = 8;
    public final static int FULLHOUSE = 9;
    public final static int KLEINESTRASSE = 10;
    public final static int GROSSESTRASSE = 11;
    public final static int KNIFFEL = 12;
    public final static int CHANCE = 13;

    Spielblock(int spalten, int zeilen) {
        this.punkte = new int[spalten][zeilen];

        //? Jede spalte (spielrunde)
        //? hat zeilen (einzelne punkt moeglichkeiten)

        for(int i = 0 ; i < spalten ; i++) {
            int[] zeile = new int[0];
            if(zeilen == 7)
                zeile = new int[] {LEER, LEER, LEER, LEER, LEER, LEER, LEER};
            if(zeilen == 14)
                zeile = new int[] {LEER, LEER, LEER, LEER, LEER, LEER, LEER, LEER, LEER, LEER, LEER, LEER, LEER, LEER};
            punkte[i] = zeile;
        }
    }
    public int getSpalten() {
        return punkte.length;
    }
    public int getZeilen() {
        return punkte[0].length;
    }
    public int getWert(int spalte, int position) {
        return this.punkte[spalte][position];
    }
    public int getSumme() {
        //? Alle felder der Karte zusammen
        int c = 0;
        for(int i = 0 ; i < this.punkte.length ; i++) {
            for(int x = 0 ; x < this.punkte[i].length ; x++) {
                c += this.punkte[i][x];
            }
        }
        return c;
    }
    public void setWert(int spalte, int position, int[] wert) {
        int sum = 0;
        int[] anzahlAugen = new int[6];
        for(int i = 0 ; i < wert.length ; i++) {
            anzahlAugen[wert[i]-1] += 1;
        }
        int meisteAnzahlAugen;
        int nacheinander;


        switch(position) {
            case EINER: 
            case ZWEIER:
            case DREIER:
            case VIERER:
            case FUENFER:
            case SECHSER:
                for(int i = 0 ; i < wert.length ; i++) {
                    if(wert[i] == position+1)
                        sum += wert[i];
                }
                this.punkte[spalte][position] = sum;
                break;
                
            //? Bonus kann nicht eingetragen werden
            case BONUS:
                break;
            case DREIERPASCH:
                //? zahl egal hauptsache 3 oder 4
                meisteAnzahlAugen = -1;
                for(int i = 0 ; i < anzahlAugen.length ; i++) {
                    if(anzahlAugen[i] > meisteAnzahlAugen ) {
                        meisteAnzahlAugen = anzahlAugen[i];
                    }
                }

                if(meisteAnzahlAugen >= 3) {
                    for(int i = 0 ; i < wert.length ; i++) {
                        sum += wert[i];
                    }
                    this.punkte[spalte][position] = sum;
                }
                else {
                    this.punkte[spalte][position] = 0;
                    break;
                }
                break;
            case VIERERPASCH:

                //? zahl egal hauptsache 3 oder 4
                meisteAnzahlAugen = -1;
                for(int i = 0 ; i < anzahlAugen.length ; i++) {
                    if(anzahlAugen[i] > meisteAnzahlAugen ) {
                        meisteAnzahlAugen = anzahlAugen[i]; // aender biggest[wert] auf den wert vom neuen index
                    }
                }

                // wenn wir wirklich einen pasch haben
                if(meisteAnzahlAugen >= 4) {
                    for(int i = 0 ; i < wert.length ; i++) {
                        sum += wert[i];
                    }
                    this.punkte[spalte][position] = sum;
                }
                else {
                    this.punkte[spalte][position] = 0;
                    break;
                }
                break;
            case FULLHOUSE:

                int c = 0; //? c sollte bei fullhouse 2 sein.
                for(int i = 0 ; i < anzahlAugen.length ; i++) {
                    if(anzahlAugen[i] > 1) {
                        c += 1;
                    }
                    else if(anzahlAugen[i] == 1) {
                        c = 0;
                        break;
                    }
                }

                //? Wenn c == 2 -> fullhouse!
                if(c == 2) {
                    this.punkte[spalte][position] = 25;
                }
                else {
                    this.punkte[spalte][position] = 0;
                }
                break;
            case KLEINESTRASSE:
                nacheinander = 0;                
                for(int i = 0 ; i < anzahlAugen.length ; i++) {
                    if(anzahlAugen[i] > 0)
                        nacheinander += 1;
                    else
                        nacheinander = 0;
                }
                if(nacheinander == 4) 
                    this.punkte[spalte][position] = 30;
                else
                    this.punkte[spalte][position] = 0; 
                break;
            case GROSSESTRASSE:
                nacheinander = 0;                
                for(int i = 0 ; i < anzahlAugen.length ; i++) {
                    if(anzahlAugen[i] > 0)
                        nacheinander += 1;
                    else
                        nacheinander = 0;
                }
                if(nacheinander == 5)
                    this.punkte[spalte][position] = 40;
                else {
                    this.punkte[spalte][position] = 0;
                }
                break;
            case KNIFFEL:
                //? zahl egal hauptsache 3 oder 4
                meisteAnzahlAugen = -1;
                for(int i = 0 ; i < anzahlAugen.length ; i++) {
                    if(anzahlAugen[i] > meisteAnzahlAugen ) {
                        meisteAnzahlAugen = anzahlAugen[i]; // aender biggest[wert] auf den wert vom neuen index
                    }
                }

                // wenn wir wirklich einen pasch haben
                if(meisteAnzahlAugen == 5) {
                    this.punkte[spalte][position] = 50;
                }
                else {
                    this.punkte[spalte][position] = 0;
                    break;
                }

                break;
            case CHANCE:
                for(int i = 0 ; i < wert.length ; i++) {
                    sum += wert[i];
                }
                this.punkte[spalte][position] = sum;
                break;
            default:
                break;

        }


        //? Wenn alle Einer, Zweier, Dreier, Vierer, F??nfer, Sechser summiert >=63 sind -> Bonus = 35, sofern Bonus noch leer ist
        if(punkte[spalte][EINER] + punkte[spalte][ZWEIER] + punkte[spalte][DREIER] + punkte[spalte][VIERER] + punkte[spalte][FUENFER] + punkte[spalte][SECHSER] >= 63) {
            punkte[spalte][BONUS] = 35;
        } else {
            punkte[spalte][BONUS] = 0;
        }


    }
    public void ausgeben(int spielerNummer) {

        System.out.printf("\t\tSpieler  %d - Spielblock\n        -------------------------------------------\n", spielerNummer);

        String spieleZeile = "        Spiel\t";
        for(int i = 0 ; i < getSpalten() ; i++) {
            spieleZeile += "Punkte\t";
        } 
        System.out.println(spieleZeile + "Anmerkungen");

        spieleZeile = "        Einer\t";
        for(int i = 0 ; i < getSpalten() ; i++) {
            spieleZeile += (punkte[i][EINER] == -1 ? " " : punkte[i][EINER]) + "\t";
        } 
        System.out.println(spieleZeile + "Nur Einer zaehlen");
        
        spieleZeile = "       Zweier\t";
        for(int i = 0 ; i < getSpalten() ; i++) {
            spieleZeile += (punkte[i][ZWEIER] == -1 ? " " : punkte[i][ZWEIER]) + "\t";
        } 
        System.out.println(spieleZeile + "Nur Zweier zaehlen");
        
        spieleZeile = "       Dreier\t";
        for(int i = 0 ; i < getSpalten() ; i++) {
            spieleZeile += (punkte[i][DREIER] == -1 ? " " : punkte[i][DREIER]) + "\t";
        } 
        System.out.println(spieleZeile + "Nur Dreier zaehlen");

        spieleZeile = "       Vierer\t";
        for(int i = 0 ; i < getSpalten() ; i++) {
            spieleZeile += (punkte[i][VIERER] == -1 ? " " : punkte[i][VIERER]) + "\t";
        } 
        System.out.println(spieleZeile + "Nur Vierer zaehlen");

        spieleZeile = "      Fuenfer\t";
        for(int i = 0 ; i < getSpalten() ; i++) {
            spieleZeile += (punkte[i][FUENFER] == -1 ? " " : punkte[i][FUENFER]) + "\t";
        } 
        System.out.println(spieleZeile + "Nur Fuenfer zaehlen");

        spieleZeile = "      Sechser\t";
        for(int i = 0 ; i < getSpalten() ; i++) {
            spieleZeile += (punkte[i][SECHSER] == -1 ? " " : punkte[i][SECHSER]) + "\t";
        } 
        System.out.println(spieleZeile + "Nur Sechser zaehlen");

        spieleZeile = "        Bonus\t";
        for(int i = 0 ; i < getSpalten() ; i++) {
            spieleZeile += (punkte[i][BONUS] == -1 ? " " : punkte[i][BONUS]) + "\t";
        }
        System.out.println(spieleZeile + "35 Punkte, wenn oben mindestends 63 Punkte");
         
        if(getZeilen() == 14) { 

            spieleZeile = "        -------------------------------------------\n  Dreierpasch\t";
            for(int i = 0 ; i < getSpalten() ; i++) {
                spieleZeile += (punkte[i][DREIERPASCH] == -1 ? " " : punkte[i][DREIERPASCH]) + "\t";
            } 
            System.out.println(spieleZeile + "Drei gleiche W??rfel ??? alle Augen z??hlen");
            
            spieleZeile = "  Viererpasch\t";
            for(int i = 0 ; i < getSpalten() ; i++) {
                spieleZeile += (punkte[i][VIERERPASCH] == -1 ? " " : punkte[i][VIERERPASCH]) + "\t";
            } 
            System.out.println(spieleZeile + "Vier gleiche W??rfel ??? alle Augen z??hlen");
            
            spieleZeile = "   Full House\t";
            for(int i = 0 ; i < getSpalten() ; i++) {
                spieleZeile += (punkte[i][FULLHOUSE] == -1 ? " " : punkte[i][FULLHOUSE]) + "\t";
            } 
            System.out.println(spieleZeile + "Drei gleiche und zwei gleiche W??rfel ??? 25 Punkte");

            spieleZeile = "Kleine Stra??e\t";
            for(int i = 0 ; i < getSpalten() ; i++) {
                spieleZeile += (punkte[i][KLEINESTRASSE] == -1 ? " " : punkte[i][KLEINESTRASSE]) + "\t";
            } 
            System.out.println(spieleZeile + "1-2-3-4, 2-3-4-5, 3-4-5-6 - 30 Punkte");

            spieleZeile = " Gro??e Stra??e\t";
            for(int i = 0 ; i < getSpalten() ; i++) {
                spieleZeile += (punkte[i][GROSSESTRASSE] == -1 ? " " : punkte[i][GROSSESTRASSE]) + "\t";
            } 
            System.out.println(spieleZeile + "1-2-3-4-5 oder 2-3-4-5-6 - 40 Punkte");

            spieleZeile = "      Kniffel\t";
            for(int i = 0 ; i < getSpalten() ; i++) {
                spieleZeile += (punkte[i][KNIFFEL] == -1 ? " " : punkte[i][KNIFFEL]) + "\t";
            } 
            System.out.println(spieleZeile + "F??nf gleiche W??rfel - 50 Punkte");

            spieleZeile = "       Chance\t";
            for(int i = 0 ; i < getSpalten() ; i++) {
                spieleZeile += (punkte[i][CHANCE] == -1 ? " " : punkte[i][CHANCE]) + "\t";
            }
            System.out.println(spieleZeile + "Alle Augen z??hlen");


        }




    }

    public void streichen(int spalte, int position) {
        this.punkte[spalte][position] = 0;
    }
    public int getRunde() {
        int runde = 0;
        for(int i = 0 ; i < getSpalten() ; i++) {

            boolean istVoll = true;

            for(int x = 0 ; x < getZeilen() ; x++) {
                if(getWert(i, x) == -1)
                    istVoll = false;
            }

            if(istVoll == false)
                return runde;

            runde += 1;

        }

        return runde;
    }
    public int kannEintragenCount(int runde, int[] wert) {
        int count = 0;


        for(int a = EINER ; a < punkte[runde].length ; a++) {


            //? einer bis sechser
            if(a >= EINER && a <= SECHSER) {
                int einerBisSechserCount = 0;
                for(int b = 0 ; b < wert.length ; b++)
                    if(wert[b] == a+1)
                        einerBisSechserCount += 1;
                if(punkte[runde][a] == LEER && einerBisSechserCount > 0)
                    count += 1;
            }

            //? dreier-/viererpasch
            if(a == DREIERPASCH || a == VIERERPASCH) { // dreierpasch index = 7, vierer.. = 8
                int[] anzahlAugen = new int[6];
                for(int i = 0 ; i < wert.length ; i++) {
                    anzahlAugen[wert[i]-1] += 1;
                }
                //? zahl egal hauptsache 3 oder 4
                int meisteAnzahlAugen = -1;
                for(int i = 0 ; i < anzahlAugen.length ; i++) {
                    if(anzahlAugen[i] > meisteAnzahlAugen ) {
                        meisteAnzahlAugen = anzahlAugen[i]; // aender biggest[wert] auf den wert vom neuen index
                    }
                }
                if(punkte[runde][a] == LEER && meisteAnzahlAugen >= a-4) {
                    count += 1;
                }
            }

            //? Kniffel
            if(a == KNIFFEL) { // index = 12
                int[] anzahlAugen = new int[6];
                for(int i = 0 ; i < wert.length ; i++) {
                    anzahlAugen[wert[i]-1] += 1;
                }
                int meisteAnzahlAugen = -1;
                for(int i = 0 ; i < anzahlAugen.length ; i++) {
                    if(anzahlAugen[i] >  meisteAnzahlAugen) {
                        meisteAnzahlAugen = anzahlAugen[i]; // aender biggest[wert] auf den wert vom neuen index
                    }
                }
                if(punkte[runde][a] == LEER && meisteAnzahlAugen == a-7) {
                    count += 1;
                }
            }

            //? Kleine strasse
            if(a == KLEINESTRASSE) {
                int[] counts = new int[6];
                for(int i = 0 ; i < wert.length ; i++) {
                    counts[wert[i]-1] += 1;
                }
                int[] anzahlAugen = new int[6];
                int nacheinander = 0;
                
                for(int i = 0 ; i < anzahlAugen.length ; i++) {
                    if(anzahlAugen[i] > 0)
                        nacheinander += 1;
                    else
                        nacheinander = 0;
                }
                if(punkte[runde][a] == LEER && nacheinander == 4)
                    count += 1;
            }


            //? Grosse strasse
            if(a == KLEINESTRASSE) {
                int[] counts = new int[6];
                for(int i = 0 ; i < wert.length ; i++) {
                    counts[wert[i]-1] += 1;
                }
                int[] anzahlAugen = new int[6];
                int nacheinander = 0;
                
                for(int i = 0 ; i < anzahlAugen.length ; i++) {
                    if(anzahlAugen[i] > 0)
                        nacheinander += 1;
                    else
                        nacheinander = 0;
                }
                if(punkte[runde][a] == LEER && nacheinander == 5)
                    count += 1;
            }

            //? Chance
            if(a == CHANCE) {
                if(punkte[runde][a] == LEER)
                    count += 1;
            }


        }


        return count;
    }
}