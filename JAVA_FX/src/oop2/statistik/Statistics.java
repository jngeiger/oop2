package oop2.statistik;



import java.util.Arrays;
import java.util.Optional;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class Statistics {
    private final ObservableList<Integer> rawData;
    private final SimpleStringProperty varianz = new SimpleStringProperty();
    private final SimpleStringProperty standardabw = new SimpleStringProperty();
    private final SimpleStringProperty mittelwert = new SimpleStringProperty();
    private final SimpleStringProperty median = new SimpleStringProperty();
    private final SimpleStringProperty modus = new SimpleStringProperty();
    
    public Statistics(ObservableList<Integer> rawData)
    {
            this.rawData = rawData;
    }
    public SimpleStringProperty getVarianz()
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

    public SimpleStringProperty getStandardabweichung()
    {
        standardabw.set(String.valueOf((Math.sqrt(Double.valueOf(getVarianz().get())))));
        return standardabw;
    }
    public SimpleStringProperty getMittelwert()
    {
        Integer n = rawData.size();
        Double sum = 0.;
        for(Integer x : rawData){
            sum += x.doubleValue();
        }
        mittelwert.set(String.valueOf(sum/n));
        return mittelwert;
    }
    
    public SimpleStringProperty getModus()
    {	
    	try {
    		Optional<Integer> maximal = rawData.stream().max((x,y) -> x.compareTo(y));
    		int[] buckets = new int[maximal.get()+1];
    		
    		for (int i = 0; i < rawData.size(); i++)
    		{
    			buckets[rawData.get(i)] += 1;
    		}
    		
    		int max = 0;
    		String modal = "";
    		for (int i = 0; i < buckets.length; i++)
    		{
    			int cv = buckets[i];
    			if (cv > max)
    			{
    				modal = String.valueOf(i);
    				max = cv;
    			}
    			else if (cv == max)
    			{
    				modal += "," + String.valueOf(i);
    			}
    			
    		}
    		
    		modus.set(modal);
    		return modus;
    	}
    	catch (Exception e)
    	{
    	
    	}
    	
    	return modus;
    	
    
    
    	
    	
    }
   
    
    
    public SimpleStringProperty getMedian()
    {
    	Double result = 0.0/0.0;
    	if (rawData.size() % 2 == 0)
    	{
    		try {
    		result = ((rawData.get(rawData.size()/2-1)).doubleValue() + rawData.get(rawData.size() / 2).doubleValue()) / 2;
    		Math.floor(result);
    		}
    		catch (IndexOutOfBoundsException e)
    		{
    			// when list size is 0
    			
    		}
    		}
    		
    	else {
    		try {
    		result = (rawData.get(rawData.size()/2).doubleValue());
    	
    		}
    		catch (IndexOutOfBoundsException e)
    		{
    			// when list size is 0
    			
    		}
    	}
    	median.set(String.valueOf(result));
		return median;
    }
}