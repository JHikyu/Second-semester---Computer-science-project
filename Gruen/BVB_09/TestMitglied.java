
public class TestMitglied {


    public static void main(String[] args) {
        Spieler s = new Spieler("Buerki", "Roman", "Tor", 16);
        Spieler s2 = new Spieler("Hummels", "Mats", "Abwehr", 17);
        Spieler s3 = new Spieler("Haaland", "Erling", "Sturm", 12);

        Trainer t = new Trainer("Terzic", "Edin", s2);

        Arzt a = new Arzt("Braun", "Markus", "Sportmedizin");
    }

}
