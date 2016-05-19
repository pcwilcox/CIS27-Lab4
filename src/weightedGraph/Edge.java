package weightedGraph;

/**
 * Created by Pete Wilcox on 5/14/2016.
 * petercwilcox@gmail.com
 */
public class Edge
        implements Comparable<Edge>
{
    private final int v;
    private final int w;
    private final int weight;

    public Edge(int v, int w, int weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int weight()
    {
        return weight;
    }

    public int either()
    {
        return v;
    }

    public int other(int vertex)
    {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new RuntimeException("Inconsistent edge.");
    }

    public int otherVertex(boolean[] m)
    {
        if (!m[v]) return v;
        return w;
    }

    public int compareTo(Edge that)
    {
        if (this.weight() < that.weight()) return -1;
        else if (this.weight() > that.weight()) return +1;
        else return 0;
    }

    public boolean isMarked(boolean[] marked)
    {
        return marked[v] == true && marked[w] == true;
    }

    public void mark(boolean[] marked)
    {
        marked[v] = true;
        marked[w] = true;
    }

    public String toString()
    {
        return String.format("[" + v + ", " + w + ", " + weight + "] ");
    }
}
