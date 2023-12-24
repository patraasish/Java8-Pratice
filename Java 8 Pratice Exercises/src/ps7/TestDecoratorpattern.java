package ps7;

public class TestDecoratorpattern {

	public static void main(String[] args) {
		
		 Burger baseBurger = new Burger("");

	        // Adding veggies
	       BurgerShop veggiesShop = new BurgerShop(burger -> {
	            System.out.println("Adding veggies to the burger");
	            return new Burger(" Veggie");
	        });
	        Burger veggieBurger = veggiesShop.use(baseBurger);

	        // Adding cheese
	        BurgerShop cheeseShop = new BurgerShop(burger -> {
	            System.out.println("Adding cheese to the burger");
	            return new Burger(" Cheese");
	        });
	        Burger veggieCheeseBurger = cheeseShop.use(veggieBurger);

	        System.out.println("I get Veggie" +veggieCheeseBurger);
	    }

	}


