package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		essai();

	}
	public test() {
		
	}
	public static void essai() throws ParseException {
		Login.recupDateOccupationByNumChambre(0);
		for(String d : Login.lesDatesDebutOccupation) {
			System.out.println(d);
		}
	}

}
