package weightedGraph;

import java.util.ArrayList;

/**
 * Created by Pete Wilcox on 5/16/2016.
 * petercwilcox@gmail.com
 */
public class MST
{
    private EdgeWeightedGraph G;
    private boolean[] marked;
    private int[] edgeTo;
    private int cost;
    private ArrayList<Edge> tree;
    private EdgeHeap possibles;

    public MST(EdgeWeightedGraph g, int[] roots)
    {
        G = g;
        tree = new ArrayList<>();
        possibles = new EdgeHeap();
        cost = 0;

        for (int i = 0; i < roots.length; i++)
        {
            marked[roots[i]] = true;
            for (Edge e : G.adj(roots[i]))
                possibles.insert(e);
        }

        while (!possibles.isEmpty())
        {
            Edge temp = possibles.remove();
            if (!marked[temp.either()] && !marked[temp.other(temp.either())])
            {
                if (!marked[temp.either()])
                    marked[temp.either()] = true;
                else
                    marked[temp.other(temp.either())] = true;

                tree.add(temp);
                cost += temp.weight();
            }
        }
    }
}
