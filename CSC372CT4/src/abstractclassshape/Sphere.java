package abstractclassshape;

public class Sphere extends Shape {
	private double radius;
	
	public Sphere(double radius) {
		this.radius = radius; 
	}
	
	 public double getRadius() {
		 return radius;
	 }
	 
	 public double surface_area() {
		 return 4 * Math.PI * radius * radius;
	 }
	 
	 public double volume() {
		 return(4.0 / 3.0) * Math.PI * radius * radius * radius;
	 }
	 
	 public String toString() {
		 return String.format("Sphere [Radius = %.2f]%n" + "Surface Area = %.2f%n" + "Volume = %.2f", radius, surface_area(), volume());
	 }
}

