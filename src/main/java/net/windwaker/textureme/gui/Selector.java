package net.windwaker.textureme.gui;

import net.windwaker.textureme.TextureMe;
import net.windwaker.textureme.gui.container.ConfigMenu;
import net.windwaker.textureme.gui.widget.CloseButton;
import net.windwaker.textureme.gui.widget.ConfigureButton;
import net.windwaker.textureme.gui.widget.SelectButton;
import net.windwaker.textureme.gui.widget.TexturePackList;

import org.bukkit.entity.Player;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericGradient;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericListWidget;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;

public class Selector extends GenericPopup {
	
	public Selector(TextureMe plugin, Player player) {
		// Label
		GenericLabel label = new GenericLabel(plugin.getConfig().getPromptTitle());
		//label.setX(175).setY(25);
		label.setAnchor(WidgetAnchor.CENTER_CENTER);
		label.setPriority(RenderPriority.Lowest);
		label.shiftXPos(-70).shiftYPos(-122);		
		label.setPriority(RenderPriority.Lowest);
		label.setWidth(-1).setHeight(-1);
		
		// Border
		GenericTexture border = new GenericTexture("http://www.almuramc.com/images/blue.png");
		border.setAnchor(WidgetAnchor.CENTER_CENTER);
		border.setPriority(RenderPriority.High);
		border.setWidth(300).setHeight(200);
		border.shiftXPos(-170).shiftYPos(-128);					
		
		// Texture list
		GenericListWidget list = new TexturePackList(plugin);
		list.setAnchor(WidgetAnchor.CENTER_CENTER);
		list.shiftXPos(-145).shiftYPos(-106);
		list.setWidth(255).setHeight(145);
		list.setPriority(RenderPriority.Lowest);
		
		// Close button
		CloseButton close = new CloseButton();
		close.setAuto(true);
		close.setAnchor(WidgetAnchor.CENTER_CENTER);
		close.shiftXPos(80).shiftYPos(46);
		close.setHeight(18).setWidth(40);
		
		// Configure button
		ConfigureButton configure = new ConfigureButton(plugin, list, new ConfigMenu(plugin));
		configure.setAuto(true);
		configure.setAnchor(WidgetAnchor.CENTER_CENTER);
		configure.shiftXPos(-150).shiftYPos(46);
		configure.setHeight(18).setWidth(60);
				
		// Select button
		SelectButton select = new SelectButton(plugin, list);
		select.setAuto(true);
		select.setAnchor(WidgetAnchor.CENTER_CENTER);
		select.shiftXPos(30).shiftYPos(46);
		select.setHeight(18).setWidth(40);
		
		this.setTransparent(true);
		this.attachWidgets(plugin, border, select, close, label, list);
		
		// Attach configure button
		if (player.hasPermission("textureme.configure") || player.isOp()) { this.attachWidget(plugin, configure); }
	}
}