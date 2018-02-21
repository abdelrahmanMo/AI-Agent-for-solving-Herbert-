package uherbert;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {

    public ArrayList<Node> neighbors = new ArrayList();
    public Node parent;
    public String steps;
    public int[][] Gride = new int[25][25];
    public int x;
    public int y;
    public int cost;

    public Node(int[][] Grid) {
        for (int i = 0; i < Gride.length; i++) {
            for (int j = 0; j < Gride.length; j++) {
                Gride[i][j] = Grid[i][j];
            }

        }
    }

    public boolean GoalTest() {
        boolean Isgoal = true;
        for (int i = 0; i < Gride.length; i++) {
            for (int j = 0; j < Gride.length; j++) {
                if (Gride[i][j] == 1) {
                    Isgoal = false;

                }
            }

        }
        return Isgoal;
    }

    public boolean subGoal() {
        boolean Subgoal = true;
        for (int i = 0; i < Gride.length; i++) {
            for (int j = 0; j < Gride.length; j++) {
                if (Gride[i][j] == 3 || Gride[i][j] == 4 || Gride[i][j] == 5 || Gride[i][j] == 2) {
                    if (i == GreedySearch.choosex && j == GreedySearch.choosey) {
                        Subgoal = false;
                        return Subgoal;
                    }
                }
            }

        }
        return Subgoal;
    }

    public void copyArray(int[][] G, int[][] Grid) {
        for (int i = 0; i < G.length; i++) {
            for (int j = 0; j < G.length; j++) {
                Grid[i][j] = G[i][j];
            }
        }
    }
    // 2 means herbert is facing left
    //  3 means herbert is facing upward
    //  4 means herbert is facing right
    //   5 means herbert is facing downward

    public void movedown(int[][] p, int x, int y) {
        String step = null;
        int[][] pc = new int[25][25];
        copyArray(p, pc); // we copy the array in order not to change the 
        switch (p[x][y]) {
            case 3:
                //-1 means grey point ,8 means an obstacle(wall)
                if (y < 24 && pc[x][y + 1] != -1 && pc[x][y + 1] != 8) {
                    if (p[x][y + 1] == 1) {
                        pc[x][y + 1] = 0;
                    }
                    int temp = 5;
                    pc[x][y] = pc[x][y + 1]; // pc change
                    pc[x][y + 1] = temp;
                }
                step = "rrs";
                break;
            case 4:
                if (y < 24 && pc[x][y + 1] != -1 && pc[x][y + 1] != 8) {
                    if (p[x][y + 1] == 1) {
                        pc[x][y + 1] = 0;
                    }
                    int temp = 5;
                    pc[x][y] = pc[x][y + 1];
                    pc[x][y + 1] = temp;
                }
                step = "rs";
                break;
            case 5:
                if (y < 24 && pc[x][y + 1] != -1 && pc[x][y + 1] != 8) {
                    if (p[x][y + 1] == 1) {
                        pc[x][y + 1] = 0;
                    }
                    int temp = pc[x][y];
                    pc[x][y] = pc[x][y + 1];
                    pc[x][y + 1] = temp;
                }
                step = "s";
                break;
            case 2:
                if (y < 24 && pc[x][y + 1] != -1 && pc[x][y + 1] != 8) {
                    if (p[x][y + 1] == 1) {
                        pc[x][y + 1] = 0;
                    }
                    int temp = 5;
                    pc[x][y] = pc[x][y + 1];
                    pc[x][y + 1] = temp;
                }
                step = "ls";
                break;
            default:
                break;
        }
        Node newnode = new Node(pc);
        neighbors.add(newnode);
        newnode.parent = this;
        newnode.steps = step;

    }

    public void moveleft(int[][] p, int x, int y) {
        String step = null;
        int[][] pc = new int[25][25];
        copyArray(p, pc);
        switch (p[x][y]) {
            case 3:
                if (x < 24 && pc[x + 1][y] != -1 && pc[x + 1][y] != 8) {
                    if (p[x + 1][y] == 1) {
                        pc[x + 1][y] = 0;

                    }
                    int temp = 2;
                    pc[x][y] = pc[x + 1][y];
                    pc[x + 1][y] = temp;
                }
                step = "ls";
                break;
            case 4:
                if (x < 24 && pc[x + 1][y] != -1 && pc[x + 1][y] != 8) {
                    if (p[x + 1][y] == 1) {
                        pc[x + 1][y] = 0;

                    }
                    int temp = 2;
                    pc[x][y] = pc[x + 1][y];
                    pc[x + 1][y] = temp;
                }
                step = "rrs";
                break;
            case 5:
                if (x < 24 && pc[x + 1][y] != -1 && pc[x + 1][y] != 8) {
                    if (p[x + 1][y] == 1) {
                        pc[x + 1][y] = 0;

                    }
                    int temp = 2;
                    pc[x][y] = pc[x + 1][y];
                    pc[x + 1][y] = temp;
                }
                step = "rs";
                break;
            case 2:
                if (x < 24 && pc[x + 1][y] != -1 && pc[x + 1][y] != 8) {
                    if (p[x + 1][y] == 1) {
                        pc[x + 1][y] = 0;

                    }
                    int temp = pc[x][y];
                    pc[x][y] = pc[x + 1][y];
                    pc[x + 1][y] = temp;
                }
                step = "s";
                break;
            default:
                break;
        }
        Node newnode = new Node(pc);
        neighbors.add(newnode);
        newnode.parent = this;
        newnode.steps = step;

    }

    public void moveright(int[][] p, int x, int y) {
        String step = null;
        int[][] pc = new int[25][25];
        copyArray(p, pc);
        switch (p[x][y]) {
            case 3:
                //باصص لفوق
                if (x > 0 && pc[x - 1][y] != -1 && pc[x - 1][y] != 8) {
                    if (pc[x - 1][y] == 1) {
                        pc[x - 1][y] = 0;

                    }
                    int temp = 4;
                    pc[x][y] = pc[x - 1][y];
                    pc[x - 1][y] = temp;
                }// pc[x][y]=4; 
                step = "rs";
                break;
            case 4:
                if (x > 0 && pc[x - 1][y] != -1 && pc[x - 1][y] != 8) {
                    if (pc[x - 1][y] == 1) {
                        pc[x - 1][y] = 0;

                    }
                    int temp = pc[x][y];
                    pc[x][y] = pc[x - 1][y];
                    pc[x - 1][y] = temp;
                }
                step = "s";
                break;
            case 5:
                if (x > 0 && pc[x - 1][y] != -1 && pc[x - 1][y] != 8) {
                    if (pc[x - 1][y] == 1) {
                        pc[x - 1][y] = 0;

                    }
                    int temp = 4;
                    pc[x][y] = pc[x - 1][y];
                    pc[x - 1][y] = temp;
                }
                step = "ls";
                break;
            case 2:
                if (x > 0 && pc[x - 1][y] != -1 && pc[x - 1][y] != 8) {
                    if (pc[x - 1][y] == 1) {
                        pc[x - 1][y] = 0;

                    }
                    int temp = 4;
                    pc[x][y] = pc[x - 1][y];
                    pc[x - 1][y] = temp;
                }
                step = "rrs";
                break;
            default:
                break;
        }
        Node newnode = new Node(pc);
        neighbors.add(newnode);
        newnode.parent = this;
        newnode.steps = step;

    }

    public void moveup(int[][] p, int x, int y) {
        String step = null;
        int[][] pc = new int[25][25];
        copyArray(p, pc);
        switch (p[x][y]) {
            case 3:

                if (y > 0 && pc[x][y - 1] != -1 && pc[x][y - 1] != 8) {
                    if (pc[x][y - 1] == 1) {
                        pc[x][y - 1] = 0;

                    }
                    int temp = pc[x][y];
                    pc[x][y] = pc[x][y - 1];
                    pc[x][y - 1] = temp;
                }
                step = "s";
                break;
            case 4:

                if (y > 0 && pc[x][y - 1] != -1 && pc[x][y - 1] != 8) {
                    if (pc[x][y - 1] == 1) {
                        pc[x][y - 1] = 0;

                    }
                    int temp = 3;
                    pc[x][y] = pc[x][y - 1];
                    pc[x][y - 1] = temp;
                }
                step = "ls";
                break;
            case 5:
                if (y > 0 && pc[x][y - 1] != -1 && pc[x][y - 1] != 8) {
                    if (pc[x][y - 1] == 1) {
                        pc[x][y - 1] = 0;

                    }
                    int temp = 3;
                    pc[x][y] = pc[x][y - 1];
                    pc[x][y - 1] = temp;
                }
                step = "rrs";
                break;
            case 2:
                if (y > 0 && pc[x][y - 1] != -1 && pc[x][y - 1] != 8) {
                    if (pc[x][y - 1] == 1) {
                        pc[x][y - 1] = 0;

                    }
                    int temp = 3;
                    pc[x][y] = pc[x][y - 1];
                    pc[x][y - 1] = temp;
                }
                step = "rs";
                break;
            default:
                break;
        }
        Node newnode = new Node(pc);
        neighbors.add(newnode);
        newnode.parent = this;
        newnode.steps = step;

    }

    public void expandMove() {
        for (int i = 0; i < Gride.length; i++) {
            for (int j = 0; j < Gride.length; j++) {
                if (Gride[i][j] == 3 || Gride[i][j] == 4 || Gride[i][j] == 5 || Gride[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        moveright(Gride, x, y);
        moveleft(Gride, x, y);
        moveup(Gride, x, y);
        movedown(Gride, x, y);

    }

    public boolean IsSame(int[][] p) {
        boolean issame = true;
        for (int i = 0; i < Gride.length; i++) {
            for (int j = 0; j < Gride.length; j++) {
                if (Gride[i][j] != p[i][j]) {
                    issame = false;

                }
            }
        }
        return issame;
    }

    @Override
    public int compareTo(Node o) {
        if (this.cost > o.cost) {
            return 1;
        } else if (this.cost < o.cost) {
            return -1;
        }
        return 0;
    }

    public void calculateCost() {
        int su = 0;
        for (int i = 0; i < Gride.length; i++) {
            for (int j = 0; j < Gride.length; j++) {
                if (Gride[i][j] == 3 || Gride[i][j] == 4 || Gride[i][j] == 5 || Gride[i][j] == 2) {

                    int ddx = GreedySearch.choosex - i;
                    int ddy = GreedySearch.choosey - j;
                    su = Math.abs(ddx) + Math.abs(ddy);
                    break;
                }
            }
        }
        this.cost = su;
    }

    //Get all the ones postitions (goals) 
    public void EvaluateNode() {
        int sum = 0;
        int min = 50;// largest dis = 25
        int[] w = new int[2]; 
        int[] position = new int[2];
        List<int[]> myList = new ArrayList<>();// subgol position 
        for (int i = 0; i < Gride.length; i++) {
            for (int j = 0; j < Gride.length; j++) {
                if (Gride[i][j] == 1) {

                    w[0] = i;
                    w[1] = j;
                    myList.add(w);
                } // hur position
                if (Gride[i][j] == 3 || Gride[i][j] == 4 || Gride[i][j] == 5 || Gride[i][j] == 2) {
                    position[0] = i;
                    position[1] = j;
                }
            }

        }
        //min dis between H and goals

        for (int i = 0; i < myList.size(); i++) {

            int xdis = myList.get(i)[0] - position[0];
            int ydis = myList.get(i)[1] - position[1];
            sum = Math.abs(xdis) + Math.abs(ydis);

            if (sum < min) {
                min = sum;
                GreedySearch.choosex = myList.get(i)[0];
                GreedySearch.choosey = myList.get(i)[1];
            }
        }
    }

}
