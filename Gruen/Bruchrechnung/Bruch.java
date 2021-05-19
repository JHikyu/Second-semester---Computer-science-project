class Bruch {
    private int zaehler;
    private int nenner;

    Bruch(int zaehler) {
        this.nenner = 1;
        this.zaehler = zaehler;
    }
    Bruch(int zaehler, int nenner) {
        this.zaehler = zaehler;
        this.nenner = nenner;
    }

    public int getZaehler() {
        return this.zaehler;
    }
    public int getNenner() {
        return this.nenner;
    }

    public void multipliziere(int n) {
        double bruch = this.zaehler/this.nenner;
        System.out.println(bruch * n);
    }
    public void multipliziere(Bruch b) {
        double bruch = this.zaehler/this.nenner;
        System.out.println(bruch * (b.zaehler / b.nenner));
    }
    public void dividiere(Bruch b) {
        double bruch = this.zaehler/this.nenner;
        System.out.println(bruch / (b.zaehler / b.nenner));
    }
    public String toString() {
        return this.zaehler + "/" + this.nenner;
    }

    public static int ggt(int a, int b) {
        int temp;
        if(b > a) {
            temp = a;
            a = b;
            b = temp;
        }

        int rest;
        do {
            rest = a % b;
            a = b;
            b = rest;
        }
        while(b != 0);

        return a;
    }

    public void kuerze() {
        System.out.println(this.zaehler / ggt(this.zaehler, this.nenner) + "/" + this.nenner / ggt(this.zaehler, this.nenner));
    }

}
