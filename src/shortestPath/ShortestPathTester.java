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
            int path7 = test7.distTo(i);
            int path14 = test14.distTo(i);
            int path25 = test25.distTo(i);
            int path28 = test28.distTo(i);
            int path40 = test40.distTo(i);

            IndexMinHeap<Integer, ShortestPath> pq = new IndexMinHeap<>();
            pq.insert(test7, path7);
            pq.insert(test14, path14);
            pq.insert(test25, path25);
            pq.insert(test28, path28);
            pq.insert(test40, path40);

            System.out.println("Shortest path:" + pq.minKey());
            System.out.println("Tree: " + pq.minItem());


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
