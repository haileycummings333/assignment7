import java.util.Scanner;
/*
4 (code) Directed or undirected [10 points] Write a program that takes a matrix of size n x n as input and
determines whether that matrix is the representation of a directed graph.
 */
public class DirectedGraphChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter the size of the matrix (n): ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        boolean isDirectedGraph = isDirectedGraph(matrix, n);

        if (isDirectedGraph) {
            System.out.println("The given matrix represents a directed graph.");
        } else {
            System.out.println("The given matrix does not represent a directed graph.");
        }

        scanner.close();
    }

    public static boolean isDirectedGraph(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // check if the matrix is symmetric along the main diagonal
                if (i != j && matrix[i][j] != matrix[j][i]) {
                    return false;
                }

                // check if there are loops
                if (i == j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
