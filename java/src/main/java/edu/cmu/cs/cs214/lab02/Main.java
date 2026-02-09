package edu.cmu.cs.cs214.lab02;

import edu.cmu.cs.cs214.lab02.shapes.Rectangle;
import edu.cmu.cs.cs214.lab02.shapes.Circle;
import edu.cmu.cs.cs214.lab02.shapes.Square;
import edu.cmu.cs.cs214.lab02.shapes.Shape;

/**
 * Лабораторийн програм
 * Битүүмжлэл болон polymorphism-ийг харуулна
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Bituumjlel lab ===\n");
        
        //  Shape төрлөөр зарлах - Polymorphism
        // Тодорхой класс биш, ерөнхий interface ашиглах
        Shape rectangle = new Rectangle(2, 3);
        Shape circle = new Circle(5);
        Shape square = new Square(4);
        
        //  Ижил Renderer өөр өөр дүрстэй ажиллана
        System.out.println("1. Rectangle zurah:");
        Renderer renderer1 = new Renderer(rectangle);
        renderer1.draw();
        
        System.out.println("\n2. Circle zurah:");
        Renderer renderer2 = new Renderer(circle);
        renderer2.draw();
        
        System.out.println("\n3. Square zurah:");
        Renderer renderer3 = new Renderer(square);
        renderer3.draw();
        
        //  Давуу тал: Шинэ дүрс (Triangle, Hexagon) нэмэхэд Renderer өөрчлөгдөхгүй!
        System.out.println("\n=== Bituumjleliin davuu tal ===");
        System.out.println("✓ Renderer ni zuvhun Shape interface-tai ajillana");
        System.out.println("✓ Dursuudiin dotood ugugdul (radius, width, height) nuugdsan");
        System.out.println("✓ Shine durs nemehed Renderer uurchlugduhgui");
    }
}