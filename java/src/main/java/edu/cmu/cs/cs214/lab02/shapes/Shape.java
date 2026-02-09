package edu.cmu.cs.cs214.lab02.shapes;

/**
 * Бүх дүрсний ерөнхий interface
 * Битүүмжлэлийг хангахын тулд дүрсний ерөнхий зан чанарыг тодорхойлно
 */
public interface Shape {
    /**
     * Дүрсний талбайг тооцоолох
     * @return Талбай
     */
    double getArea();
    
    /**
     * Дүрсний мэдээллийг авах
     * @return Дүрсний тайлбар
     */
    String getDescription();
}
