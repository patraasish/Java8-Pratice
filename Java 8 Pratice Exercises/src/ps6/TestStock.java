package ps6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestStock {

	public static void main(String[] args) {
		
			Scanner sc=new Scanner(System.in);
					
			List<Stock> stocks = new ArrayList<>();
			
			// Add stocks to the list
			for(int i=0;i<2;i++) {
				String symbol;
				double price;
				double units;
				System.out.println("Enter symbol: ");
				symbol=sc.next();
				System.out.println("Enter price: ");
				price=sc.nextDouble();
				System.out.println("Enter units: ");
				units=sc.nextDouble();
				
				stocks.add(new Stock(symbol,price,units));
			}

	        // Print all stocks details using forEach and Method Reference
	        stocks.forEach(System.out::println);

	        // Print stocks with symbol 'AMZ'
	        System.out.println("Symbol is equals to AMZ:");
	        List<Stock> amzStocks = StockFilters.filter(stocks, stock -> stock.getSymbol().equals("AMZ"));
	        amzStocks.forEach(System.out::println);

	        // Print stocks with price above 300
	        System.out.println("Price is above 300:");
	        List<Stock> highPriceStocks = StockFilters.filter(stocks, stock -> stock.getPrice() > 300);
	        highPriceStocks.forEach(System.out::println);

	}

}
