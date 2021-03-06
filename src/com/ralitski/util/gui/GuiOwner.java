package com.ralitski.util.gui;

import com.ralitski.util.gui.render.FontRenderer;
import com.ralitski.util.gui.render.RenderList;
import com.ralitski.util.gui.render.RenderStyle;
import com.ralitski.util.render.img.Color;

public interface GuiOwner {
	int getWidth();
	int getHeight();
	void onTopLevelGuiClose();
	
	//rendering methods
	
	FontRenderer getFontRenderer();
	//quick draw, used by Gui to render a black tint
	void drawBox(Box box, Color c);
	//use the box's RenderStyle to draw its bounds (and bg)
	void drawBox(Box box, RenderStyle style);
	//render lists
	boolean supportLists();
	
	/**
	 * 
	 * @param renderer a runnable to be called when the list must be (re)generated
	 * @return a render list which will execute the code supplied in renderer.run()
	 */
	RenderList newList(Runnable renderer);
}
