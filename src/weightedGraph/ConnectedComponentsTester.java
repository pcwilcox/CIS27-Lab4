package weightedGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Pete Wilcox on 5/14/2016.
 * petercwilcox@gmail.com
 */
public class ConnectedComponentsTester
{
    public static void main(String[] args)
    {
        System.out.println("Loading graph...");
        EdgeWeightedGraph test = loadGraph();
        if (test != null) {
            System.out.println("Graph loaded successfully. Running ConnectedComponents()...");
            ConnectedComponents CC = new ConnectedComponents(test);

            System.out.println("Found " + CC.count() + " components.");

            System.out.println("Components list:");
            for (int i = 0; i < CC.count(); i++) {
                System.out.println("Component " + i + ":");
                for (int j = 0; j < test.V(); j++) {
                    if (CC.id(j) == i) {
                        System.out.print(j + " ");
                    }
                }
                System.out.println();
            }

        }
        else {
            System.out.println("File read error.");
        }
    }

    private static EdgeWeightedGraph loadGraph()
    {
        File graph = new File("C:\\Users\\Pete\\IdeaProjects\\CIS27-Lab4\\src\\digraph\\graph.txt");

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
