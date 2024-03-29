package digraph;

/**
 * Created by Pete Wilcox on 5/14/2016.
 * petercwilcox@gmail.com
 */
public class DepthFirstOrder
{
    // Class adapted from textbook
    private boolean[] marked;

    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G)
    {
        pre = new Queue<Integer>();
        post = new Queue<Integer>();
        reversePost = new Stack<Integer>();
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }

    private void dfs(Digraph G, int v)
    {
        pre.enqueue(v);

        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w);

        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> preorder()
    {
        return pre;
    }

    public Iterable<Integer> postorder()
    {
        return post;
    }

    public Iterable<Integer> reversePostOrder()
    {
        return reversePost;
    }
}
