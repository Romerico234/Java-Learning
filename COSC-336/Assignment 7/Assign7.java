import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assign7 {
    public static void main(String[] args) {
        int[] input1 = {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0};
        int[] input2 = fileReader("input-7-1.txt");
        int[] input3 = fileReader("input-7-2.txt");
    
        Adj_List_Graph A0 = new Adj_List_Graph((int)Math.sqrt(input1.length));
        Adj_List_Graph B0 = new Adj_List_Graph((int)Math.sqrt(input2.length));
        Adj_List_Graph C0 = new Adj_List_Graph((int)Math.sqrt(input3.length));

        //Getting G
    
        for (int i = 0; i < A0.n; i++) 
          for (int j = 0; j < A0.n; j++) 
            if (input1[i * A0.n + j] == 1) 
              A0.addEdge(i, j);
        
    
        for (int i = 0; i < B0.n; i++) 
          for (int j = 0; j < B0.n; j++) 
            if (input2[i * B0.n + j] == 1) 
              B0.addEdge(i, j);
        
    
        for (int i = 0; i < C0.n; i++) 
          for (int j = 0; j < C0.n; j++) 
            if (input3[i * C0.n + j] == 1)
              C0.addEdge(i, j);
        

        //Getting G^2
        Adj_List_Graph A = new Adj_List_Graph(A0);
        Adj_List_Graph B = new Adj_List_Graph(B0);
        Adj_List_Graph C = new Adj_List_Graph(C0);

        for (int i = 0; i < A0.n; i++) {
          for (int j = 0; j < A0.n; j++) 
            if (A0.adj.get(i).contains(j)) {
              for (int k = 0; k < A0.n; k++) 
                if (A0.adj.get(j).contains(k)) 
                  A.addEdge(i, k);
            }
        }

        for (int i = 0; i < B0.n; i++) {
          for (int j = 0; j < B0.n; j++) 
            if (B0.adj.get(i).contains(j)) {
              for (int k = 0; k < B0.n; k++) 
                if (B0.adj.get(j).contains(k)) 
                  B.addEdge(i, k);
            }
        }

        for (int i = 0; i < C0.n; i++) {
          for (int j = 0; j < C0.n; j++) 
            if (C0.adj.get(i).contains(j)) {
              for (int k = 0; k < C0.n; k++) 
                if (C0.adj.get(j).contains(k)) 
                  C.addEdge(i, k);
            }
        }


        // System.out.print("Adjacency List of  A^2:");
        // A.printGraph();
        System.out.print("Adjacency List of  B:");
        B.printGraph();
        System.out.print("Adjacency List of C:");
        C.printGraph();
      }
    
      public static int[] fileReader(String fileName) {
        try {
          File file = new File(fileName);
          Scanner fileReader = new Scanner(file);
          int size = 0;
          if (fileReader.hasNextInt())
            size = (int)Math.pow(fileReader.nextInt(), 2);
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
}
