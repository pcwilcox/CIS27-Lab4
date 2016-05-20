package shortestPath;

/**
 * Created by Pete Wilcox on 5/19/2016.
 * petercwilcox@gmail.com
 */
public class ShortestPath
{
    private EdgeWeightedGraph              g;
    private Edge[]                         edgeTo;
    private int[]                          distTo;
    private int                            V;
    private int                            E;
    private IndexMinHeap pq;
    private int cost;

    public ShortestPath(EdgeWeightedGraph G, int root)
    {
        g = G;
        V = G.V();
        E = G.E();

        edgeTo = new Edge[V];
        distTo = new int[V];
        pq = new IndexMinHeap();

        for (int i = 0; i < V; i++)
        {
            distTo[i] = Integer.MAX_VALUE;
        }
        distTo[root] = 0;

        pq.insert(root, 0);

        while (!pq.isEmpty())
        {
            relax(pq.remove());
        }
    }

    private void relax(int v)
    {
        for (Edge e : g.adj(v))
        {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight())
            {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w))
                {
                    pq.change(w, distTo[w]);
                }
                else
                {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public String toString()
    {
        String output = "";
        for (int i = 0; i < V; i++)
        {
            output = output + "[Vertex: " + i + ", distTo: " + distTo[i] + ", edgeTo: " + edgeTo[i].from() + "]";
        }
        return output;
    }

    public int distTo(int v)
    {
        return distTo[v];
    }

    public int cost() {
        for (int i = 0; i < V; i++) {
            cost += distTo(i);
        }
        return cost;
    }
}
