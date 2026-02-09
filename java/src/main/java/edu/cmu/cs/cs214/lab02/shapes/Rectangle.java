package edu.cmu.cs.cs214.lab02.shapes;

/**
 * Тэгш өнцөгт дүрс
 * Битүүмжлэл: бүх field private, зөвхөн interface-ын метод ашиглана
 */
public class Rectangle implements Shape {
    // ✅ PRIVATE - мэдээлэл нууцлах
    private final double height;
    private final double width;
    
    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getArea() {
        return height * width;
    }
    
    @Override
    public String getDescription() {
        return "Rectangle (height=" + height + ", width=" + width + ")";
    }
    
    // Зөвхөн шаардлагатай бол getter өгнө
    public double getHeight() {
        return height;
    }
    
    public double getWidth() {
        return width;
    }
}