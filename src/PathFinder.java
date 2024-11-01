// Java program to print all paths of source to
// destination in given graph
import java.util.*;

class Graph{

    private static void printPath(List<Integer> path)
    {
        int size = path.size();
        for(Integer v : path)
        {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    private static boolean isNotVisited(int x,
                                        List<Integer> path)
    {
        int size = path.size();
        for(int i = 0; i < size; i++)
            if (path.get(i) == x)
                return false;

        return true;
    }

    private static void findpaths(List<List<Integer> > g,
                                  int start, int end, int v)
    {

        Queue<List<Integer> > queue = new LinkedList<>();

        List<Integer> path = new ArrayList<>();
        path.add(start);
        queue.offer(path);

        while (!queue.isEmpty())
        {
            path = queue.poll();
            int ending = path.get(path.size() - 1);

            if (ending == end)
            {
                printPath(path);
            }


            List<Integer> lastNode = g.get(ending);
            for(int i = 0; i < lastNode.size(); i++)
            {
                if (isNotVisited(lastNode.get(i), path))
                {
                    List<Integer> newpath = new ArrayList<>(path);
                    newpath.add(lastNode.get(i));
                    queue.offer(newpath);
                }
            }
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        List<List<Integer> > g = new ArrayList<>();
        int v = 4;
        for(int i = 0; i < 4; i++)
        {
            g.add(new ArrayList<>());
        }


        g.get(0).add(3);
        g.get(0).add(1);
        g.get(0).add(2);
        g.get(1).add(3);
        g.get(2).add(0);
        g.get(2).add(1);
        int start = 2, dst = 3;
        System.out.println("path from src " + start +
                " to dst " + dst + " are ");

        // Function for finding the paths
        findpaths(g, start, dst, v);
    }
}

