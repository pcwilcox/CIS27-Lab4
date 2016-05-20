package shortestPath;

/**
 * Created by Pete Wilcox on 5/19/2016.
 * petercwilcox@gmail.com
 */
public class ShortestPath
{
    private EdgeWeightedGraph g;
    private Edge[] edgeTo;
    private int[] distTo;
    private int V;
    private int E;
    private IndexMinHeap<Integer, Integer> pq;
    private Bag<Edge> path;
    private boolean[] marked;

    public ShortestPath(EdgeWeightedGraph G, int root) {
        g = G;
        V = G.V();
        E = G.E();

        edgeTo = new Edge[V];
        distTo = new int[V];
        pq = new IndexMinHeap<>();
        path = new Bag<>();

        for (int i = 0; i < V; i++)
            distTo[i] = Integer.MAX_VALUE;
        distTo[root] = 0;

        pq.insert(root, 0);

        while (!pq.isEmpty()) {
            int v = pq.remove();




        }
    }
}
