package digraph;

import java.util.Scanner;

/**
 * Created by Pete Wilcox on 5/14/2016.
 * petercwilcox@gmail.com
 */
public class Digraph
{
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }

    public Digraph(Scanner in)
    {
        this(in.nextInt());
        int E = in.nextInt();
        for (int i = 0; i < E; i++)
        {
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v, w);
        }
    }
    
    public int V()
    {
        return V;
    }

    public int E()
    {
        return E;
    }

    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }

    public Digraph reverse()
    {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++)
            for (int w : adj(v))
                R.addEdge(w, v);
        return R;
    }
}
