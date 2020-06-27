package oop2.statistik;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Menu1Controller implements Initializable {
    @FXML GridPane root;
    @FXML TextArea ta;
    ObservableList<Integer> rawData = FXCollections.observableList(new ArrayList<Integer>());
    @FXML Label validData;
    SimpleBooleanProperty isValid = new SimpleBooleanProperty();
    @FXML TextField tfVar;
    @FXML TextField tfStandard;
    @FXML TextField tfModus;
    @FXML TextField tfMedian;
    @FXML TextField tfMittelwert;
    ImageView iV;
    Image hacken;
    Image kreuz;
    Statistics engine = new Statistics(rawData);
    MergeSort<Integer> sorting = new MergeSort<Integer>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        iV = new ImageView();
        hacken = new Image(getClass().getResourceAsStream("hackenPNG.png"),75.,75.,true,true);
        kreuz = new Image(getClass().getResourceAsStream("XPNG.png"),50.,50.,true,true);
        iV.setImage(hacken);
        validData.setGraphic(iV);
        ta.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // TODO Auto-generated method stub
                rawData.clear();
                isValid.set(true);
                int idx = 0;

                for (int i = 0; i < newValue.length(); i++)
                {
                    if (newValue.length()-1 == i)
                    {
                        try {
                            rawData.add(Integer.valueOf(newValue.substring(idx,i+1)));
                        }
                        catch (Exception e)
                        {
                            isValid.set(false);
                        }
                    }
                    if (newValue.charAt(i) == ',')
                    {
                        try {
                            rawData.add(Integer.valueOf(newValue.substring(idx,i)));
                            idx = i+1;
                        }
                        catch (Exception e)
                        {
                            isValid.set(false);
                        }
                    }
                }
                sorting.sort(rawData);
                engine.getVarianz();
                engine.getStandardabweichung();
                engine.getMittelwert();
                engine.getMedian();
                engine.getModus();
                		
                

            }});
        isValid.addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> obs, Boolean old, Boolean newVal)
            {
            	
						
						if (isValid.get() == true)
		                {
		                    iV.setImage(hacken);
		                }
		                else {
		                    iV.setImage(kreuz);
		                }
					
            }
        });
        tfMittelwert.textProperty().bind(engine.getMittelwert());
        tfVar.textProperty().bind(engine.getVarianz());
        tfStandard.textProperty().bind(engine.getStandardabweichung());
        tfMedian.textProperty().bind(engine.getMedian());
        tfModus.textProperty().bind(engine.getModus());
    }
    public void reset(ActionEvent actionEvent)
    {
      ta.setText("");
    }
    
    public void parseSorted(ActionEvent event)
    {
    	String s = "";
    	for (int i = 0; i < rawData.size(); i++)
    	{
    		if (i == rawData.size()-1)
    		{
    			s+= rawData.get(i);
    			break;
    		}
    		s += rawData.get(i) + ",";
    	}
    	ta.setText(s);
    }
    
   
}