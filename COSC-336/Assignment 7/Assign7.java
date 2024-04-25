import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assign7 {
    public static void main(String[] args) {
        int[] input1 = { 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0 };
        int[] input2 = fileReader("input-7-1.txt");
        int[] input3 = fileReader("input-7-2.txt");

        // Getting G
        Adj_List_Graph A0 = createGraph(input1);
        Adj_List_Graph B0 = createGraph(input2);
        Adj_List_Graph C0 = createGraph(input3);

        // Getting G^2
        Adj_List_Graph A = createGraphSquared(A0);
        Adj_List_Graph B = createGraphSquared(B0);
        Adj_List_Graph C = createGraphSquared(C0);

        // System.out.print("Adjacency List of A^2:");
        // A.printGraph();
        // System.out.println("---------------------");
        // System.out.print("Adjacency List of B^2:");
        // B.printGraph();
        // System.out.println("---------------------");
        System.out.print("Adjacency List of C^2:");
        C.printGraph();
    }

    public static int[] fileReader(String fileName) {
        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            int size = 0;
            if (fileReader.hasNextInt())
                size = (int) Math.pow(fileReader.nextInt(), 2);
            int[] list = new int[size];
            int i = 0;
            while (fileReader.hasNextInt())
                list[i++] = fileReader.nextInt();
            fileReader.close();
            return list;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        return null;
    }

    public static Adj_List_Graph createGraph(int[] input) {
        Adj_List_Graph g = new Adj_List_Graph((int) Math.sqrt(input.length));
        for (int i = 0; i < g.n; i++)
            for (int j = 0; j < g.n; j++)
                if (input[i * g.n + j] == 1)
                    g.addEdge(i, j);
        return g;
    }

    public static Adj_List_Graph createGraphSquared(Adj_List_Graph g) {
        Adj_List_Graph g2 = new Adj_List_Graph(g);
        for (int i = 0; i < g.n; i++) 
            for (int j = 0; j < g.n; j++)
                for (int k = 0; k < g.n; k++)
                    if (g.adj.get(i).contains(j) && g.adj.get(j).contains(k))
                        g2.addEdge(i, k);
        return g2;
    }
}
