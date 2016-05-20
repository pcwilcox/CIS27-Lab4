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

    private static Digraph loadGraph()
    {
        File graph = new File("C:\\Users\\Pete\\IdeaProjects\\CIS27-Lab4\\src\\digraph\\graph.txt");

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

/* Program output:
Loading graph...
Graph loaded successfully. Running ConnectedComponents()...
Found 9 components.
Components list:
Component 0:
2 5 6 8 9 11 12 13 15 16 18 19 21 22 23 25 26 28 29 30 31 32 33 34 35 37 38 39 40 42 43 44 46 47 48 49
Component 1:
14
Component 2:
3 4 17 20 24 27 36
Component 3:
41
Component 4:
7
Component 5:
45
Component 6:
1
Component 7:
0
Component 8:
10

 */