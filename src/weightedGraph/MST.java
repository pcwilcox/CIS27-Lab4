package weightedGraph;

/**
 * Created by Pete Wilcox on 5/16/2016.
 * petercwilcox@gmail.com
 */
public class MST
        implements Comparable<MST>
{
    private EdgeWeightedGraph G;
    private boolean[] marked;
    private int[] edgeTo;
    private int cost;
    private Bag<Edge> tree;
    private MinHeap<Edge> possibles;
    private int root;

    public MST(EdgeWeightedGraph g, int[] roots)
    {
        G = g;
        tree = new Bag<>();
        possibles = new MinHeap<>();
        marked = new boolean[G.V()];
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
            //System.out.println("Possibles not empty yet - removed " + temp + ".");
            if (!temp.isMarked(marked))
            {

                tree.add(temp);
                cost += temp.weight();

                for (Edge e : G.adj(temp.otherVertex(marked)))
                    possibles.insert(e);

                temp.mark(marked);


                //System.out.println("Added edge " + temp);
            }
        }
    }

    public MST(EdgeWeightedGraph g, int root)
    {
        G = g;
        tree = new Bag<>();
        possibles = new MinHeap<>();
        marked = new boolean[G.V()];
        cost = 0;
        this.root = root;

        marked[root] = true;
        for (Edge e : G.adj(root))
            possibles.insert(e);

        while (!possibles.isEmpty())
        {

            Edge temp = possibles.remove();
            //System.out.println("Possibles not empty yet - removed " + temp + ".");
            if (!temp.isMarked(marked))
            {
                tree.add(temp);
                cost += temp.weight();
                for (Edge e : G.adj(temp.otherVertex(marked)))
                    possibles.insert(e);
                temp.mark(marked);
            }
        }
    }

    public int cost()
    {
        return cost;
    }

    public String toString()
    {
        String output = "";
        for (Edge e : tree)
            output = output + e;
        return output;
    }

    public int compareTo(MST that)
    {
        if (this.cost() < that.cost()) return -1;
        else if (this.cost() > that.cost()) return 1;
        else return 0;
    }

    public int root() { return root;}
}
