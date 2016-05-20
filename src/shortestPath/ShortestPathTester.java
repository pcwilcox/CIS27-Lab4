package shortestPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Pete Wilcox on 5/20/2016.
 * petercwilcox@gmail.com
 */
public class ShortestPathTester
{
    public static void main(String[] args)
    {
        EdgeWeightedGraph graph = loadGraph();

        ShortestPath test7  = new ShortestPath(graph, 7);
        ShortestPath test14 = new ShortestPath(graph, 14);
        ShortestPath test25 = new ShortestPath(graph, 25);
        ShortestPath test28 = new ShortestPath(graph, 28);
        ShortestPath test40 = new ShortestPath(graph, 40);

        for (int i = 0; i < 50; i++)
        {
            System.out.println(
                    "Testing vertex " + i + ": " + test7.distTo(i) + " " + test14.distTo(i) + " " + test25.distTo(i) +
                    " " + test28.distTo(i) + " " + test40.distTo(i));

        }

        int shortest = 1000000;
        int actualShortest = 0;

        for (int i = 0; i < 50; i++)
        {
            ShortestPath temp = new ShortestPath(graph, i);
            int w = temp.cost();
            System.out.println("Path root " + i + ". Cost: " + w + ". Tree: " + temp);

            if (shortest > w)
            {
                System.out.println("Old shortest: " + shortest);
                shortest = w;
                actualShortest = i;
                System.out.println("New shortest: " + shortest);
            }
        }

        System.out.println("Shortest path at vertex " + actualShortest + ".");


    }

    private static EdgeWeightedGraph loadGraph()
    {
        File graph = new File("C:\\Users\\Lord Yod\\IdeaProjects\\CIS27-Lab4\\src\\weightedGraph\\weightedGraph.txt");

        try
        {
            Scanner           in   = new Scanner(graph);
            EdgeWeightedGraph test = new EdgeWeightedGraph(in);
            return test;
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
