package edu.cmu.cs.cs214.lab02.shapes;

/**
 * Тойрог дүрс
 * Битүүмжлэл: radius нь private, зөвхөн interface-ын метод ашиглана
 */
public class Circle implements Shape {
    // ✅ PRIVATE - мэдээлэл нууцлах
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public String getDescription() {
        return "Circle (radius=" + radius + ")";
    }
    
    // Зөвхөн шаардлагатай бол getter өгнө
    public double getRadius() {
        return radius;
    }
}