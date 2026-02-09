package edu.cmu.cs.cs214.lab02;

import edu.cmu.cs.cs214.lab02.shapes.Shape;

/**
 * Дүрс зурах класс
 * Битүүмжлэл: Зөвхөн Shape interface-тай ажиллана
 * Rectangle, Circle гэх мэт тодорхой классаас хамаарахгүй
 */
public class Renderer {
    //  Shape interface ашиглах - Rectangle биш!
    // Мэдээлэл нууцлал: тодорхой дүрсний дотоод бүтцийг мэдэхгүй
    private final Shape shape;
    
    /**
     * Renderer үүсгэгч
     * @param shape Ямар ч дүрс (Rectangle, Circle, Square, гэх мэт)
     */
    public Renderer(Shape shape) {
        this.shape = shape;
    }
    
    /**
     * Дүрсийг зурах
     * Зөвхөн Shape interface-ын методыг ашиглана
     */
    public void draw() {
        System.out.println("Drawing: " + shape.getDescription());
        System.out.println("Area: " + shape.getArea());
    }
}
