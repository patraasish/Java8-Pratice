package ps1.q1;

public class TestRectangle {

	public static void main(String[] args) {
	
		Rectangle rectangle1=new Rectangle(3.5, 7);
		Rectangle rectangle2=new Rectangle(5, 7.1);
		Rectangle rectangle3=new Rectangle(12, 5.6);
		Rectangle rectangle4=new Rectangle(9, 6);
		Rectangle rectangle5=new Rectangle(7, 9);
		
		rectangle1.calculateArea(rectangle1.getLength(),rectangle1.getBreadth());
		rectangle2.calculateArea(rectangle2.getLength(),rectangle2.getBreadth());
		rectangle3.calculateArea(rectangle3.getLength(),rectangle3.getBreadth());
		rectangle4.calculateArea(rectangle4.getLength(),rectangle4.getBreadth());
		rectangle5.calculateArea(rectangle5.getLength(),rectangle5.getBreadth());

	}

}
