package oop2.multithreading;

import javafx.concurrent.Task;

public class SomeTask extends Task {

	@Override
	protected Object call() throws Exception {
		// TODO Auto-generated method stub
		long x = 0;
		while(x < 100000000)
		{
			
//		timer.textProperty().set(String.valueOf(System.currentTimeMillis()));
		x++;
		}
		return null;
	}

}
