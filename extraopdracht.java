package ExtraOpdracht;

import java.util.Random;
import java.util.Scanner;

public class extraopdracht {
	public static void main(String[] args) {
		Speler speler = new Speler();
		speler.multiplay();

	}
}

class Speler {
	Scanner sc = new Scanner(System.in);
	Dobbelsteen dice = new Dobbelsteen();
	Spel spel = new Spel();
	static String speler1;
	static String speler2;

	void multiplay() {
		System.out.println("Speel dobbelen met twee spelers.\nVoer de naam van speler 1 in:");
		speler1 = sc.nextLine();
		System.out.println("Welkom " + speler1 + "\nVoer de naam van speler 2 in:");
		speler2 = sc.nextLine();
		System.out.println("Welkom " + speler1 + " & " + speler2);
		Speler speler = new Speler();
//		speler.beurt();
		dice.gooien();
		spel.spelen();
	}

	void beurt() { //wissel twee spelers
		
		
	}
}

class Dobbelsteen {
	int ogen;
	int worp;

	void gooien() {
		Random rd = new Random();
		ogen = rd.nextInt(6) + 1;

	}

	@Override
	public String toString() {
		return ogen + "";
	}
}

class Spel {
	boolean doorSpelen = true;
	Scanner tekstInvoeren = new Scanner(System.in);
	Dobbelsteen ds = new Dobbelsteen();


	void spelen() {
		while (doorSpelen) {
			System.out.println("Druk op Enter om door te gaan of kies 'q' om te stoppen");
			String invoer = tekstInvoeren.nextLine();
			verwerkenSpelen(invoer);
		}
	}

	void verwerkenSpelen(String deInvoer) {
		switch (deInvoer) {
		case "":
			doorSpelen = true;
			ds.gooien();
			System.out.println(Speler.speler1 + " heeft " + ds.ogen + " gegooid!" );
			ds.gooien();
			System.out.println(Speler.speler2 + " heeft " + ds.ogen + " gegooid!" );
			break;
		case "q":
			doorSpelen = false;
			System.out.println("Einde!");
			break;
		default:
			System.out.println("\nToets een geldige knop aub!");
			break;
		}
	}
}
