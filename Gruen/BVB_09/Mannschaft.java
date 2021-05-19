class Mannschaft {
    private String vereinsname;
    private Mitglied[] mitglieder = new Mitglied[30];
    public int length = 0;

    Mannschaft(String vereinsname) {
        this.vereinsname = vereinsname;
    }

    public String getVereinsname() {
        return this.vereinsname;
    }
    
    public void addMitglied(Mitglied m) {
        for(int i = 0 ; i < mitglieder.length ; i ++) {
            if(mitglieder[i] == null) {
                mitglieder[i] = m;
                this.length += 1;
                return;
            }
        }
    }

    public Mitglied getMitglied(int n) {
        if(mitglieder[n] == null)
            return null;
        return mitglieder[n];
    }
    public Mitglied getMitglied(String name) {
        for(int i = 0 ; i < this.length ; i++) {
            if(getMitglied(i).getName() == name)
                return getMitglied(i);
        }
        return null;
    }

    public String getMitgliedInformation(int n) {
        String s = "Mitglied nicht gefunden";

        if(mitglieder[n] != null) {
            String sonstiges = "";
            if(mitglieder[n].getTyp() == 'S') {
                sonstiges = "Position: " + mitglieder[n].getSpielposition() + " / Spieleinsaetze: " + mitglieder[n].getEinsaetze();
            }
            if(mitglieder[n].getTyp() == 'T') {
                sonstiges = "Lieblingsspieler: " + mitglieder[n].getLieblingsSpielerName();
            }
            if(mitglieder[n].getTyp() == 'A') {
                sonstiges = "Fachgebiet: " + mitglieder[n].getFachgebiet();
            }

            s = String.format("%c\t%s\t\t%s\t\t\t%d\t\t%s", mitglieder[n].getTyp(), mitglieder[n].getName(), mitglieder[n].getVorname(), mitglieder[n].getJahresgehalt(), sonstiges);
        }

        return s;
    }

    public int summeJahresgehaelter() {
        int summe = 0;

        for(int i = 0 ; i < this.length ; i++) {
            summe += mitglieder[i].getJahresgehalt();
        }

        return summe;
    }


}
