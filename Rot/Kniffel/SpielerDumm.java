class SpielerDumm extends Spieler {

    SpielerDumm(Spielblock block) {
        super(block);
    }
    protected void entscheideFeld(int[] werte) {
        //? Wenn nichts eingetragen werden kann
        if(getBlock().kannEintragenCount(getRunde(), werte) == 0) {
            //? STREICHEN
            int rnd = random.nextInt(getBlock().getZeilen());
            do {
                rnd = random.nextInt(getBlock().getZeilen());
            }
            while(istBelegt(rnd) || rnd == 6);

            getBlock().streichen(getRunde(), rnd);
        }
        else {
            int rnd = random.nextInt(getBlock().getZeilen());
            do {
                rnd = random.nextInt(getBlock().getZeilen());
            }
            while(istBelegt(rnd) || rnd == 6);
    
            getBlock().setWert(getRunde(), rnd, werte);
        }
    }
    protected void entscheideBehalten(int[] werte, boolean[] behalten) {
        for(int i = 0 ; i < behalten.length ; i++) {
            behalten[i] = false;
        }
    }
}