import java.util.Scanner;

class VierGewinnt {
    static Scanner s = new Scanner(System.in);

    private static Player[] players = new Player[2];
    int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 }; 


    private static Spielfeld spielfeld = new Spielfeld();


    public static void main(String[] args) {
        players[0] = new Player("Spieler 1", 1);
        players[1] = new Player("Spieler 2", 2);
        game();
    }

    public static void game() {
        System.out.println("\t4 Gewinnt!\n--------------------------");
        System.out.print(" (1) Spiel starten\n (2) Einstellungen\n (3) Beenden\n");
        System.out.print(" > ");

        int auswahl = s.nextInt();
        switch(auswahl) {
            case 1:
                gameBegin();
                break;
            case 2:
                settings();
                break;
            case 3:
                System.out.println("\nAuf wiedersehen!");
                System.exit(0);
            default:
                game();
                break;
        }
    }
    public static void gameBegin() {
        spielfeld.init();
        spielfeld.map();

        int turn = 0;

        //! Turn Runde
        while(spielfeld.checkReihen(players[turn]) == false) {
            System.out.printf("\n\n%s is an der Reihe!\n", players[turn].getName());
            System.out.print("Platziere einen Stein: ");
            spielfeld.put(players[turn], s.nextInt());
            turn = turn==0 ? 1 : 0;
        }
        System.out.println("\n"+players[turn].getName() + " hat gewonnen!");

    }
    public static void settings() {
        System.out.println("\tEinstellungen\n--------------------------");
        System.out.print(" (1) "+players[0].getName()+" ["+players[0].getZeichen()+"]\n (2) "+players[1].getName()+" ["+players[1].getZeichen()+"]\n (3) Spielfeld groesse\n (4) Zurueck\n");
        System.out.print(" > ");
        switch(s.nextInt()) {
            case 1:
                setPlayer(0);
                break;
            case 2:
                setPlayer(1);
                break;
            case 3:
                setField();
                break;
            case 4:
                game();
            default:
                settings();
                break;
        }
    }
    public static void setPlayer(int i) {

        System.out.println("\tSpieler\n--------------------------");
        System.out.print(" Name: ");
        String name = s.next();
        System.out.print(" Zeichen: ");
        char zeichen = s.next().charAt(0);

        players[i] = new Player(name, i+1, zeichen);

        game();
        
    }
    public static void setField() {

        System.out.println("\tSpieler\n--------------------------");
        System.out.print(" Zeilen: ");
        int zeilen = s.nextInt();
        System.out.print(" Spalten: ");
        int spalten = s.nextInt();

        spielfeld = new Spielfeld(zeilen, spalten);

        game();
        
    }

}
