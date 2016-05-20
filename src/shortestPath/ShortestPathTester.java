package shortestPath;

import java.io.File;
import java.io.FileNotFoundException;
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

        ShortestPath test7 = new ShortestPath(graph, 7);
        ShortestPath test14 = new ShortestPath(graph, 14);
        ShortestPath test25 = new ShortestPath(graph, 25);
        ShortestPath test28 = new ShortestPath(graph, 28);
        ShortestPath test40 = new ShortestPath(graph, 40);

        for (int i = 0; i < 50 && i != 7 && i != 14 && i != 25 && i != 28 && i != 40; i++) {
            System.out.println("Testing vertex " + i + ": ");
            System.out.println("Shortest path from vertex 7: " + test7.distTo(i));
            System.out.println("Shortest path from vertex 14: " + test14.distTo(i));
            System.out.println("Shortest path from vertex 25: " + test25.distTo(i));
            System.out.println("Shortest path from vertex 28: " + test28.distTo(i));
            System.out.println("Shortest path from vertex 40: " + test40.distTo(i));

        }
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
