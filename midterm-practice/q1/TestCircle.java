package q1;
import q1.Circle;

public class TestCircle {
    public static void main(String[] args) {
        Circle c = new Circle();

//        System.out.println(c.getArea());
//        System.out.println(c.getPerimeter());

        System.out.println(c.contains(0.7,0.7));

        System.out.println(c.contains( new Circle(0.5, 0, 0.3)));
        System.out.println(c.overlaps(new Circle(0,2,0.5)));


    }
}
