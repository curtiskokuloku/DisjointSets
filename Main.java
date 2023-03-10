public class Main {
    public static void main(String[] args) {
        // Let there be 5 persons with ids as
        // 0, 1, 2, 3 and 4
        int n = 5;
        DisjointSets dus =
                new DisjointSets(n);

        // 0 is a friend of 2
        dus.union(0, 2);

        // 4 is a friend of 2
        dus.union(4, 2);

        // 3 is a friend of 1
        dus.union(3, 1);

        // Check if 4 is a friend of 0
        if (dus.findSet(4) == dus.findSet(0))
            System.out.println("Yes");
        else
            System.out.println("No");

        // Check if 1 is a friend of 0
        if (dus.findSet(1) == dus.findSet(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
