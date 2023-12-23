package ps2.q1;


class Flute implements Instrument {

	@Override
	public void play() {
		System.out.println("Flute is playing toot toot toot toot");
	}
	
}


class Guitar implements Instrument{

	@Override
	public void play() {
		System.out.println("Guitar is playing tin tin tin");
	}
	
}

class Piano implements Instrument{

	@Override
	public void play() {
		System.out.println("Piano is playing tan tan tan tan");		
	}
	
}

public class InstrumentImpl {

	public static void main(String args[]) {

		// Array of Instruments
		Instrument[] instruments = new Instrument[10];
				
		// Using lambda expressions to create implementations
		Instrument piano = () -> System.out.println("Piano is playing tan tan tan tan");
		Instrument flute = () -> System.out.println("Flute is playing toot toot toot toot");
		Instrument guitar = () -> System.out.println("Guitar is playing tin tin tin");

		instruments[0] =piano;
		instruments[1] =flute;
		instruments[2] =guitar;
		instruments[3] =new Piano();
		instruments[4] =new Flute();
		instruments[5] =new Guitar();
	
		
		// Polymorphic behavior of play method
		for (int i=0;i<6;i++) {
			instruments[i].play();
			}

		// Using instanceof operator
		for (int i = 0; i < instruments.length; i++) {
			if (instruments[i] instanceof Piano) {
				System.out.println("Piano is stored at index " + i);
			} else if (instruments[i] instanceof Flute) {
				System.out.println("Flute is stored at index " + i);
			} else if (instruments[i] instanceof Guitar) {
				System.out.println("Guitar is stored at index " + i);
			}
		}

	}
}
