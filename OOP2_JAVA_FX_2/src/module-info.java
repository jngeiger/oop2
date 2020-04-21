module OOP2_JAVA_FX_2 {
	requires javafx.base;
	requires javafx.fxml;
	requires javafx.controls;
	exports application;
	opens application to javafx.fxml;
}