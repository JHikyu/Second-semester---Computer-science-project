import java.util.Scanner;

class Tilgung {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        System.out.print("Darhelehnssumme (Euro): ");
        double darlehenssumme = s.nextDouble();
        
        System.out.print("Jahreszinssatz in Prozent: ");
        double jahreszinssatz = s.nextDouble();

        System.out.print("Annuitaetsrate (Euro pro Jahr): ");
        double annuitaetsrate = s.nextDouble();


        System.out.println("\nJahr\t\tZinsen\t\tTilgung\t\tRestschuld");
        System.out.println("==========================================================");

        double restschuld = darlehenssumme;
        int jahr = 1;
        while(restschuld > annuitaetsrate) {

            double zinsen = restschuld * (jahreszinssatz / 100);
            double tilgung = annuitaetsrate - zinsen;
            restschuld -= tilgung;

            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f \n", jahr++, zinsen, tilgung, restschuld);
        }

    }
}