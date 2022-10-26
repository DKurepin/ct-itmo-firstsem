import java.util.*;

public class prog8M {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int[] mass = new int[start];

        for (int i = 0; i < start; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int res = 0;
            map.clear();

            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }

            for (int d = n - 2; d > 0; d--) {
                if (map.containsKey(arr[d + 1])) {
                    int num = map.get(arr[d + 1]);
                    num++;
                    map.replace(arr[d + 1], num);
                } else {
                    map.put(arr[d + 1], 1);
                }

                for (int t = 0; t < d; t++) {
                    int fin = 2 * arr[d] - arr[t];
                    if (map.containsKey(fin)) {
                        res += map.get(fin);
                    }
                }
            }
            mass[i] = res;
        }
        for (int i = 0; i < start; i++) {
            System.out.println(mass[i]);
        }
        sc.close();
    }
}