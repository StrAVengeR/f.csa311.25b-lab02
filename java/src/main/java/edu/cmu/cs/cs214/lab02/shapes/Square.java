package edu.cmu.cs.cs214.lab02.shapes;

/**
 * Квадрат дүрс
 * Битүүмжлэл: sideLen нь private, зөвхөн interface-ын метод ашиглана
 */
public class Square implements Shape {
    // ✅ PRIVATE - мэдээлэл нууцлах
    private final double sideLen;

    public Square(double sideLen) {
        this.sideLen = sideLen;
    }
    
    @Override
    public double getArea() {
        return sideLen * sideLen;
    }
    
    @Override
    public String getDescription() {
        return "Square (side=" + sideLen + ")";
    }
    
    // Зөвхөн шаардлагатай бол getter өгнө
    public double getSideLength() {
        return sideLen;
    }
}
