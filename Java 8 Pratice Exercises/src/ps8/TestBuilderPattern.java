package ps8;

public class TestBuilderPattern {

	public static void main(String[] args) {
		
		MobileBuilder mobileBuilder = new MobileBuilder();

        // Place a mobile order based on parameters
        Mobile mobile = mobileBuilder
                .with(builder -> builder.ram = 4)
                .with(builder -> builder.storage = 0)
                .with(builder -> builder.battery = 4000)
                .with(builder -> builder.camera = 0)
                .with(builder -> builder.processor = "A12 Bionic")
                .with(builder -> builder.screenSize = 0.0)
                .createMobile();

        // Print specifications
        System.out.println(mobile);

	}

}
