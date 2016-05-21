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
            if (i == 7 || i == 14 || i == 25 || i == 28 || i == 40) continue;
            int dist = test7.distTo(i);
            Stack<Edge> path = test7.path(i);
            if (dist > test14.distTo(i)) {
                dist = test14.distTo(i);
                path = test14.path(i);
            }
            if (dist > test25.distTo(i)) {
                dist = test25.distTo(i);
                path = test25.path(i);
            }
            if (dist > test28.distTo(i)) {
                dist = test28.distTo(i);
                path = test28.path(i);
            }
            if (dist > test40.distTo(i)) {
                dist = test40.distTo(i);
                path = test40.path(i);
            }
            System.out.println("Vertex " + i + " minimum distance: " + dist + ". Path: " + path);

        }

        int shortest = 1000000;
        int actualShortest = 0;

        ShortestPath[] paths = new ShortestPath[50];

        for (int i = 0; i < 50; i++)
        {
            paths[i] = new ShortestPath(graph, i);
            if (paths[i].cost() < shortest) {
                actualShortest = i;
                shortest = paths[i].cost();
            }
        }

        System.out.println("Shortest path at vertex " + actualShortest + ". Cost: " + shortest + ". Tree: " + paths[actualShortest]);
    }

    private static EdgeWeightedGraph loadGraph()
    {
        File graph = new File("C:\\Users\\Pete\\IdeaProjects\\CIS27-Lab4\\src\\weightedGraph\\weightedGraph.txt");

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

/* Program Output:
vertex 0- root 7: 52 root 14: 60 root 25: 108 root 28: 110 root 40: 170
vertex 1- root 7: 28 root 14: 73 root 25: 121 root 28: 86 root 40: 146
vertex 2- root 7: 65 root 14: 30 root 25: 78 root 28: 103 root 40: 160
vertex 3- root 7: 50 root 14: 15 root 25: 63 root 28: 88 root 40: 145
vertex 4- root 7: 31 root 14: 80 root 25: 128 root 28: 89 root 40: 149
vertex 5- root 7: 15 root 14: 60 root 25: 108 root 28: 73 root 40: 133
vertex 6- root 7: 35 root 14: 55 root 25: 103 root 28: 93 root 40: 153
vertex 7- root 7: 0 root 14: 65 root 25: 100 root 28: 58 root 40: 118
vertex 8- root 7: 35 root 14: 30 root 25: 78 root 28: 80 root 40: 140
vertex 9- root 7: 51 root 14: 46 root 25: 94 root 28: 96 root 40: 156
vertex 10- root 7: 95 root 14: 44 root 25: 92 root 28: 128 root 40: 182
vertex 11- root 7: 157 root 14: 177 root 25: 134 root 28: 99 root 40: 41
vertex 12- root 7: 73 root 14: 22 root 25: 70 root 28: 106 root 40: 160
vertex 13- root 7: 123 root 14: 64 root 25: 95 root 28: 148 root 40: 183
vertex 14- root 7: 65 root 14: 0 root 25: 48 root 28: 84 root 40: 138
vertex 15- root 7: 101 root 14: 36 root 25: 80 root 28: 120 root 40: 168
vertex 16- root 7: 25 root 14: 87 root 25: 115 root 28: 65 root 40: 125
vertex 17- root 7: 20 root 14: 57 root 25: 85 root 28: 38 root 40: 98
vertex 18- root 7: 75 root 14: 36 root 25: 55 root 28: 48 root 40: 105
vertex 19- root 7: 88 root 14: 23 root 25: 25 root 28: 92 root 40: 115
vertex 20- root 7: 100 root 14: 35 root 25: 55 root 28: 119 root 40: 143
vertex 21- root 7: 70 root 14: 16 root 25: 55 root 28: 68 root 40: 125
vertex 22- root 7: 48 root 14: 85 root 25: 112 root 28: 30 root 40: 90
vertex 23- root 7: 45 root 14: 66 root 25: 72 root 28: 18 root 40: 78
vertex 24- root 7: 92 root 14: 58 root 25: 25 root 28: 57 root 40: 80
vertex 25- root 7: 113 root 14: 48 root 25: 0 root 28: 82 root 40: 93
vertex 26- root 7: 128 root 14: 63 root 25: 30 root 28: 112 root 40: 113
vertex 27- root 7: 75 root 14: 120 root 25: 125 root 28: 43 root 40: 77
vertex 28- root 7: 58 root 14: 84 root 25: 82 root 28: 0 root 40: 60
vertex 29- root 7: 77 root 14: 73 root 25: 40 root 28: 42 root 40: 65
vertex 30- root 7: 112 root 14: 78 root 25: 30 root 28: 77 root 40: 63
vertex 31- root 7: 134 root 14: 69 root 25: 21 root 28: 103 root 40: 93
vertex 32- root 7: 30 root 14: 42 root 25: 70 root 28: 48 root 40: 108
vertex 33- root 7: 164 root 14: 134 root 25: 86 root 28: 118 root 40: 58
vertex 34- root 7: 88 root 14: 114 root 25: 103 root 28: 30 root 40: 52
vertex 35- root 7: 83 root 14: 103 root 25: 70 root 28: 25 root 40: 35
vertex 36- root 7: 114 root 14: 110 root 25: 63 root 28: 68 root 40: 30
vertex 37- root 7: 142 root 14: 104 root 25: 56 root 28: 96 root 40: 58
vertex 38- root 7: 167 root 14: 109 root 25: 61 root 28: 121 root 40: 83
vertex 39- root 7: 139 root 14: 134 root 25: 86 root 28: 93 root 40: 40
vertex 40- root 7: 118 root 14: 138 root 25: 93 root 28: 60 root 40: 0
vertex 41- root 7: 113 root 14: 133 root 25: 100 root 28: 55 root 40: 27
vertex 42- root 7: 101 root 14: 134 root 25: 123 root 28: 50 root 40: 72
vertex 43- root 7: 125 root 14: 147 root 25: 114 root 28: 67 root 40: 41
vertex 44- root 7: 125 root 14: 158 root 25: 147 root 28: 74 root 40: 82
vertex 45- root 7: 136 root 14: 156 root 25: 113 root 28: 78 root 40: 20
vertex 46- root 7: 146 root 14: 154 root 25: 106 root 28: 88 root 40: 28
vertex 47- root 7: 137 root 14: 162 root 25: 129 root 28: 82 root 40: 56
vertex 48- root 7: 161 root 14: 169 root 25: 121 root 28: 111 root 40: 43
vertex 49- root 7: 181 root 14: 154 root 25: 106 root 28: 138 root 40: 63

Path root 0. Cost: 5625. Tree: *ommitted*
...
Path root 29. Cost: 3760. Tree: *ommitted*
Old shortest: 3800
New shortest: 3760
...
Shortest path at vertex 29.

 */