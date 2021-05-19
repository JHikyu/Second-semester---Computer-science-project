public class Ship {
    private String name;
    private int size;

    Ship(String name) {
        this.name = name;

        switch(this.name) {
            case "Patrol Boat":
                size = 2;
                break;
            case "Destroyer":
                size = 3;
                break;
            case "Battleship":
                size = 4;
                break;
            case "Carrier":
                size = 5;
                break;
            default:
                System.out.println("Ship unknown! Please enter a custom size!");
                break;
        }
    }

    Ship(int size) {
        this.size = size;

        switch(this.size) {
            case 2:
                name = "Patrol Boat";
                break;
            case 3:
                name = "Destroyer";
                break;
            case 4:
                name = "Battleship";
                break;
            case 5:
                name = "Carrier";
                break;
            default:
                System.out.println("Ship unknown! Please enter a custom name!");
                break;
        }
    }

    Ship(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return this.name;
    }
    public int getSize() {
        return this.size;
    }
}