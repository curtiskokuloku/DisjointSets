/**
 * @author Curtis Kokuloku
 * @description Implementation of Disjoint Sets forests data structure
 */

import java.util.*;
import java.io.*;

public class DisjointSets {
    public int [] rank, parent;
    public int n;

    /**
     * @constructor initializes attributes of the disjoint set
     * @param size: number of elements in the set
     */
    public DisjointSets(int size) {
        this.n = size;
        this.rank = new int[n];
        this.parent = new int[n];
        makeSet();
    }

    /**
     * @method makeSet() creates n sets with single item in each
     */
    public void makeSet() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * @method findSet() finds the representative set of x
     * @param x: value we are looking for within the set
     * @return the representation of x's set
     */
    public int findSet(int x) {
        if (parent[x] != x) {
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }

    /**
     * @method union() unites the set that includes x and the set that includes y
     * @param x: a value from one set
     * @param y: a value from another set
     */
    public void union(int x, int y) {
        int xRoot = findSet(x), yRoot = findSet(y);
        if (xRoot == yRoot) {
            return;
        }
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[yRoot] < rank[xRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }
}