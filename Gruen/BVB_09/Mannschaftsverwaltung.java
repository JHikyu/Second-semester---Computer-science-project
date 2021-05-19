import java.util.Scanner;

class Mannschaftsverwaltung {


    public static void main(String[] args) {
        Mannschaft m = new Mannschaft("Ball-Verein Borussia Dortmund 09");
        menu(m);
    }


    public static void menu(Mannschaft m) {
        Scanner s = new Scanner(System.in);

        System.out.println("\nMannschaft: " + m.getVereinsname() + "\n\n");

        System.out.println("Typ\tName\t\tVorname\t\t\tJahresgehalt\tSonstiges");
        System.out.println("---------------------------------------------------------------------------------------------");
        for(int i = 0 ; i < m.length ; i++)
            System.out.println(m.getMitgliedInformation(i));

        System.out.println("\nSumme der Jahresgehaelter: \t\t" + m.summeJahresgehaelter());

        System.out.println("\nMenue: ");
            System.out.print("\t(A)rzt hinzufuegen\n\t(S)pieler hinzufuegen\n\t(T)rainer hinzufuegen\n\t(B)eenden\nAuswahl: ");
        String auswahl = s.next();
        hinzufuegen(m, auswahl);
    }
    public static void hinzufuegen(Mannschaft m, String auswahl) {
        Scanner s = new Scanner(System.in);
        String name, vorname;
        System.out.println(auswahl);

        switch (auswahl) {
            case "A":
                System.out.print("Vorname: ");
                vorname = s.next();
                System.out.print("Nachname: ");
                name = s.next();
                System.out.print("Fachgebiet: ");
                String fachgebiet = s.next();
                m.addMitglied(new Arzt(name, vorname, fachgebiet));
                break;
            case "S":
                System.out.print("Vorname: ");
                vorname = s.next();
                System.out.print("Nachname: ");
                name = s.next();
                System.out.print("Position: ");
                String position = s.next();
                System.out.print("Einsaetze: ");
                int einsaetze = s.nextInt();
                m.addMitglied(new Spieler(name, vorname, position, einsaetze));
                break;
            case "T":
                System.out.print("Vorname: ");
                vorname = s.next();
                System.out.print("Nachname: ");
                name = s.next();

                for(int i = 0 ; i < m.length ; i++) {
                    System.out.printf(" - (%d) %s %s\n", i+1, m.getMitglied(i).getVorname(), m.getMitglied(i).getName());
                }
                System.out.print("Lieblingsspieler: ");
                int lieblingszahl = s.nextInt();

                m.addMitglied(new Trainer(name, vorname, (Spieler) m.getMitglied(lieblingszahl-1)));
                break;
            case "B":
                System.exit(0);
                break;
            default:
                break;
        }
        menu(m);
    }


}
