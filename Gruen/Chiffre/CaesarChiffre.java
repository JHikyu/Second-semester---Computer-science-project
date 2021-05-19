import java.util.Scanner;

class CaesarChiffre {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String klartext = "";
        String geheimtext = "";
        int verschiebung = 0;

        while(true) {
            System.out.print("\n(1) Eingabe Klartext\n(2) Eingabe Geheimtext\n(3) Verschiebung\n(4) Verschluesseln\n(5) Entschluesseln\n(6) Entschluesseln Durchlauf\n(7) Ende\nAuswahl: ");
            switch(s.nextInt()) {
                case 1:
                    System.out.print("Klartext: ");
                    klartext = s.next();
                    break;
                case 2:
                    System.out.print("Geheimtext: ");
                    geheimtext = s.next();
                    break;
                case 3:
                    System.out.print("Verschiebung: ");
                    verschiebung = s.nextInt();
                    break;
                case 4:
                    System.out.println("Verschluesselung");
                    System.out.println("Klartext: " + klartext);
                    System.out.println("Verschluesselt: " + encode(klartext, verschiebung));
                    break;
                case 5:
                    System.out.println("Entschluesselung");
                    System.out.println("Geheimtext: " + geheimtext);
                    System.out.println("Entschluesselt: " + decode(geheimtext, verschiebung));
                    break;
                case 7:
                    s.close();
                    System.exit(0);
            }
        }


    }

    public static String encode(String s, int n) {
        String neu = "";

        for(int i = 0 ; i < s.length() ; i++) {

            int l = s.charAt(i) + n;
            if(l > 122 || (l > 90 && l < 96))
                l -= 26;

            neu += Character.toString(l);
        }

        return neu;
    }

    public static String decode(String s, int n) {
        String neu = "";
        
        for(int i = 0 ; i < s.length() ; i++) {

            int l = s.charAt(i) - n;
            if(l < 65 || (l < 97 && l > 90)) {
                l += 26;
            }

            neu += Character.toString(l);
            
        }

        return neu;
    }


}
