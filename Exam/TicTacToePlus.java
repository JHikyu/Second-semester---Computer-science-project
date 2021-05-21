import java.util.Scanner;

class TicTacToePlus {
    public final static String[] NAMES = new String[]{"X0","X1","X2","O0","O1","O2"};
    private static String[][] field = new String[3][3];
    private static Player playerOne = new Player("X0", "X1", "X2");
    private static Player playerTwo = new Player("O0", "01", "O2");
    private static boolean turn;

    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        menu();
    }

    public static void game() {
        printField();

        if(turn == false) {
            if(playerOne.stonesLeft() > 0) {
                int row, column;
                String stone;
                do {
                    System.out.println("Stones: " + playerOne.printStones());
                    System.out.print("playerOne's turn.\nRow: ");
                    do {
                        row = sc.nextInt();
                    } while(row < 1 || row > 3);
    
                    System.out.print("Column: ");
                    do {
                        column = sc.nextInt();
                    } while(column < 1 || column > 3);
                        
                    System.out.print("Stone: ");
                    stone = sc.next();
                }
                while(playerOne.place(row-1, column-1, stone) == false);
                if(checkWin('X'))
                    gameEnd();
            }
            else {
                gameEnd();
            }
        }
        else {
            if(playerTwo.stonesLeft() > 0) {
                int row, column;
                String stone;
                do {
                    System.out.println("Stones: " + playerTwo.printStones());
                    System.out.print("playerTwo's turn.\nRow: ");
                    do {
                        row = sc.nextInt();
                    } while(row < 1 || row > 3);
    
                    System.out.print("\nColumn: ");
                    do {
                        column = sc.nextInt();
                    } while(column < 1 || column > 3);
                        
                    System.out.print("\nStone: ");
                    stone = sc.next();
                }
                while(playerTwo.place(row-1, column-1, stone) == false);
                if(checkWin('O'))
                    gameEnd();
            }
            else {
                gameEnd();
            }
        }
        turn = !turn;
        game();
    }
    public static void menu() {
        System.out.println("      Tic Tac Toe - PLUS");
        System.out.println("===============================");
        System.out.println(" (1) Spiel starten");
        System.out.print(" (2) Beenden\n > ");

        switch(sc.nextInt()) {
            case 1:
                resetField();
                game();
                break;
            case 2:
                System.exit(1);
                break;
            default:
                menu();
                break;
        }
    }

    
    public static void gameEnd() {
        for(int i = 0 ; i < 6 ; i++) {
            playerOne.removeStone(i);
            playerTwo.removeStone(i);
        }

        if(checkWin('X')) {
            System.out.println("playerOne has won the game");
            menu();
        }
        else if(checkWin('O')) {
            System.out.println("playerTwo has won the game");
            menu();
        }
        else {
            System.out.println("Untneschieden");
            menu();
        }
    }

    public static boolean setStone(int row, int column, String stoneName) {
        char symbol = stoneName.charAt(0);
        int number = Integer.parseInt(stoneName.substring(1));
        int fieldNumber = -1;
        if(field[row][column] != " ") {
            fieldNumber = Integer.parseInt(field[row][column].substring(1));
        }

        if(number > fieldNumber) {
            field[row][column] = stoneName;
            if(checkWin(symbol)) {
                gameEnd();
                return true;
            }
            return true;
        }

        return false;
    }

    public static boolean checkWin(char stoneName) {
        int inARow = 0;
        for(int i = 0 ; i < 3 ; i++) {
            for(int x = 0 ; x < 3 ; x++) {
                if(field[i][x].charAt(0) == stoneName) {
                    inARow += 1;
                }
            }
            if(inARow == 3)
                return true;
            inARow = 0;
        }
        
        int inAColumn = 0;
        for(int i = 0 ; i < 3 ; i++) {
            for(int x = 0 ; x < 3 ; x++) {
                if(field[x][i].charAt(0) == stoneName) {
                    inAColumn += 1;
                }
            }
            if(inAColumn == 3)
                return true;
            inAColumn = 0;
        }

        if(field[0][0].charAt(0) == stoneName && field[1][1].charAt(0) == stoneName && field[2][2].charAt(0) == stoneName) {
            return true;
        }
        if(field[2][0].charAt(0) == stoneName && field[2][2].charAt(0) == stoneName && field[0][2].charAt(0) == stoneName) {
            return true;
        }



        return false;
    }

    public static void resetField() {
        for(int i = 0 ; i < field.length ; i++) {
            for(int x = 0 ; x < field[i].length ;x++) {
                field[i][x] = " ";
            }
        }
    }
    public static void printField() { 
        System.out.println("  |  1 |  2 |  3 |");
        System.out.println("--+----+----+----+");
        for(int i = 0 ; i < 3 ; i++) {

            System.out.printf("%d |", i+1);
            for(int x = 0 ; x < 3 ; x++)
                if(field[i][x] != " ")
                    System.out.printf(" %s |", field[i][x]);
                else
                    System.out.printf(" %s |", "  ");

            System.out.println("\n--+----+----+----+");
        }

    }

}