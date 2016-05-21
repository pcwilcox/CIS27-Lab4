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

        // Create a SPT for each field station node
        ShortestPath test7 = new ShortestPath(graph, 7);
        ShortestPath test14 = new ShortestPath(graph, 14);
        ShortestPath test25 = new ShortestPath(graph, 25);
        ShortestPath test28 = new ShortestPath(graph, 28);
        ShortestPath test40 = new ShortestPath(graph, 40);

        // Iterate through all other nodes to
        // determine shortest individual path
        for (int i = 0; i < 50; i++)
        {
            // Skip it if it's a field station
            if (i == 7 || i == 14 || i == 25 || i == 28 || i == 40) continue;

            // Store distance in an array, path is stored as a stack
            int dist = test7.distTo(i);
            Stack<Edge> path = test7.path(i);

            // Filter for smallest distance
            if (dist > test14.distTo(i))
            {
                dist = test14.distTo(i);
                path = test14.path(i);
            }
            if (dist > test25.distTo(i))
            {
                dist = test25.distTo(i);
                path = test25.path(i);
            }
            if (dist > test28.distTo(i))
            {
                dist = test28.distTo(i);
                path = test28.path(i);
            }
            if (dist > test40.distTo(i))
            {
                dist = test40.distTo(i);
                path = test40.path(i);
            }

            System.out.println("Vertex "
                               + i
                               + " minimum distance: "
                               + dist
                               + ". Path: "
                               + path);

        }

        // Now we'll sort for smallest overall SPT
        // These two are for tracking which one it is
        int shortest = 1000000;
        int actualShortest = 0;

        // Store each path in an array
        ShortestPath[] paths = new ShortestPath[50];

        // Iterate through the array, assign path as appropriate
        for (int i = 0; i < 50; i++)
        {
            paths[i] = new ShortestPath(graph, i);

            // Simple search for smallest one
            if (paths[i].cost() < shortest)
            {
                actualShortest = i;
                shortest = paths[i].cost();
            }
        }

        System.out.println("Shortest path at vertex "
                           + actualShortest
                           + ". Cost: "
                           + shortest
                           + ". Tree: "
                           + paths[actualShortest]);
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

/* Program Output:
Vertex 0 minimum distance: 52. Path: [5, 7, 15] [5, 6, 20] [0, 6, 17]
Vertex 1 minimum distance: 28. Path: [5, 7, 15] [1, 5, 13]
Vertex 2 minimum distance: 30. Path: [3, 14, 15] [3, 2, 15]
Vertex 3 minimum distance: 15. Path: [3, 14, 15]
Vertex 4 minimum distance: 31. Path: [4, 7, 31]
Vertex 5 minimum distance: 15. Path: [5, 7, 15]
Vertex 6 minimum distance: 35. Path: [5, 7, 15] [5, 6, 20]
Vertex 8 minimum distance: 30. Path: [3, 14, 15] [3, 8, 15]
Vertex 9 minimum distance: 46. Path: [3, 14, 15] [3, 9, 31]
Vertex 10 minimum distance: 44. Path: [12, 14, 22] [10, 12, 22]
Vertex 11 minimum distance: 41. Path: [40, 45, 20] [11, 45, 21]
Vertex 12 minimum distance: 22. Path: [12, 14, 22]
Vertex 13 minimum distance: 64. Path: [14, 15, 36] [13, 15, 28]
Vertex 15 minimum distance: 36. Path: [14, 15, 36]
Vertex 16 minimum distance: 25. Path: [7, 16, 25]
Vertex 17 minimum distance: 20. Path: [7, 17, 20]
Vertex 18 minimum distance: 36. Path: [14, 21, 16] [18, 21, 20]
Vertex 19 minimum distance: 23. Path: [14, 19, 23]
Vertex 20 minimum distance: 35. Path: [14, 20, 35]
Vertex 21 minimum distance: 16. Path: [14, 21, 16]
Vertex 22 minimum distance: 30. Path: [22, 28, 30]
Vertex 23 minimum distance: 18. Path: [23, 28, 18]
Vertex 24 minimum distance: 25. Path: [24, 25, 25]
Vertex 26 minimum distance: 30. Path: [25, 26, 30]
Vertex 27 minimum distance: 43. Path: [27, 28, 43]
Vertex 29 minimum distance: 40. Path: [24, 25, 25] [24, 29, 15]
Vertex 30 minimum distance: 30. Path: [25, 30, 30]
Vertex 31 minimum distance: 21. Path: [25, 31, 21]
Vertex 32 minimum distance: 30. Path: [7, 32, 30]
Vertex 33 minimum distance: 58. Path: [40, 46, 28] [33, 46, 30]
Vertex 34 minimum distance: 30. Path: [28, 34, 30]
Vertex 35 minimum distance: 25. Path: [28, 35, 25]
Vertex 36 minimum distance: 30. Path: [36, 40, 30]
Vertex 37 minimum distance: 56. Path: [25, 31, 21] [31, 37, 35]
Vertex 38 minimum distance: 61. Path: [25, 31, 21] [31, 38, 40]
Vertex 39 minimum distance: 40. Path: [39, 40, 40]
Vertex 41 minimum distance: 27. Path: [40, 41, 27]
Vertex 42 minimum distance: 50. Path: [28, 34, 30] [34, 42, 20]
Vertex 43 minimum distance: 41. Path: [40, 41, 27] [41, 43, 14]
Vertex 44 minimum distance: 74. Path: [28, 34, 30] [34, 42, 20] [42, 44, 24]
Vertex 45 minimum distance: 20. Path: [40, 45, 20]
Vertex 46 minimum distance: 28. Path: [40, 46, 28]
Vertex 47 minimum distance: 56. Path: [40, 41, 27] [41, 43, 14] [43, 47, 15]
Vertex 48 minimum distance: 43. Path: [40, 46, 28] [46, 48, 15]
Vertex 49 minimum distance: 63. Path: [40, 46, 28] [46, 49, 35]
Shortest path at vertex 29. Cost: 3760. Tree:
[0,125,[0, 2, 30] ][1,105,[1, 5, 13] ][2,95,[3, 2, 15] ]
[3,80,[3, 21, 20] ][4,108,[4, 7, 31] ][5,92,[5, 7, 15] ]
[6,112,[6, 8, 25] ][7,77,[7, 17, 20] ][8,87,[8, 32, 32] ]
[9,103,[8, 9, 16] ][10,117,[10, 12, 22] ][11,104,[11, 45, 21] ]
[12,95,[12, 14, 22] ][13,120,[13, 20, 40] ][14,73,[14, 19, 23] ]
[15,105,[15, 20, 25] ][16,87,[16, 17, 30] ][17,57,[17, 23, 25] ]
[18,40,[18, 29, 40] ][19,50,[19, 24, 35] ][20,80,[19, 20, 30] ]
[21,60,[18, 21, 20] ][22,72,[22, 28, 30] ][23,32,[23, 29, 32] ]
[24,15,[24, 29, 15] ][25,40,[24, 25, 25] ][26,70,[25, 26, 30] ]
[27,85,[27, 28, 43] ][28,42,[28, 29, 42] ][29,0,null]
[30,35,[29, 30, 35] ][31,61,[25, 31, 21] ][32,55,[18, 32, 15] ]
[33,87,[33, 39, 25] ][34,63,[34, 35, 33] ][35,30,[29, 35, 30] ]
[36,37,[29, 36, 37] ][37,65,[30, 37, 30] ][38,90,[37, 38, 25] ]
[39,62,[36, 39, 25] ][40,65,[35, 40, 35] ][41,60,[35, 41, 30] ]
[42,83,[34, 42, 20] ][43,74,[41, 43, 14] ][44,107,[42, 44, 24] ]
[45,83,[41, 45, 23] ][46,82,[39, 46, 20] ][47,89,[43, 47, 15] ]
[48,97,[46, 48, 15] ][49,107,[33, 49, 20] ]

 */