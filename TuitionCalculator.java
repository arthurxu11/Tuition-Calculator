import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.math.*;

// Arthur Xu
// March 5th, 2020
// Student Debt calculator of sorts. Learned to link websites so that's cool.

public class TuitionCalculator {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the tuition calculator!");
		System.out.println("By inputting some information, we can calculate how much you need to save for university!");
		System.out.println("What is your name?");
		String name = sc.nextLine();
		System.out.println("Nice name!");
		
		// Getting total tuition costs
		System.out.println("What university are you planning on going to?");
		System.out.println("Enter 'T' for UofT, 'W' for uWaterloo, 'B' for Brock, or 'O' for other: ");
		String uni = sc.nextLine();
		Double tuitionCost = universityLinker(uni);
		tuitionCost*= 4;
		// Finding how much money the user will have accumulated
		System.out.println("How much money will your parents have saved by the time school starts?: ");
		double pSavings = sc.nextDouble();
		System.out.println("How much money will you have saved by the time school starts?: ");
		double sSavings = sc.nextDouble();
		System.out.println("How much financial aid and grants do you expect to receive over your time at university? Do not include scholarships or awards.: ");
		double aid = sc.nextDouble();
		System.out.println("Over your time at university, how much do you expect to receive from scholarships or awards?: ");
		double awards = sc.nextDouble();
		System.out.println("How much do you expect to save from Work-study programs, co-ops, or jobs during university?: ");
		double coopMoney = sc.nextDouble();
		
		double finalAmount = tuitionCost-(pSavings+sSavings+aid+awards+coopMoney);
		finalAmount = Math.round(finalAmount*100.00)/100.00;
		if (finalAmount > 0) {
			System.out.println("You will graduate with $"+finalAmount+" of student debts. Womp womp!");
		} else if (finalAmount < 0) {
			System.out.println("You will graduate with $"+(0-finalAmount)+" in your savings. Congrats!");
		} else {
			System.out.println("You will graduate with $0 of student debts. Nice going!");
		}
		
		
		
		
	}

	private static Double universityLinker(String uni) {
		
		Scanner sc = new Scanner(System.in);
		// Sending user to university's tuition calculator
		if (uni.equals("T")) {
			System.out.println("Sending you to the UofT tuition calculator... Fill it in and then come back and enter your responce!");
			try {
				Thread.sleep(7500);
				try {
					Desktop.getDesktop().browse(new URL("https://planningcalc.utoronto.ca/financialPlanner/#/").toURI());
				} catch (Exception e) {}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("What is your estimated yearly costs?: ");
			double tuition = sc.nextInt();
			return tuition;
		} else if (uni.equals("W")) {
			System.out.println("Sending you to the uWaterloo tuition calculator... Fill it in and then come back and enter your responce!");
			try {
				Thread.sleep(7500);
				try {
					Desktop.getDesktop().browse(new URL("https://uwaterloo.ca/future-students/financing/budget-calculator").toURI());
				} catch (Exception e) {}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("What is your estimated yearly costs?: ");
			double tuition = sc.nextInt();
			return tuition;
		} else if (uni.equals("B")) {
			System.out.println("Sending you to the BrockU tuition calculator... Fill it in and then come back and enter your responce!");
			try {
				Thread.sleep(7500);
				try {
					Desktop.getDesktop().browse(new URL("https://brocku.ca/safa/undergraduate-fees-estimator/").toURI());
				} catch (Exception e) {}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("What is your estimated yearly costs?: ");
			double tuition = sc.nextInt();
			return tuition;
		} else {
			System.out.println("Find your school's tuition calculator, and find your estimated cost for a year.");
			System.out.println("What is your estimated yearly costs?: ");
			double tuition = sc.nextInt();
			return tuition;
		}
	}

}
