class Player {
    private String[] stones = new String[6];
    
    Player(String type1, String type2, String type3) {
        stones[0] = type1;
        stones[1] = type1;
        stones[2] = type2;
        stones[3] = type2;
        stones[4] = type3;
        stones[5] = type3;
    }

    public void removeStone(int index) {
        stones[index] = " ";
    }

    public String printStones() {
        String s = "";
        for(int i = 0 ; i < stones.length ; i++) {
            if(stones[i] != " ")
                s += stones[i] + " ";
        }
        return s;
    }

    public int stonesLeft() {
        int c = 0;
        for(int i = 0 ; i < stones.length ; i++) {
            if(stones[i] != " ")
                c += 1;
        }
        return c;
    }

    public boolean place(int row, int column, String stoneName) {
        boolean stoneExists = false;
        for(int i = 0 ; i < stones.length ; i++) {
            if(stones[i].equals(stoneName)) {
                stoneExists = true;
                break;
            }
        }
        if(stoneExists == false)
            return false;

        if(TicTacToePlus.setStone(row, column, stoneName)) {

            
            for(int i = 0 ; i < stones.length ; i++) {
                if(stones[i].equals(stoneName)) {
                    stones[i] = " ";
                    break;
                }
            }
            return true;

        }
        return false;
    }
}
