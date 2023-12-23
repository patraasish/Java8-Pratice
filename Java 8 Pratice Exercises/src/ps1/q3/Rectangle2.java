package ps1.q3;

import java.util.Scanner;

public class Rectangle2 {

	private double length=1.0;
	private double width=1.0;
	
		
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		if(length>0.0 && length < 20.00) {
			this.length = length;
		}
		else {
			System.out.println("Give length value greater than 0.0 and less than 20.00");
		}
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if(width>0.0 && width< 20.00) {
			this.width = width;
		}
		else {
			System.out.println("Give width value greater than 0.0 and less than 20.00");
		}
	}

	public void calculatePerimeter(double length,double width) {
		double perimeter=(length+width)*2;
		System.out.println("Perimeter of rectangle: "+perimeter);		
	}
	
	public void calculateArea(double length,double width) {
		double area=length*width;
		System.out.println("Area of rectangle: "+area);		
	}
	
	
	public static void main(String args[]) {
		
		Rectangle2 rec=new Rectangle2();
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter length of rectangle");
		rec.setLength(scanner.nextDouble());
		
		System.out.println("Enter width of rectangle");
		rec.setWidth(scanner.nextDouble());
		
		rec.calculatePerimeter(rec.getLength(), rec.getWidth());
		rec.calculateArea(rec.getLength(), rec.getWidth());
	}
	
}
