import java.util.Arrays;

class SpielerDumm extends Spieler {


    SpielerDumm(Spielblock block) {
        super(block);
    }

    protected void entscheideBehalten(int[] werte, boolean[] behalten) {
        for(int i = 0 ; i < behalten.length ; i++) {
            behalten[i] = false;
        }
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


            getBlock().setSingleWert(getRunde(), rnd, 0);

        }
        else {
            System.out.println(Arrays.toString(werte));

            int rnd = random.nextInt(getBlock().getZeilen());
            do {
                rnd = random.nextInt(getBlock().getZeilen());
            }
            while(istBelegt(rnd) || rnd == 6);

            System.out.println(rnd);
    
            getBlock().setWert(getRunde(), rnd, werte);
        }


    }



}
