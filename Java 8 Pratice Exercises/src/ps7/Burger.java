package ps7;

public class Burger {
	
	private String burgerType;

	public Burger(String burgerType) {
		this.burgerType = burgerType;
	}

	@Override
	public String toString() {
		return burgerType + " burger";
	}
	
	

	public Burger addVeggies() {
		System.out.println("Adding veggies to the burger");
		return new Burger(this.burgerType += " Veggie");
	}


	public Burger addCheese() {
		System.out.println("Adding cheese to the burger");
		return new Burger(this.burgerType += "Cheese");
	}

}
