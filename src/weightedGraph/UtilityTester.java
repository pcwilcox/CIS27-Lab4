package weightedGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Pete Wilcox on 5/14/2016.
 * petercwilcox@gmail.com
 */
public class UtilityTester
{
    public static void main(String[] args)
    {
        EdgeWeightedGraph G = loadGraph();

        System.out.println("Graph loaded.");
        System.out.println("Creating Minimum-Spanning Tree with root nodes 7, 14, 25, 28, 40.");
        int[] roots = {7, 14, 25, 28, 40};
        MST tree1 = new MST(G, roots);
        System.out.println("MST created:");
        System.out.println(tree1);
        System.out.println("Total cost: " + tree1.cost());

        minCost(G);
    }

    private static void minCost(EdgeWeightedGraph g)
    {
        System.out.println("Testing single-root MST:");
        for (int i = 0; i < 50; i++)
        {
            MST temp = new MST(g, i);
            System.out.println("Test MST " + i + " cost: " + temp.cost());
            System.out.println(temp);
        }
    }

    private static EdgeWeightedGraph loadGraph()
    {
        File graph = new File("C:\\Users\\Pete\\IdeaProjects\\CIS27-Lab4\\src\\weightedGraph\\weightedGraph.txt");

        try
        {
            Scanner in = new Scanner(graph);
            EdgeWeightedGraph test = new EdgeWeightedGraph(in);
            return test;
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}

/* Program output:
Graph loaded.
Creating Minimum-Spanning Tree with root nodes 7, 14, 25, 28, 40.
MST created:
[30, 37, 30] [15, 20, 25] [13, 15, 28] [10, 13, 28] [17, 22, 28]
[37, 38, 25] [33, 38, 25] [33, 49, 20] [33, 39, 25] [36, 39, 25]
[39, 46, 20] [46, 48, 15] [40, 46, 28] [28, 35, 25] [27, 34, 25]
[7, 16, 25] [42, 44, 24] [34, 42, 20] [34, 41, 25] [24, 29, 15]
[24, 25, 25] [14, 19, 23] [43, 47, 15] [41, 43, 14] [41, 45, 23]
[10, 12, 22] [12, 14, 22] [26, 31, 20] [25, 31, 21] [11, 45, 21]
[40, 45, 20] [18, 32, 15] [17, 32, 15] [7, 17, 20] [4, 5, 20]
[23, 28, 18] [0, 6, 17] [1, 6, 18] [8, 9, 16] [14, 21, 16]
[3, 2, 15] [3, 8, 15] [3, 14, 15] [1, 5, 13] [5, 7, 15]
Total cost: 935
Testing single-root MST:
Test MST 0 cost: 1035
[25, 30, 30] [37, 38, 25] [33, 38, 25] [33, 49, 20] [33, 39, 25]
[36, 39, 25] [39, 46, 20] [46, 48, 15] [40, 46, 28] [27, 34, 25]
[42, 44, 24] [34, 42, 20] [34, 41, 25] [11, 45, 21] [40, 45, 20]
[41, 45, 23] [43, 47, 15] [41, 43, 14] [35, 41, 30] [15, 20, 25]
[13, 15, 28] [10, 13, 28] [17, 22, 28] [24, 29, 15] [24, 25, 25]
[28, 35, 25] [26, 31, 20] [25, 31, 21] [19, 25, 25] [23, 28, 18]
[17, 23, 25] [7, 16, 25] [14, 19, 23] [10, 12, 22] [12, 14, 22]
[8, 9, 16] [3, 2, 15] [3, 8, 15] [3, 14, 15] [14, 21, 16]
[18, 21, 20] [18, 32, 15] [17, 32, 15] [7, 17, 20] [4, 5, 20]
[5, 7, 15] [1, 5, 13] [1, 6, 18] [0, 6, 17]
 */

/*  I've omitted the rest of the output. If you use only a single
    field station to supply power, it doesn't matter which vertex
    you use, as the tree will be the same no matter what.
 */