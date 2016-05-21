package shortestPath;

/**
 * Created by Pete Wilcox on 5/19/2016.
 * petercwilcox@gmail.com
 */
public class ShortestPath
{
    // Uses Dijkstra's algorithm to find shortest path to each reachable node
    private EdgeWeightedGraph g;
    private Edge[] edgeTo;
    private int[] distTo;
    private int V;
    private int E;
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

    // Relax all adjacent edges and update distance values
    private void relax(int v)
    {
        for (Edge e : g.adj(v))
        {
            int w = e.other(v);
            if (distTo[w] > distTo[v] + e.weight())
            {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w))
                {
                    pq.change(w, distTo[w]);
                } else
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
            output = output + "[" + i + "," + distTo[i] + "," + edgeTo[i] + "]";
        }
        return output;
    }

    // Returns the distance to a particular vertex
    public int distTo(int v)
    {
        return distTo[v];
    }

    // Returns total cost of the entire tree
    public int cost()
    {
        cost = 0;
        for (int i = 0; i < V; i++)
        {
            cost += distTo(i);
        }
        return cost;
    }

    // Returns the path from a vertex to the root of the tree.
    // Stored as a stack so that iterating through it will
    // lead from the root to the vertex.
    public Stack<Edge> path(int v)
    {
        Stack<Edge> path = new Stack<>();
        int current = v;
        while (edgeTo[current] != null)
        {
            Edge temp = edgeTo[current];
            path.push(temp);
            current = temp.other(current);
        }
        return path;
    }
}
