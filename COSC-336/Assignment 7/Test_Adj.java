import java.util.*;
import java.io.*;

public class Test_Adj {
  public static void main(String[] args) {
    int V = 5;

    Adj_List_Graph a = new Adj_List_Graph(V);

    a.addEdge(0, 1);
    a.addEdge(0, 4);
    a.addEdge(1, 2);
    a.addEdge(1, 3);
    a.addEdge(1, 4);
    a.addEdge(2, 3);
    a.addEdge(3, 4);

    a.printGraph();
  }
}
