package uherbert;

import java.util.ArrayList;

public class UHerbert {

    public static void main(String[] args) throws Exception {
        ReadFile RF = new ReadFile();
        //path to the text file:
        String FilePath = "G:\\herbert\\level_pack4\\level3.txt";
        RF.ConvertFile(FilePath);
        RF.MakeGrid2D();
        ArrayList<  String> Solution = new ArrayList<>();
        String enhaced = "";
        long startTime = System.currentTimeMillis();
        Node root = new Node(ReadFile.Gridcc);
        GreedySearch ui = new GreedySearch();
        // DepthFirst ui =new DepthFirst();
        //   BreadthFirst ui=new BreadthFirst();

        //  ArrayList<Node> solution =ui.BDF(root);
        //ArrayList<Node> solution =ui.DFs(root);
        ArrayList<Node> solution = ui.AHeri(root);
        System.out.println("The Code size is :" + solution.size());
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("total time " + totalTime);
        if (solution.size() > 0) {
            System.out.println();
            for (int i = solution.size() - 1; i >= 0; i--) {
                if (solution.get(i).steps != null) {
                    Solution.add(solution.get(i).steps);
                }
            }
            System.out.println();
        } else {
            System.err.println("NO solution");
        }
        for (int i = 0; i < Solution.size(); i++) {
            if (Solution.get(i) == null) {
            } else {
                Solution.get(i).toString();
                enhaced += Solution.get(i);
            }

        }

        /////////////////////////////////////////////
        System.out.println("Here Is The Level Solution");
        EnhanceCode EN = new EnhanceCode(enhaced);
        System.out.println("c:" + EnhanceCode.c);
        System.out.println("b:" + EnhanceCode.b);
        System.out.println("d:" + EnhanceCode.d);
        System.out.println("e:" + EnhanceCode.e);
        System.out.println("f:" + EnhanceCode.f);
        System.out.println("g:" + EnhanceCode.g);
        System.out.println("j:" + EnhanceCode.j);
        System.out.println("h:" + EnhanceCode.h);
        System.out.println("z:" + EnhanceCode.z);
        // String size=Integer.toString(EN.FullCode.length());
        // System.out.println("The Code Size After Enhancement: "+size);
        System.out.println(EN.AddFunctions());

    }

}
