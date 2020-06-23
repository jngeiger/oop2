module OOP2_JAVA_FX_2 {
	requires transitive javafx.base;
	requires javafx.fxml;
	requires javafx.controls;
	requires transitive javafx.graphics;
	
	
	exports oop2.taschenrechner_borderpane;
	exports oop2.taschenrechner;
	exports oop2.schachtel;
	exports oop2.taschenrechner_programmatisch;
	exports oop2.taschenrechner_grid;
	exports oop2.taschenrechner_properties;
	exports oop2.addressBook;
	exports oop2.addressBook2;
	exports oop2.addressBookUebung;
	exports oop2.shapes;
	exports oop2.addressBookClone;
	exports oop2.drawing;
	exports oop2.multithreading;
	exports oop2.ab_wdh;
	
	opens oop2.addressBookClone;
	opens oop2.taschenrechner_properties;
	opens oop2.schachtel;
	opens oop2.taschenrechner;
	opens oop2.taschenrechner_programmatisch;
	opens oop2.taschenrechner_grid;
	opens oop2.taschenrechner_borderpane;
	opens oop2.addressBook;
	opens oop2.addressBook2;
	opens oop2.addressBookUebung;
	opens oop2.shapes;
	opens oop2.drawing;
	opens oop2.multithreading;
	opens oop2.ab_wdh;
}