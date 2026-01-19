package abstractclassshape;

public class ShapeArray {
	public static void main(String[] args) {
		Sphere sphere = new Sphere(5.0);
		
		Cylinder cylinder = new Cylinder(3.0, 7.0);
		
		Cone cone = new Cone(4.0, 6.0);
		
		Shape[] shapeArray = {sphere, cylinder, cone};
		
		System.out.println("=== Shapes Info ===\n");
		
		for(int i = 0; i < shapeArray.length; i++) {
			System.out.println("Shape " + (i + 1) + ":");
			System.out.println("--------------");
			
			System.out.println(shapeArray[i].toString());
			System.out.println("\n");
		}
	}
}
