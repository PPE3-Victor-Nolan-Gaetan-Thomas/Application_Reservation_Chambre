package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		//essai();
		testEstDisponible();
	}
	public test() {
		
	}
	public static void essai() throws ParseException {
		Login.recupDateOccupationByNumChambre(0);
		for(String d : Login.lesDatesDebutOccupation) {
			System.out.println(d);
		}
	}
	
	
	public static void testEstDisponible() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = "2019-03-20";
		String date2 = "2019-03-25";
		try {
			Date d1 = sdf.parse(date1);
			Date d2 = sdf.parse(date2);
			Login.estDisponible(0, d1, d2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
