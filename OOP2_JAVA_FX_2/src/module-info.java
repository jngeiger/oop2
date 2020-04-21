module OOP2_JAVA_FX_2 {
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	exports application;
	opens application to javafx.fxml;
}