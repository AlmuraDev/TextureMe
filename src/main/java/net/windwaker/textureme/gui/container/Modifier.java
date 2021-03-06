package net.windwaker.textureme.gui.container;

import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericContainer;
import org.getspout.spoutapi.gui.GenericTextField;

public class Modifier extends GenericContainer {
	
	public Modifier() {
		GenericTextField name = new GenericTextField();
		name.setX(110).setY(70);
		name.setWidth(200).setHeight(20);
		name.setText("Name...");
		
		GenericTextField url = new GenericTextField();
		url.setX(110).setY(95);
		url.setWidth(200).setHeight(20);
		url.setText("Url...");
		
		GenericButton button = new GenericButton("Finish");
		button.setX(110).setY(130);
		button.setWidth(200).setHeight(20);
		
		this.setWidth(0).setHeight(0);
		this.addChildren(name, url, button);
	}
}