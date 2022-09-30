import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SetOfPoints set = new SetOfPoints();
        ArrayList<Point2D.Double> points = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        double a, b, c;

        System.out.print("Введите число точек, которые будут составлять множество: ");
        int size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            points.add(new Point2D.Double(r.nextDouble()*200 - 100, r.nextDouble()*200 - 100));
        }

        System.out.print("Введите коэффициенты a, b и c, которые будут определять прямую: ");
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();

        set.addPoints(points, a, b, c);


        for (Map.Entry entry : set.getMap().entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        System.out.println(set.getMinRemote());
        System.out.println(set.getMaxRemote());

    }

}