package shortestPath;

/**
 * Created by Pete Wilcox on 5/14/2016.
 * petercwilcox@gmail.com
 */
public class Edge
        implements Comparable<Edge>
{
    // Slightly modified version to make Dijkstra's easier
    private final int from;
    private final int to;
    private final int weight;

    public Edge(int v, int w, int weight)
    {
        this.from = v;
        this.to = w;
        this.weight = weight;
    }

    public int weight()
    {
        return weight;
    }

    public int either()
    {
        return from;
    }

    public int to()
    {
        return to;
    }

    public int from()
    {
        return from;
    }

    public int other(int vertex)
    {
        if (vertex == from) return to;
        else if (vertex == to) return from;
        else throw new RuntimeException("Inconsistent edge.");
    }

    public int otherVertex(boolean[] m)
    {
        if (!m[from]) return from;
        return to;
    }

    public int compareTo(Edge that)
    {
        if (this.weight() < that.weight()) return -1;
        else if (this.weight() > that.weight()) return +1;
        else return 0;
    }

    public boolean isMarked(boolean[] marked)
    {
        return marked[from] == true && marked[to] == true;
    }

    public void mark(boolean[] marked)
    {
        marked[from] = true;
        marked[to] = true;
    }

    public String toString()
    {
        return String.format("[" + from + ", " + to + ", " + weight + "] ");
    }
}
