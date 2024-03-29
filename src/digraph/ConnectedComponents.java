package digraph;

/**
 * Created by Pete Wilcox on 5/14/2016.
 * petercwilcox@gmail.com
 */
public class ConnectedComponents
{
    // Class adapted from the textbook
    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponents(Digraph G)
    {
        // Uses the reversed graph's reverse post order to assign component IDs
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());
        for (int i : order.reversePostOrder())
            if (!marked[i])
            {
                dfs(G, i);
                count++;
            }
    }

    private void dfs(Digraph G, int v)
    {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w);
    }

    public boolean stronglyConnected(int v, int w)
    {
        return id[v] == id[w];
    }

    public int id(int v)
    {
        return id[v];
    }

    public int count()
    {
        return count;
    }
}
