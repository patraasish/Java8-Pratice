package ps1.q1;

public class Rectangle {

	private double length=0;
	private double breadth=0;
	
	Rectangle(double d,double breadth){
		this.setLength(d);
		this.setBreadth(breadth);
	}

	public double getBreadth() {
		return breadth;
	}

	public void setBreadth(double breadth2) {
		this.breadth = breadth2;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double d) {
		this.length = d;
	}
	
	
	public void calculateArea(double length,double breadth) {
		System.out.println("Length of rectangle: "+length);
		System.out.println("Breadth of rectangle: "+breadth);
		double area=length*breadth;
		System.out.println("Area of rectangle: "+area);
		System.out.println("-----------------------------------");
		
	}
}
