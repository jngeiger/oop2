package oop2.statistik;

import java.util.List;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Statistics {
private SimpleStringProperty varianz = new SimpleStringProperty();
private SimpleStringProperty standardabw = new SimpleStringProperty();
	
	public SimpleStringProperty getVarianz(List<Integer> rawData)
	{
		Integer n = rawData.size();
		Double sum = 0.0;
		Double sumsquared = 0.0; 
			
		for (Integer x : rawData)
		{
			sum += x.doubleValue();
			sumsquared += x.doubleValue()*x.doubleValue();
		}
		varianz.set(String.valueOf((sumsquared - ((sum*sum)/n))/n));
		return varianz;
		
	}
	
	public SimpleStringProperty getStandardabweichung(List<Integer> rawData)
	{
	    standardabw.set(String.valueOf((Math.sqrt(Double.valueOf(getVarianz(rawData).get())))));
	    return standardabw;
	}
}
