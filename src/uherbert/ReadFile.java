package uherbert;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadFile {

    static int[][] Gridcc = new int[25][25];
    ArrayList<String> grid = new ArrayList<>();

    int n = 50;

    public void ConvertFile(String FilePath) throws Exception {
        FileReader file = new FileReader(FilePath);
        BufferedReader reader = new BufferedReader(file);
        String line = reader.readLine();
        while (n != 0) {
            grid.add(line);
            line = reader.readLine();
            n--;
        }
    }

    public void MakeGrid2D() {
        String s = "";
        char[] array;
        for (int i = 0; i < 25; i++) {
            s = grid.get(i * 2);
            array = s.toCharArray();
            for (int j = 0; j < 25; j++) {
                switch (array[j]) {
                    case '*':
                        Gridcc[i][j] = -1;
                        break;
                    case '.':
                        Gridcc[i][j] = 0;
                        break;
                    case 'o':
                        Gridcc[i][j] = 1;
                        break;
                    case 'u':
                        Gridcc[i][j] = 4;
                        break;
                    default:
                        Gridcc[i][j] = 8;
                        break;
                }
            }
        }
    }
}
