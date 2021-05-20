class SpielerSchlau extends Spieler {

    SpielerSchlau(Spielblock block) {
        super(block);
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
            if(istBelegt(Spielblock.KNIFFEL) == false && meisteAnzahlAugen == 5) {
                getBlock().setWert(getRunde(), Spielblock.KNIFFEL, werte);
            }
            else if(istBelegt(Spielblock.VIERERPASCH) == false && meisteAnzahlAugen >= 4) {
                getBlock().setWert(getRunde(), Spielblock.VIERERPASCH, werte);
            }
            else if(istBelegt(Spielblock.DREIERPASCH) == false & meisteAnzahlAugen >= 3) {
                getBlock().setWert(getRunde(), Spielblock.DREIERPASCH, werte);
            }
            else if(istBelegt(Spielblock.FULLHOUSE) == false && meisteAnzahlAugen == 3 && fullHouse == true) {
                getBlock().setWert(getRunde(), Spielblock.FULLHOUSE, werte);
            }
            else if(istBelegt(Spielblock.GROSSESTRASSE) == false && meisteAnzahlAugen == 1 && (anzahlAugen[0] == 0 || anzahlAugen[5] == 0)) {
                getBlock().setWert(getRunde(), Spielblock.GROSSESTRASSE, werte);
            }
            else if(istBelegt(Spielblock.KLEINESTRASSE) == false && meisteAnzahlAugen <= 2 && nacheinander == 4) {
                getBlock().setWert(getRunde(), Spielblock.KLEINESTRASSE, werte);
                
            }
            else if(istBelegt(meisteAnzahlAugenzahl-1) == false) { // mAA = [max. = 5, min. = 1]
                getBlock().setWert(getRunde(), meisteAnzahlAugenzahl-1, werte);
            }
            else if(istBelegt(Spielblock.CHANCE) == false) {
                getBlock().setWert(getRunde(), Spielblock.CHANCE, werte);
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
    
    
                    getBlock().streichen(getRunde(), rnd);
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
    
    
                    getBlock().streichen(getRunde(), rnd);
                }
            }
        }
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
}