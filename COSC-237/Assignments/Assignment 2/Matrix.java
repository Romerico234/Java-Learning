//Matrix Class
//Romerico David
//Julian Halsey
//Michael Reifer

import java.util.Random;

public class Matrix {
    private final int MAX = 20;
    private int size;
    private int[][] table = new int[MAX][MAX];

    public Matrix() {
        size = 0;
    }

    public Matrix(int s) {
        size = s;
    }

    public int getSize() {
        return size;
    }

    public int getElement(int r, int c) {
        return (r < 0 || r > size || c < 0 || c > size) ? 0 : table[r][c];
    }

    public void setElement(int r, int c, int value) {
        if (!(r < 0 || r > size || c < 0 || c > size))
            table[r][c] = value;
    }

    public void init(int min, int max) {
        Random rand = new Random();

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++)
                table[r][c] = rand.nextInt(max - min + 1) + min;
        }
    }

    public void print() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++)
                System.out.printf("%4d", table[r][c]);
            System.out.println();
        }
    }

    public boolean equals(Matrix a) {
        if (size != a.size)
            return false;

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (table[r][c] != a.table[r][c])
                    return false;
            }
        }

        return true;
    }

    public void copy(Matrix a) {
        size = a.size;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++)
                table[r][c] = a.table[r][c];
        }
    }

    public Matrix getCopy() {
        Matrix copy = new Matrix(size);
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++)
                copy.table[r][c] = table[r][c];
        }
        return copy;
    }

    public Matrix add(Matrix a) {
        Matrix sum = new Matrix(size);
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++)
                sum.table[r][c] = table[r][c] + a.table[r][c];
        }
        return sum;
    }

    public Matrix subtract(Matrix a) {
        Matrix difference = new Matrix(size);
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++)
                difference.table[r][c] = table[r][c] - a.table[r][c];
        }
        return difference;
    }

    public Matrix multiply(Matrix a) {
        Matrix product = new Matrix(size);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                for (int i = 0; i < size; i++)
                    product.table[row][col] += table[row][i] * a.table[i][col];
            }
        }
        return product;
    }

    public Matrix multiplyByConstant(int constant) {
        Matrix product = new Matrix(size);
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++)
                product.table[r][c] = table[r][c] * constant;
        }
        return product;
    }

    public Matrix transpose() {
        Matrix transposedMatrix = new Matrix(size);
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++)
                transposedMatrix.table[c][r] = table[r][c];
        }
        return transposedMatrix;
    }

    public int trace() {
        int trace = 0;
        for (int i = 0; i < size; i++)
            trace += table[i][i];
        return trace;
    }

}
