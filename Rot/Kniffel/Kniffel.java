import java.util.Scanner;

class Kniffel {
    private static int SPALTEN = 3;
    private static int ZEILEN = 7;
    private static int SPIELERANZ = 2;
    private static Spieler[] spielerListe;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }
    public static void menu() {

        System.out.println("        | Kniffel |        ");
        System.out.println("===========================");
        System.out.print(" (1) Spiel starten\n (2) Spieler ["+SPIELERANZ+"] \n (3) Komplexitaet\n (4) Beenden\n > ");
        switch(sc.nextInt()) {
            case 1:
                spielerListe = new Spieler[SPIELERANZ];
                //? Initialisierung der Spieler


                System.out.print(" (1) Dumme Spieler\n (2) Schlaue Spieler\n > ");
                int auswahl;
                do {
                    auswahl = sc.nextInt();
                } while(auswahl != 1 && auswahl != 2);
                
                switch(auswahl) {
                    case 1:
                        for(int i = 0 ; i < SPIELERANZ ; i++) {
                            Spielblock spielblock = new Spielblock(SPALTEN, ZEILEN);
                            Spieler spieler = new SpielerDumm(spielblock);
                            spielerListe[i] = spieler;
                        }
                        game();
                        break;
                    case 2:
                        for(int i = 0 ; i < SPIELERANZ ; i++) {
                            Spielblock spielblock = new Spielblock(SPALTEN, ZEILEN);
                            Spieler spieler = new SpielerSchlau(spielblock);
                            spielerListe[i] = spieler;
                        }
                        game();
                        break;
                    default:
                        menu();
                        break;
                }
                
                break;
            case 2:
                System.out.println("\nSpielerzahl eingeben [2-8]");
                System.out.print("Neue Spieleranzahl: ");
                SPIELERANZ = sc.nextInt();
                while(SPIELERANZ < 2 || SPIELERANZ > 8) {
                    System.out.println("\nFalsche eingabe [2-8]");
                    System.out.print("Neue Spieleranzahl: ");
                    SPIELERANZ = sc.nextInt();
                }
                menu();
                break;
            case 3:
                System.out.print(" (1) Vereinfacht [Einer bis Sechster + Bonus]\n (2) Standard [Vereinfacht + Straßen, Kniffel, Full House, Paesche, Chance] \n > ");
                auswahl = sc.nextInt();
                switch(auswahl) {
                    case 1:
                        ZEILEN = 7;
                        menu();
                        break;
                    case 2:
                        ZEILEN = 14;
                        menu();
                        break;
                    default:
                        menu();
                        break;
                }

            case 4:
                System.exit(1);
                break;
            default:
                menu();
                break;
        }


    }
    public static void game() {

        //* spielerListe[0 bis SPIELERANZ-1]
        //* zug
        for (int i = 0; i < (ZEILEN==7?18:39); i++) {
            for(int x = 0; x < spielerListe.length; x++) {
                spielerListe[x].zugAusfuehren();
            }
        }

        //? Gebe alle spieler aus
        for(int x = 0; x < spielerListe.length; x++) {
            spielerListe[x].getBlock().ausgeben(x+1);
        }

        //? ins punkte
        Spieler gewinner = spielerListe[0];
        int gewinnerId = 0;
        for(int i = 0 ; i < spielerListe.length ; i++) {
            if(spielerListe[i].getBlock().getSumme() > gewinner.getBlock().getSumme()) {
                gewinner = spielerListe[i];
                gewinnerId = i;
            }
        }

        System.out.println("\nDer Gewinner ist Spieler "+(gewinnerId+1)+" mit einer Gesamtpunktzahl von "+gewinner.getBlock().getSumme()+"!\nHerzlichen Glückwunsch!");

    }
}