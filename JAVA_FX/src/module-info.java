module OOP2_JAVA_FX_2 {
	requires javafx.base;
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.graphics;
	
	exports oop2.taschenrechner;
	exports oop2.schachtel;
	exports oop2.taschenrechner_muster;
	opens oop2.schachtel;
	opens oop2.taschenrechner;
	opens oop2.taschenrechner_muster;

}