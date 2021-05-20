import java.util.Arrays;

class SpielerSchlau extends Spieler {


    SpielerSchlau(Spielblock block) {
        super(block);
    }

    protected void entscheideBehalten(int[] werte, boolean[] behalten) {
        int[] anzahlAugen = new int[6];
        for(int i = 0 ; i < werte.length ; i++) {
            anzahlAugen[werte[i]-1] += 1;
        }
        int meisteAnzahlAugen = -1;
        int meisteAnzahlAugenzahl = -1;
        for(int i = 0 ; i < anzahlAugen.length ; i++) {
            if(anzahlAugen[i] > meisteAnzahlAugen ) {
                meisteAnzahlAugen = anzahlAugen[i]; // aender biggest[wert] auf den wert vom neuen index
                meisteAnzahlAugenzahl = i+1;
            }
        }
        if(meisteAnzahlAugen > 2) {
            for(int i = 0 ; i < behalten.length ; i++) {
                if(werte[i] == meisteAnzahlAugenzahl) {
                    behalten[i] = true;
                }
            }
        }


        // for(int i = 0 ; i < behalten.length ; i++) {
        //     behalten[i] = false;
        // }
    }

    protected void entscheideFeld(int[] werte) {
        int[] anzahlAugen = new int[6];
        for(int i = 0 ; i < werte.length ; i++) {
            anzahlAugen[werte[i]-1] += 1;
        }
        int meisteAnzahlAugen = -1;
        int meisteAnzahlAugenzahl = -1;
        for(int i = 0 ; i < anzahlAugen.length ; i++) {
            if(anzahlAugen[i] > meisteAnzahlAugen ) {
                meisteAnzahlAugen = anzahlAugen[i]; // aender biggest[wert] auf den wert vom neuen index
                meisteAnzahlAugenzahl = i+1;
            }
        }
        int nacheinander = 0;
        for(int i = 0 ; i < anzahlAugen.length ; i++) {
            if(anzahlAugen[i] > 0)
                nacheinander += 1;
            else
                nacheinander = 0;
        }
        boolean fullHouse = false;
        for(int i = 0 ; i < anzahlAugen.length ; i++) {
            if(anzahlAugen[i] == 2 ) {
                fullHouse = true;
            }
        }

        // if kniffel nicht belegt
        if(getBlock().getZeilen() == 14) {
            if(istBelegt(getBlock().KNIFFEL) == false && meisteAnzahlAugen == 5) {
                getBlock().setWert(getRunde(), getBlock().KNIFFEL, werte);
            }
            else if(istBelegt(getBlock().VIERERPASCH) == false && meisteAnzahlAugen >= 4) {
                getBlock().setWert(getRunde(), getBlock().VIERERPASCH, werte);
            }
            else if(istBelegt(getBlock().DREIERPASCH) == false & meisteAnzahlAugen >= 3) {
                getBlock().setWert(getRunde(), getBlock().DREIERPASCH, werte);
            }
            else if(istBelegt(getBlock().FULLHOUSE) == false && meisteAnzahlAugen == 3 && fullHouse == true) {
                getBlock().setWert(getRunde(), getBlock().FULLHOUSE, werte);
            }
            else if(istBelegt(getBlock().GROSSESTRASSE) == false && meisteAnzahlAugen == 1 && (anzahlAugen[0] == 0 || anzahlAugen[5] == 0)) {
                getBlock().setWert(getRunde(), getBlock().GROSSESTRASSE, werte);
            }
            else if(istBelegt(getBlock().KLEINESTRASSE) == false && meisteAnzahlAugen <= 2 && nacheinander == 4) {
                getBlock().setWert(getRunde(), getBlock().KLEINESTRASSE, werte);
                
            }
            else if(istBelegt(meisteAnzahlAugenzahl-1) == false) { // mAA = [max. = 5, min. = 1]
                getBlock().setWert(getRunde(), meisteAnzahlAugenzahl-1, werte);
            }
            else if(istBelegt(getBlock().CHANCE) == false) {
                getBlock().setWert(getRunde(), getBlock().CHANCE, werte);
            } 
            else {
                // einer bis sechser checken und eintragen
                boolean letzteChanceGefunden = false;
                for(int i = 0 ; i <= 5 ; i++) {
                    if(istBelegt(i) == false && anzahlAugen[i] > 0) {
                        getBlock().setWert(getRunde(), i, werte);
                        letzteChanceGefunden = true;
                        break;
                    }
                }
                if(letzteChanceGefunden == false) {
                    // danach streichen
                    int rnd = random.nextInt(getBlock().getZeilen());
                    do {
                        rnd = random.nextInt(getBlock().getZeilen());
                    }
                    while(istBelegt(rnd) || rnd == 6);
    
    
                    getBlock().setSingleWert(getRunde(), rnd, 0);
                }
            }
        }
        else {
            if(istBelegt(meisteAnzahlAugenzahl-1) == false) { // mAA = [max. = 5, min. = 1]
                getBlock().setWert(getRunde(), meisteAnzahlAugenzahl-1, werte);
            }
            else {
                // einer bis sechser checken und eintragen
                boolean letzteChanceGefunden = false;
                for(int i = 0 ; i <= 5 ; i++) {
                    if(istBelegt(i) == false && anzahlAugen[i] > 0) {
                        getBlock().setWert(getRunde(), i, werte);
                        letzteChanceGefunden = true;
                        break;
                    }
                }
    
                if(letzteChanceGefunden == false) {
                    // danach streichen
                    int rnd = random.nextInt(getBlock().getZeilen());
                    do {
                        rnd = random.nextInt(getBlock().getZeilen());
                    }
                    while(istBelegt(rnd) || rnd == 6);
    
    
                    getBlock().setSingleWert(getRunde(), rnd, 0);
                }
            }
        }
    }
}