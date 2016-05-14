package digraph;

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
        Digraph test = loadGraph();
        if (test != null) {
            System.out.println("Graph loaded successfully.");
        }
        else {
            System.out.println("File read error.");
        }
    }

    private static Digraph loadGraph()
    {
        File graph = new File("graph.txt");

        try
        {
            Scanner in = new Scanner(graph);
            Digraph test = new Digraph(in);
            return test;
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
