package abstractclassshape;

public class Cone extends Shape {
	private double radius;
	private double height;

public Cone(double radius, double height) {
	this.radius = radius;
	this.height = height; 
}

public double getRadius() {
	return radius; 
}

public double getHeight() {
	return height;
}

public double slantHeight() {
	return Math.sqrt(radius * radius + height * height);
}

@Override 
public double surface_area() {
	double slantHeight = slantHeight();
	return Math.PI * radius *(radius + slantHeight);
}

public double volume() {
	return(1.0 / 3.0) * Math.PI * radius * radius * height;
}

@Override
public String toString() {
	return String.format("Cone [Radius = %.2f, Height = %.2f, Slant Height = %.2f]%n" + "Surface Area = %.2fn" + "Volume = %.2f", radius, height, slantHeight(), surface_area(), volume());
	}
}
