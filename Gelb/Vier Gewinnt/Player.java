class Player {
    private String name;
    private int nummer;
    private char zeichen; //! Extra

    public Player(String name, int nummer) {
        this.name = name;
        this.nummer = nummer;
        this.zeichen = nummer==1 ? 'X' : 'O'; //! Extra
    }
    public Player(String name, int nummer, char zeichen) { //! Extra
        this.name = name;
        this.nummer = nummer;
        this.zeichen = zeichen;
    }

    public String getName() {
        return this.name;
    }
    public int getNummer() {
        return this.nummer;
    }
    public char getZeichen() { //! Extra
        return this.zeichen;
    }

    public void setZeichen(char zeichen) {
        this.zeichen = zeichen;
    }
}