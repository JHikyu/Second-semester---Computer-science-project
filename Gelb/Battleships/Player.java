import java.util.Random;

public class Player {
    
    private String name;
    private char[][] board = new char[10][10];
    private boolean robot;
    private boolean robotIsSmart;

    private Ship[] ships = new Ship[7];
    private Random random = new Random();


    Player(String name){
        this.name = name;
        this.clearField();
        this.addShips();
    }
    Player(String name, int size){
        this.name = name;
        this.board = new char[size][size];
        this.clearField();
        this.addShips();
    }

    public void setRobot(boolean smart) {
        this.robot = true;
        this.robotIsSmart = smart;
    }

    public void setPlayer() {
        this.robot = false;
    }
    
    public boolean isRobot() {
        return this.robot;
    }

    public boolean isSmart() {
        return this.robotIsSmart;
    }
    
    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMapSize(int size) {
        board = new char[size][size];
        this.clearField();
    }

    public int getMapSize() {
        return this.board.length;
    }

    public void addShips() {
        ships[0] = new Ship(2);
        ships[1] = new Ship(2);
        ships[2] = new Ship(2);
        ships[3] = new Ship(3);
        ships[4] = new Ship(3);
        ships[5] = new Ship(4);
        ships[6] = new Ship(5);
    }

    public void clearField() {
        for(int row = 0; row < this.board.length ; row++) {
            for(int column = 0; column < this.board[row].length; column++) {
                this.board[row][column] = ' ';
            }
        }
    }


    public void setRandom() {
        char za = (char) ('A' + random.nextInt(this.board.length));
        int  sa = 1 + random.nextInt(this.board[0].length-1);
        char ze = 'A';
        int se = 0;

        switch(random.nextInt(2)) {
            case 0:
                ze = (char) (za + (1 + random.nextInt(4)));
                se = sa;
                break;
            case 1:
                ze = za;
                se = sa + (1 + random.nextInt(4));
        }

        this.setShip(za, sa, ze, se);
    }

    public boolean setShip(char rowStart, int columnStart, char rowEnd, int columnEnd) {
        int za = rowStart-65;
        int sa = columnStart-1;
        int ze = rowEnd-65;
        int se = columnEnd-1;

        if(za != ze && sa != se)
            return false;

        if(za < 0 || za >= this.board.length || sa < 0 || sa >= this.board[0].length || ze < 0 || ze >= this.board.length || se < 0 || se >= this.board[0].length)
            return false;

    

        int size = za==ze ? Math.abs(se-sa)+1 : Math.abs(ze-za)+1;

        for(int row = za ; row <= ze ; row++) {
            for(int column = sa ; column <= se ; column++) {
                if(this.board[row][column] != ' ') {

                    //TODO: Check neighbours 3x3 

                    return false;
                }
            } 
        }


	



        //? Does the ship exist with this length?
        boolean shipFound = false;
        for(int i = 0 ; i < ships.length ; i++) {
            if(ships[i] != null) {
                if(ships[i].getSize() == size) {
                    ships[i] = null;
                    shipFound = true;
                    break;
                }
            }
        }
        if(shipFound == false)
            return false;



        for(int row = za ; row <= ze ; row++) {
            for(int column = sa ; column <= se ; column++) {
                this.board[row][column] = 'S';
            } 
        }
        
        return true;
    }

    public void printField() {

        //? First row (columnn names)
        System.out.print("  ");
        for (int column = 0; column < this.board.length; column++) {
            System.out.print((column+1) + " ");
        }
        System.out.println();
        
        //? First column (row names)
        char rownName = 65;
        for(int row = 0; row < this.board.length ; row++) {
            System.out.print((rownName++) + " ");

            //? Every char is ' '
            for(int column = 0; column < this.board.length; column++) {
                System.out.print(this.board[row][column] + " ");
            }

            System.out.println("");
        }
    }
    
    //! Print out fields
    public void printFields(Player enemy) {

        //!       DU         - - - -        DEIN GEGNER
        System.out.print("      YOUR FLEET\t- - - -\t\tENEMY MAP\n");

        //! 1 2 3 4 5 6 7 8 9 10  - - - 1 2 3 4 5 6 7 8 9 10
        //? First row (columnn Names)
        System.out.print("  ");
        for (int column = 0; column < this.board.length; column++) {
            System.out.print((column+1) + " ");
        }
        System.out.print(" - - - -    ");
        for (int column = 0; column < enemy.board.length; column++) {
            System.out.print((column+1) + " ");
        }
        System.out.println("");


        char rownName = 65;
        for(int row = 0; row < this.board.length ; row++) {
            System.out.print((rownName) + " ");

            for(int column = 0; column < this.board.length; column++) {
                System.out.print(this.board[row][column] + " ");
            }

            System.out.print("  - - - -  ");
            System.out.print((rownName++) + " ");

            for(int column = 0; column < this.board.length; column++) {
                if(enemy.board[row][column] == 'S')
                    System.out.print(" " + " ");
                else
                    System.out.print(enemy.board[row][column] + " ");
            }

            System.out.println("");
        }

    }
    
    public static void printOpenFields(Player player1, Player player2) {

        //!       CPU 1         - - - -        CPU 2
        System.out.print("\t"+player1.getName()+"\t\t- - - -\t\t  "+player2.getName()+" \n");

        //! 1 2 3 4 5 6 7 8 9 10  - - - 1 2 3 4 5 6 7 8 9 10
        //? First row (columnn Name)
        System.out.print("  ");
        for (int column = 0; column < player1.board.length; column++) {
            System.out.print((column+1) + " ");
        }
        System.out.print(" - - - -    ");
        for (int column = 0; column < player2.board.length; column++) {
            System.out.print((column+1) + " ");
        }
        System.out.println("");


        char rowName = 65;
        for(int row = 0; row < player1.board.length ; row++) {
            System.out.print((rowName) + " ");

            for(int column = 0; column < player1.board.length; column++) {
                System.out.print(player1.board[row][column] + " ");
            }

            System.out.print("  - - - -  ");
            System.out.print((rowName++) + " ");

            for(int column = 0; column < player1.board.length; column++) {
                System.out.print(player2.board[row][column] + " ");
            }

            System.out.println("");
        }
    }


    public void getShipList() {
        for(int i = 0 ; i < ships.length ; i++) {
            if(ships[i] != null) {
                System.out.println(" - " + ships[i].getName() + " ("+ships[i].getSize()+")");
            }
        }
    }

    public int shipsLeft() {
        int c = 0;
        for(int i = 0 ; i < ships.length ; i++) {
            if(ships[i] != null) c++;
        }
        return c;
    }
    public int mapShipsLeft() {
        int shipFragments = 0;

        for(int x = 0 ; x < this.board.length ; x++) {
            for(int y = 0 ; y < this.board[x].length ; y++) {
                if(this.board[x][y] == 'S') {
                    shipFragments += 1;
                }
            }
        }
        return shipFragments;
    }

    public boolean shoot(char row, char column, Player enemy) {
        return false;
    }
    public boolean shoot(int row, int column, Player enemy) {
        return false;
    }
    public boolean shoot(char row, int column, Player enemy) {
        
        int z = row-65;
        int s = column-1;

        //? IN BOUNDS
        if(z >= 0 && z < enemy.getMapSize() && s >= 0 && s < enemy.getMapSize()) {
            if(enemy.board[z][s] == 'S') {
                enemy.board[z][s] = 'x';
                return true;
            }
            else if(enemy.board[z][s] == ' ') {
                enemy.board[z][s] = ',';
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean randomShoot(boolean smart, Player enemy) {

        int z = random.nextInt(this.board.length);
        int s = random.nextInt(this.board.length);


        if(smart == true) {
            //TODO - smart shot (After a hit try targeting that hits neighbour isntead of more random shots)
        }
        
        //? IN BOUNDS
        if(z >= 0 && z < enemy.getMapSize() && s >= 0 && s < enemy.getMapSize()) {
            if(enemy.board[z][s] == 'S') {
                enemy.board[z][s] = 'x';
                return true;
            }
            else if(enemy.board[z][s] == ' ') {
                enemy.board[z][s] = ',';
                return true;
            }
            return false;
        }
        return false;
    }
}