package com.ralitski.util.render.gui;

public class GuiManager {
	
	private GuiOwner owner;
	private Gui currentScreen;
	
	public GuiManager(GuiOwner owner) {
		this.owner = owner;
	}
	
	public GuiOwner getGuiOwner() {
		return owner;
	}

	public Gui getCurrentScreen() {
		return currentScreen;
	}

	public void closeScreen() {
		currentScreen.onClose(true);
		if(currentScreen.getParent() != null) {
			currentScreen = currentScreen.getParent();
			currentScreen.onOpen(true);
		} else {
			owner.onTopLevelGuiClose();
		}
	}
	
	public void openScreen(Gui screen) {
		if(currentScreen != null) {
			currentScreen.onClose(screen.isChildOf(currentScreen));
		}
		screen.onOpen(false);
	}
	
	public int getWindowWidth() {
		return owner.getWidth();
	}
	
	public int getWindowHeight() {
		return owner.getHeight();
	}
	
	public Box getWindow() {
		return new Box(0, 0, getWindowWidth(), getWindowHeight());
	}
	
	public void render() {
		if(currentScreen != null) currentScreen.render();
	}
}