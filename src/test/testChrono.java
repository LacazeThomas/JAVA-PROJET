package test;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import Model.Chronologie;
import Model.Date;
import Model.Evenement;
import Model.ExceptionChronologie;

/**
 * Classe de test JUnit qui test les chronologies, dates, evenements
 * 
 * @author Thomas, Noe
 *
 */
public class testChrono {

	@Test
	public void testChronologie() throws ExceptionChronologie {

		// Test 1 : Ajout d'un evt la meme année avec le meme poids

		Chronologie testch = new Chronologie();
		Evenement testevt = new Evenement(new Date(),"Nom","texte","img1.png",1);
		testch.ajout(testevt);
		Evenement testevt2 = new Evenement(new Date(20,12,2018),"Nom","texte","img1.png",1);
		//testch.ajout(testevt2);
		//assertTrue(2==2);

		
		// Test 2 : Date on le meme jour a travers un evt

		testevt = new Evenement(new Date(),"Nom","texte","img1.png",1);
		testevt2 = new Evenement(new Date(),"Nom","texte","img1.png",2);
		assertTrue(testevt.getDate().compareTo(testevt2.getDate()) == 0);
		
		
		// Test 3 : Ajout de deux evt et teste longueur hashmap
		testch = new Chronologie();
		testevt = new Evenement(new Date(),"Nom","texte","img1.png",1);
		testch.ajout(testevt);
		testevt2 = new Evenement(new Date(20,12,2015),"Nom","texte","img1.png",1);
		testch.ajout(testevt2);
		assertTrue(testch.getNb() ==2 );
		
		
		// Test 4 : Test du compareto avec deux evt

		testevt = new Evenement(new Date(),"Nom","texte","img1.png",1);
		testevt2 = new Evenement(new Date(),"Nom","texte","img1.png",2);
		assertTrue(testevt.compareTo(testevt2) == 0);
		
		// Test 5
		testevt = new Evenement(new Date(),"Nom","texte","img1.png",1);
		testevt2 = new Evenement(new Date(20,12,2015),"Nom","texte","img1.png",1);
		assertTrue(testevt.compareTo(testevt2) == 1);
		
		
		// Test 6
		testevt = new Evenement(new Date(20,12,2015),"Nom","texte","img1.png",1);	
		testevt2 = new Evenement(new Date(),"Nom","texte","img1.png",1);
		assertTrue(testevt.compareTo(testevt2) == -1);
	}
	
	
	


}