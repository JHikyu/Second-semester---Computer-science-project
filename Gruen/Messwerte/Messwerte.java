import java.util.Scanner;

class Messwerte {

    public static void main(String[] args) {
        
        //? Scanner initialisieren
        Scanner s = new Scanner(System.in);

        System.out.println("Wie viele Zahlen sollen eingelesen werden?\n > ");

        //? Solange Zahl einlesen, bis wir ueber 0 sind. Neuen int[] erstellen mit der Menge
        int menge;
        do {
            menge = s.nextInt();
        }
        while(menge < 1);
        int[] zahlenfolge = new int[menge];

        //? Zahlen 'menge' mal eintragen und Scanner schliessen
        System.out.println("Geben Sie nun " + menge + " Zahlen ein.");
        for(int i = 0 ; i < menge ; i++) {
            zahlenfolge[i] = s.nextInt();
        }
        s.close();

        System.out.println("Maximum = " + maximum(zahlenfolge));
        System.out.println("Minimum = " + minimum(zahlenfolge));
        System.out.println("Summe = " + summe(zahlenfolge));
        System.out.println("Mittelwert = " + mittelwert(zahlenfolge));
        System.out.println("Messwerte (vorwaerts): " + ausgeben(zahlenfolge));
        System.out.println("Messwerte (rueckwaerts): " + nebegsua(zahlenfolge));
    }

    public static int maximum(int[] zahlenfolge) {
        int max = zahlenfolge[0];
        for(int i = 0 ; i < zahlenfolge.length ; i++) {
            if(zahlenfolge[i] > max)
                max = zahlenfolge[i];
        }
        return max;
    }
    public static int minimum(int[] zahlenfolge) {
        int min = zahlenfolge[0];
        for(int i = 0 ; i < zahlenfolge.length ; i++) {
            if(zahlenfolge[i] < min)
                min = zahlenfolge[i];
        }
        return min;
    }
    public static int summe(int[] zahlenfolge) {
        int sum = 0;
        for(int i = 0 ; i < zahlenfolge.length ; i++) {
            sum += zahlenfolge[i];
        }
        return sum;
    }
    public static double mittelwert(int[] zahlenfolge) {
        return summe(zahlenfolge) / zahlenfolge.length;
    }
    public static String ausgeben(int[] zahlenfolge) {
        String s = "" + zahlenfolge[0];
        for(int i = 1 ; i < zahlenfolge.length ; i++) {
            s += " " + zahlenfolge[i];
        }
        return s;
    }
    public static String nebegsua(int[] zahlenfolge) {
        String s = "";
        for(int i = zahlenfolge.length-1 ; i >= 0  ; i--) {
            s += zahlenfolge[i] + " ";
        }
        return s;
    }

}