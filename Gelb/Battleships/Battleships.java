import java.util.Scanner;

class Battleships {
    
    private static Player player1 = new Player("Player 1", 10);
    private static Player player2 = new Player("Player 2", 10);
    private static boolean turn;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void game(int etappe) {
        switch(etappe) {
            case 1:
                System.out.println("\tBattleships\n--------------------------");
                System.out.print(" (1) Player vs Player\n (2) Player vs Computer (Easy)\n (3) Player vs Computer (Hard)\n (4) Computer vs Computer\n > ");
                int auswahl = sc.nextInt();
                switch(auswahl) {
                    case 1:
                        player1.setPlayer();
                        player2.setPlayer();
                        game(2);
                        break;
                    case 2:
                        player1.setPlayer();
                        player2.setRobot(false); //* (isSmart = false) -> randomShots
                        game(2);
                        break;
                    case 3:
                        player1.setPlayer();
                        player2.setRobot(true); //* (isSmart = true) -> targetedShots
                        game(2);
                        break;
                    case 4:
                        player1.setRobot(false);
                        player2.setRobot(false);
                        game(2);
                        break;
                    default:
                        game(1);
                        break;
                }
                game(1);
                break;
            case 2:
                System.out.println("\tBattleships\n--------------------------");
                System.out.print(" (1) Start game\n (2) Map size\n > ");
                auswahl = sc.nextInt();
                switch(auswahl) {
                    case 1:
                        game(3);
                        break;
                    case 2:
                        System.out.print("Map size: ");
                        int neueKarteGrosse = sc.nextInt();
                        while (neueKarteGrosse < 8 && neueKarteGrosse > 16) {
                            System.out.print("Size is invalid! Please choose a new size [8-16]\nBoardsize: ");
                            neueKarteGrosse = sc.nextInt();
                        }
                        player1.setMapSize(neueKarteGrosse);
                        player2.setMapSize(neueKarteGrosse);
                        game(2);
                        break;
                    default:
                        game(2);
                        break;
                }
                game(2);
                break;
            case 3: //! Flotte verwalten

                //! SPIELER
                if(player1.isRobot() == false) {

                    System.out.println("\tBattleships\n---------------------------------");
                    System.out.print(" (1) Place ships yourself\n (2) Random shipplacement\n > ");
                    if(sc.nextInt() == 2) {
                        while(player1.shipsLeft() > 0) {
                            player1.setRandom();
                        }
                    }
                    else {
                        while(player1.shipsLeft() > 0) {
                            System.out.println("\tBattleships\n---------------------------------");
                            player1.printField();
                            System.out.println("\nUnused ships: ");
                            player1.getShipList();
                            System.out.print("Startpoint row > ");
                            char za = sc.next().charAt(0);
                            System.out.print("Startpoint collum > ");
                            int sa = sc.nextInt();
                            System.out.print("Endpoint row> ");
                            char ze = sc.next().charAt(0);
                            System.out.print("Endpoint column > ");
                            int se = sc.nextInt();
    
                            if(player1.setShip(za, sa, ze, se))
                                System.out.println("Successfully placed");
                            else
                                invalidUsage();
                        }
                    }
                }
                if(player2.isRobot() == false) {

                    System.out.println("\tBattelships\n---------------------------------");
                    System.out.print(" (1) Place ships yourself\n (2) Random shipplacement\n > ");
                    if(sc.nextInt() == 2) {
                        while(player2.shipsLeft() > 0) {
                            player2.setRandom();
                        }
                    }
                    else {
                        while(player2.shipsLeft() > 0) {
                            System.out.println("\tBattleships\n---------------------------------");
                            player2.printField();
                            System.out.println("\nUnused ships: ");
                            player2.getShipList();
                            System.out.print("Startpoint row > ");
                            char za = sc.next().charAt(0);
                            System.out.print("Startpoint collum > ");
                            int sa = sc.nextInt();
                            System.out.print("Endpoint row > ");
                            char ze = sc.next().charAt(0);
                            System.out.print("Endpoint collum> ");
                            int se = sc.nextInt();
    
                            if(player2.setShip(za, sa, ze, se))
                                System.out.println("Succesfully placed");
                            else
                                invalidUsage();
                        }
                    }
                }



            

                if(player1.isRobot()) {
                    while(player1.shipsLeft() > 0) {
                        player1.setRandom();
                    }
                }
                if(player2.isRobot()) {
                    while(player2.shipsLeft() > 0) {
                        player2.setRandom();
                    }
                }


                game(4);
                break;
            case 4:
                //! Game start
                player1.printFields(player2);

                
                while(player1.mapShipsLeft() > 0 && player2.mapShipsLeft() > 0) {
                    boolean shot = false;
                    do {
                        if(player1.isRobot() || player2.isRobot())
                            System.out.println((!turn ? player1.getName() : player2.getName()) + " turn");
                        if(!turn) {
                            if(player1.isRobot()) {
                                shot = player1.randomShoot(player1.isSmart(), player2);
                            }
                            else {
                                System.out.print("\nRow:  ");
                                char row = sc.next().charAt(0);
                                System.out.print("\nColumn: ");
                                int column = sc.nextInt();
                                shot = player1.shoot(row, column, player2);
                            }
                        }
                        else {
                            if(player2.isRobot()) {
                                shot = player2.randomShoot(player2.isSmart(), player1);
                            }
                            else {
                                System.out.print("\nRow:  ");
                                char row = sc.next().charAt(0);
                                System.out.print("\nColumn: ");
                                int column = sc.nextInt();
                                shot = player2.shoot(row, column, player1);
                            }
                        }
                    }
                    while(shot == false);
                    turn = !turn;

                    if(player1.isRobot() && player2.isRobot()) {
                        Player.printOpenFields(player1, player2);
                    }
                    else if(player1.isRobot() == false && player2.isRobot() == false) {
                        if(!turn) 
                            player1.printFields(player2);
                        else
                            player2.printFields(player1);
                    }
                    else if(player1.isRobot() == false && player2.isRobot()) {
                        player1.printFields(player2);
                    }


                    //? 500ms delay between moves
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                //? gewinner
                System.out.println((player1.mapShipsLeft() == 0 ? player2.getName() : player1.getName()) + " has won the game!\nCongratilations!\n (1) New game\n (2) Back to menu\n (3) Exit");
                auswahl = sc.nextInt();
                if(auswahl == 1) {
                    resetPlayers();
                    game(1);
                }
                else if(auswahl == 3) {
                    System.out.println("Thanks for playing!");
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.exit(1);
                }
                else {
                    resetPlayers();
                    menu();
                }

            
                break;
        }
    }

    public static void resetPlayers() {
        player1.clearField();
        player1.addShips();
        player2.clearField();
        player2.addShips();
    }

    public static void menu() {

        System.out.println("\tBattleships\n--------------------------");
        System.out.print(" (1) Start game\n (2) Settings\n (3) Exit\n > ");
        int auswahl = sc.nextInt();
        switch(auswahl) {
            case 1:
                game(1);
                break;
            case 2:
                settings();
                break;
            case 3:
                System.exit(1);
            default:
                break;
        }

    }
    public static void settings() {
        System.out.println("\tBattleships\n--------------------------");
        System.out.print(" (1) Player 1 - " + player1.getName() + "\n (2) Player 2 - " + player2.getName() + "\n (3) Back\n > ");
        int auswahl = sc.nextInt();
        switch(auswahl) {
            case 1:
                editPlayer(1);
                break;
            case 2:
                editPlayer(2);
                break;
            case 3:
                menu();
            default:
                break;
        }
    }
    public static void editPlayer(int playerNr) {
        System.out.println("\tEdit player ("+playerNr+")\n--------------------------");
        System.out.print("\nNew name: ");
        String newName = sc.next();
        if(playerNr == 1) {
            player1.setName(newName);
        } else {
            player2.setName(newName);
        }
        settings(); 
    }
    public static void invalidUsage() {
        System.out.println("Invalid move. Please choose correct coordinates!\n");
    }
}                                                   










