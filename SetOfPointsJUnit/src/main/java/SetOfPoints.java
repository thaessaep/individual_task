import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Класс, который хранит множество точек и их расстояние от прямой <b>map</b>.
 * @author Студент
 * @version 1.0
 */
public class SetOfPoints {
    private HashMap<Point2D.Double, Double> map;

    /**
     * Конструктор - создание нового объекта
     */
    public SetOfPoints(){
        map = new HashMap<>();
    }

    /**
     * Функция получения значения map {@link SetOfPoints#map}
     * @return возвращает #map
     */
    public HashMap<Point2D.Double, Double> getMap(){
        return map;
    }

    /**
     * @return возвращает расстояние от точки до прямой
     */
    private double searchRemotes(Point2D.Double p, double a, double b, double c){
        double intersectionX = -(p.y * b/a) - (c/a);
        double intersectionY = -(p.x * a/b) - (c/b);
        double segmentLenX, segmentLenY;
        if(intersectionX > p.x) segmentLenX = Math.abs(intersectionX - p.x);
        else segmentLenX = Math.abs(p.x - intersectionX);
        if(intersectionY > p.y) segmentLenY = Math.abs(intersectionY - p.y);
        else segmentLenY = Math.abs(p.y - intersectionY);
        double resultDistance = Math.sqrt(Math.pow(segmentLenX, 2) + Math.pow(segmentLenY, 2)) / 2;
        return resultDistance;
    }

    /**
     * Функция добавления точек в существующую карту
     * @param points список точек
     * @param a коэффициент a прямой
     * @param b коэффициент b прямой
     * @param c коэффициент c прямой
     */
    public void addPoints(ArrayList<Point2D.Double> points, double a, double b, double c){
        for (Point2D.Double point: points) {
            this.map.put(point, searchRemotes(point, a, b, c));
        }
    }

    /**
     * Функция возвращает минимальное расстояние от точки до прямой
     * @return возвращает минимальное расстояние от точки до прямой
     */
    public double getMinRemote(){
        return Collections.min(map.values());
    }

    /**
     * Функция возвращает максимальное расстояние от точки до прямой
     * @return возвращает максимальное расстояние от точки до прямой
     */
    public double getMaxRemote(){
        return Collections.max(map.values());
    }

}
