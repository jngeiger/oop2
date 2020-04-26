package person;

public class TestStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		var x2 = new Student2() {{ $("Chris", "Test"); }}; 
		x2.getFullName(); /* Chris Test */
		//x2.getInitials(); /* Compilerfehler (unbekannte Methode) */
		
		var x3 = new Student3() {{ $("Chris", "Test"); }}; 
		//x3.getFullName(); /* Compilerfehler (unbekannte Methode) */ 
		x3.getInitials(); /* C. T. */
		
	}

}
