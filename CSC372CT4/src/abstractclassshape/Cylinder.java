package abstractclassshape;

public class Cylinder extends Shape {
	
	private double radius;

	public Cylinder(double radius) {
	}
	
	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.radius = height;
	}
	
	public double getRadius() {
		return getRadius();
	}
	
	public double getHeight() {
		return getHeight();
	}
	
	public double surface_area() {
		return 2 * Math.PI * radius * (radius + radius);
	}
	
	public double volume() {
		return Math.PI * getRadius() * getRadius() * getHeight();
	}
	
	@Override
	public String toString() {
		return String.format("Cylinder [Radius - %.2f, Height = %.2f]%n" + "Surface Area = %.2f%n" + "Volume = %.2f", getRadius(), getHeight(), surface_area(), volume()); 
	}
}
