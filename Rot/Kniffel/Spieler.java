import java.util.*;

abstract class Spieler {
    private Spielblock block;
    private int[] wuerfel = new int[5];
    Random random = new Random();

    Spieler(Spielblock block) {
        this.block = block;
    }
    public Spielblock getBlock() {
        return this.block;
    }
    public void zugAusfuehren() {
        boolean[] behalten = new boolean[5]; // 5x false

        for (int i = 0; i < 3; i ++) {
            wuerfeln(wuerfel, behalten);

            if (i < 2) {
                entscheideBehalten(wuerfel, behalten);
            }
        }

        entscheideFeld(wuerfel);
    }
    abstract protected void entscheideBehalten(int[] werte, boolean[] behalten);
    abstract protected void entscheideFeld(int[] werte); 
    
    protected void wuerfeln(int[] werte, boolean[] behalten) {
        for(int i = 0 ; i < werte.length ; i++) {
            if(behalten[i] == false) {
                 werte[i] = 1 + random.nextInt(6);
            }
        }
    }
    public boolean istBelegt(int position) {
        if(getBlock().getWert(getRunde(), position) == -1)
            return false;
        return true;
    }
    public int getRunde() {
        int runde = 0;
        for(int i = 0 ; i < getBlock().getSpalten(); i++) {

            boolean istVoll = true;

            for(int x = 0 ; x < getBlock().getZeilen() ; x++) {
                if(getBlock().getWert(i, x) == -1)
                    istVoll = false;
            }

            if(istVoll == false)
                return runde;

            runde += 1;

        }

        return runde;
    }
}