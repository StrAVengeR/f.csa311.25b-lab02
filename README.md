# Lab 02: Битүүмжлэл ба Мэдээлэл Нууцлал

Энэхүү лаборатори нь Java хэл дээрх Encapsulation (Битүүмжлэл) болон Information Hiding (Мэдээлэл нууцлал) зарчмуудыг практикаар хэрэгжүүлэх зорилготой.

## Хичээлийн зорилго

1. Битүүмжлэлийн асуудлуудыг тодорхойлох
2. Interface-ийн зөв дизайныг ойлгох  
3. Loose coupling (сул хамаарал) үүсгэх
4. Polymorphism ашиглах

---

## Асуудал: Одоогийн код

### Битүүмжлэлийн алдаа

```java
// PUBLIC fields - хэн ч өөрчилж болно
public class Rectangle implements Shape {
    public double height;  
    public double width;   
}
```

**Асуудал:** Гаднаас дүрсний дотоод өгөгдөл рүү шууд хандаж өөрчилж болно. Жишээ нь `rectangle.width = -10` гэж сөрөг утга оруулж болно.

### Interface-ийн асуудал

```java
// Хоосон interface - ямар зан чанар тодорхойлоогүй
public interface Shape {
    // хоосон
}
```

**Асуудал:** Interface нь ямар ч ерөнхий метод өгөхгүй байгаа тул ашиглах боломжгүй.

### Tight Coupling

```java
// Renderer нь зөвхөн Rectangle-тай ажиллана
public class Renderer {
    private Rectangle rectangle;
    
    public Renderer(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
```

**Асуудал:** Circle, Triangle зурахыг хүсвэл Renderer-г дахин бичих шаардлагатай. Код уян хатан биш.

---

## Шийдэл: Сайжруулсан код

### 1. Битүүмжлэл - Private Fields

```java
public class Rectangle implements Shape {
    private final double height;  
    private final double width;   
    
    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }
    
    public double getHeight() { 
        return height; 
    }
    
    public double getWidth() { 
        return width; 
    }
}
```

**Давуу тал:** Дотоод өгөгдөл хамгаалагдсан, зөвхөн getter методоор унших боломжтой.

### 2. Interface дизайн

```java
public interface Shape {
    double getArea();           
    String getDescription();    
}
```

**Давуу тал:** Бүх дүрс эдгээр методуудыг хэрэгжүүлэх үүрэгтэй болсон.

### 3. Loose Coupling - Interface ашиглах

```java
public class Renderer {
    private final Shape shape;
    
    public Renderer(Shape shape) {
        this.shape = shape;
    }
    
    public void draw() {
        System.out.println("Drawing: " + shape.getDescription());
        System.out.println("Area: " + shape.getArea());
    }
}
```

**Давуу тал:** Renderer нь ямар ч дүрстэй (Rectangle, Circle, Square) ажиллах боломжтой болсон.

### 4. Polymorphism - Main.java

```java
public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(2, 3);
        Shape circle = new Circle(5);
        Shape square = new Square(4);
        
        Renderer renderer1 = new Renderer(rectangle);
        renderer1.draw();
        
        Renderer renderer2 = new Renderer(circle);
        renderer2.draw();
        
        Renderer renderer3 = new Renderer(square);
        renderer3.draw();
    }
}
```

**Давуу тал:** Ижил код олон төрлийн дүрстэй ажиллаж байна.

---

## Сайжруулалтын үр дүн

| Хэмжүүр | Өмнө | Одоо |
|---------|------|------|
| Битүүмжлэл | public fields | private final fields |
| Interface | Хоосон | getArea(), getDescription() |
| Хамаарал | Rectangle класс | Shape interface |
| Уян хатан байдал | Зөвхөн Rectangle | Бүх дүрс |
| Өргөтгөх | Renderer өөрчлөх | Шинэ класс нэмэхэд л болно |

---

## Хэрхэн ажиллуулах

### Maven:
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="edu.cmu.cs.cs214.lab02.Main"
```

### Gradle:
```bash
./gradlew clean build
./gradlew run
```

### Manual:
```bash
javac -d bin src/main/java/edu/cmu/cs/cs214/lab02/**/*.java
java -cp bin edu.cmu.cs.cs214.lab02.Main
```

---

## Хүлээгдэж буй үр дүн

```
=== Битүүмжлэл ба Мэдээлэл Нууцлалын Лаборатори ===

1. Rectangle зурах:
Drawing: Rectangle (height=2.0, width=3.0)
Area: 6.0

2. Circle зурах:
Drawing: Circle (radius=5.0)
Area: 78.53981633974483

3. Square зурах:
Drawing: Square (side=4.0)
Area: 16.0

=== Битүүмжлэлийн давуу тал ===
✓ Renderer нь зөвхөн Shape interface-тай ажиллана
✓ Дүрсүүдийн дотоод өгөгдөл (radius, width, height) нуугдсан
✓ Шинэ дүрс нэмэхэд Renderer өөрчлөгдөхгүй
```

---

## Файлын бүтэц

```
src/main/java/edu/cmu/cs/cs214/lab02/
├── Main.java                    
├── Renderer.java                
└── shapes/
    ├── Shape.java              
    ├── Rectangle.java          
    ├── Circle.java             
    └── Square.java             
```

---

## Сурсан OOP зарчмууд

### 1. Encapsulation (Битүүмжлэл)

Дотоод өгөгдлийг нуух, зөвхөн public методоор хандах.

```java
private final double radius;
public double getRadius() { 
    return radius; 
}
```

### 2. Information Hiding (Мэдээлэл нууцлал)

Хэрэгжүүлэлтийн дэлгэрэнгүй нуух, зөвхөн interface өгөх. Renderer нь radius, width, height мэдэхгүй, зөвхөн getArea(), getDescription() ашиглана.

### 3. Polymorphism

Олон төрлийг ижил байдлаар зохицуулах.

```java
Shape shape = new Rectangle(2, 3);
shape = new Circle(5);
shape = new Square(4);
```

### 4. Dependency Inversion Principle

Тодорхой класс биш, abstract-аас хамаарах.

```java
Renderer → Shape (interface)
Renderer → Rectangle (class) биш
```

---

## Шинэ дүрс нэмэх жишээ

Triangle нэмэх нь хялбар - Renderer өөрчлөгдөхгүй.

```java
package edu.cmu.cs.cs214.lab02.shapes;

public class Triangle implements Shape {
    private final double base;
    private final double height;
    
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
    
    @Override
    public String getDescription() {
        return "Triangle (base=" + base + ", height=" + height + ")";
    }
}
```

Main.java-д нэмэх:

```java
Shape triangle = new Triangle(3, 4);
Renderer renderer = new Renderer(triangle);
renderer.draw();
```

Renderer өөрчлөгдөөгүй байна.

---

## Дүгнэлт

Энэхүү лаборатори нь объект хандалтат программчлалын үндэс суурийг харуулж байна. Битүүмжлэл, мэдээлэл нууцлал, polymorphism, SOLID зарчим зэрэг нь том төслүүдэд засварлахад хялбар, өргөтгөхөд амар, алдаа багатай код бичихэд чухал үүрэг гүйцэтгэнэ.

### Гол сайжруулалтууд:

- Бүх field-үүд private final болсон
- Shape interface-д getArea(), getDescription() нэмсэн
- Renderer нь Shape interface ашиглах болсон
- Main.java-д polymorphism ашигласан
- Шинэ дүрс нэмэхэд Renderer өөрчлөгдөхгүй

---

## Ашигласан материал

- Effective Java by Joshua Bloch - Item 15: Minimize the accessibility of classes and members
- Design Patterns by Gang of Four - Encapsulation patterns
- Clean Code by Robert C. Martin - Chapter 6: Objects and Data Structures