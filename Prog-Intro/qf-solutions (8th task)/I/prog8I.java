import java.util.Scanner;

public class prog8I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int minx = 1000000000;
        int miny = 1000000000;
        int maxx = -1000000000;
        int maxy = -1000000000;
        double xr = 0;
        double xl = 0;
        double yr = 0;
        double yl = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int h = sc.nextInt();
            if ((x - h) < minx) {
                minx = (x - h);
            }
            if ((y - h) < miny) {
                miny = (y - h);
            }
            if ((x + h) > maxx) {
                maxx = (x + h);
            }
            if ((y + h) > maxy) {
                maxy = (y + h);
            }
            xr = maxx;
            xl = minx;
            yr = maxy;
            yl = miny;
        }
        int height = (int) (Math.ceil((Math.max(xr - xl, yr - yl)) / 2));
        int finalX = (int) ((xl + xr) / 2);
        int finalY = (int) ((yl + yr) / 2);
        System.out.println(finalX + " " + finalY + " " + height);
        sc.close();
    }
}
