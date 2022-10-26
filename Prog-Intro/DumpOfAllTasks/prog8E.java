import java.util.*;

public class prog8E {
    private static int[] parents;
    private static int[] d;
    private static int[][] childs;

    public static void FindDepths(int team, int parent, int depth) {
        parents[team] = parent;
        d[team] = depth;
        for (int child : childs[team]) {
            if (child != parent) {
                FindDepths(child, team, depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] vi = new int[n - 1];
        int[] ui = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            vi[i] = in.nextInt() - 1;
            ui[i] = in.nextInt() - 1;
        }
        int[] cm = new int[m];
        for (int i = 0; i < m; i++) {
            cm[i] = in.nextInt() - 1;
        }
        int[] numberOfPaths = new int[n];
        for (int i = 0; i < n - 1; i++) {
            numberOfPaths[vi[i]]++;
            numberOfPaths[ui[i]]++;
        }
        childs = new int[n][];
        for (int i = 0; i < n; i++) {
            childs[i] = new int[numberOfPaths[i]];
        }
        for (int i = 0; i < n - 1; i++) {
            numberOfPaths[vi[i]] -= 1;
            numberOfPaths[ui[i]] -= 1;
            childs[vi[i]][numberOfPaths[vi[i]]] = ui[i];
            childs[ui[i]][numberOfPaths[ui[i]]] = vi[i];
        }
        d = new int[n];
        parents = new int[n];
        FindDepths(cm[0], cm[0], 0);
        int depth = 0;
        int maxTeam = 0;
        for (int i = 0; i < m; i++) {
            if (d[cm[i]] > depth) {
                depth = d[cm[i]];
                maxTeam = cm[i];
            }
        }
        if (depth % 2 != 0) {
            System.out.println("NO");
            System.exit(0);
        }
        int middleCity = maxTeam;
        for (int i = 0; i < depth / 2; i++) {
            middleCity = parents[middleCity];
        }
        FindDepths(middleCity, middleCity, 0);
        for (int i = 0; i < m - 1; i++) {
            if (d[cm[i]] != d[cm[i + 1]]) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
        System.out.println(middleCity + 1);
        in.close();
    }
}
