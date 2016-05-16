package weightedGraph;

import java.util.ArrayList;

/**
 * Created by Pete Wilcox on 5/16/2016.
 * petercwilcox@gmail.com
 */
public class EdgeHeap
{
    private Edge[] heap;
    private int size;

    // Sink an element to its proper place
    private void sink(int i)
    {
        while (2 * i < size)
        {
            int j = 2 * i;
            if (j < size && less(j + 1, j))
            {
                j++;
            }
            if (!less(j, i))
            {
                break;
            }
            exch(i, j);
            i = j;
        }
    }

    // Swim an element upwards
    private void swim(int i)
    {
        while (i > 1 && less(i, i / 2))
        {
            exch(i / 2, i);
            i /= 2;
        }
    }

    public EdgeHeap()
    {
        heap = new Edge[1];
        size = 0;
    }

    // Add an element, resizing if necessary
    public void insert(Edge e)
    {
        if (++size == heap.length)
        {
            resize();
        }

        heap[size] = e;
        swim(size);

    }

    // Swap the first and last elements,
    // remove the last, sink the first,
    // resize if necessary
    public Edge remove()
    {
        exch(1, size);
        Edge temp = heap[size--];
        sink(1);
        if (size <= heap.length / 2)
        {
            resize();
        }
        return temp;
    }

    private boolean less(int a, int b)
    {
        return heap[a].compareTo(heap[b]) < 0;
    }

    private void exch(int a, int b)
    {
        Edge temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public String toString()
    {
        String output = "";

        for (int i = 1; i <= size; i++)
        {
            output = output + heap[i] + " ";
        }
        return output;
    }

    // Helper to resize as necessary
    private void resize()
    {
        Edge[] newHeap = new Edge[2 * size];
        for (int i = 1; i <= size &&
                        i < heap.length &&
                        i < newHeap.length; i++)
        {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }


}
