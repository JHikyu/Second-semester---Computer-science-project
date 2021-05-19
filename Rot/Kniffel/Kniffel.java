class Kniffel {
    private static Spieler[] alleSpieler = new Spieler[8];
    private static int turn = -1;
    private static int length = 0;


    public static void main(String[] args) {
        addSpieler("Hikyu");
    }

    public static boolean addSpieler(String name) {
        return addSpieler(new Spieler(name));
    }
    public static boolean addSpieler(Spieler spieler) {
        for(int i = 0 ; i < alleSpieler.length ; i++) {
            if(alleSpieler[i] == null) {
                alleSpieler[i] = spieler;
                length += 1;
                return true;
            }
        }
        return false;
    }

    public static Spieler getSpieler(int index) {
        if(index < length && index >= 0) {
            if(alleSpieler[index] != null)
                return alleSpieler[index];
        }
        return null;
    }
    public static Spieler getSpieler(String name) {
        for(int i = 0 ; i < length ; i++) {
            if(alleSpieler[i].getName() == name) {
                return alleSpieler[i];
            }
        }
        return null;
    }

    public static int nextTurn() {
        if(++turn > length)
            turn = 0;
        return turn;
    }
}