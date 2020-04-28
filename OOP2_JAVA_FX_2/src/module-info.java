module OOP2_JAVA_FX_2 {
	requires javafx.base;
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.graphics;
	
	exports oop2.application;
	exports oop2.stopwatch;
	exports oop2.helloworld;
	opens oop2.application;
	opens oop2.stopwatch;
	opens oop2.helloworld;
}