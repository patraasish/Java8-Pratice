package ps2.q2;

class Tablet implements MedicineInfo {
	@Override
	public void displayLabel() {
		System.out.println("Store in a cool dry place");
	}
}

class Syrup implements MedicineInfo {
	@Override
	public void displayLabel() {
		System.out.println("10 ml only");
	}
}

class Ointment implements MedicineInfo {
	@Override
	public void displayLabel() {
		System.out.println("For external use only");
	}
}

public class TestMedicine {

	public static void main(String args[]) {

		// Create an array of Medicine references of size 10
		MedicineInfo[] medicines = new MedicineInfo[10];

		// Create a medicine object of a type decided by a randomly generated integer
		for (int i = 0; i < 10; i++) {
			int randomType = (int) (Math.random() * 3) + 1;

			switch (randomType) {
			case 1:
				medicines[i] = new Tablet();
				break;
			case 2:
				medicines[i] = new Syrup();
				break;
			case 3:
				medicines[i] = new Ointment();
				break;
			}
		}

	// Check polymorphic behavior of the displayLabel() method
        for (int i = 0; i < medicines.length; i++) {
            medicines[i].displayLabel();
        }
	}
}
