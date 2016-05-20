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
