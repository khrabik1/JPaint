package model.shapeManipulation;

public class ListManager {
	
	private static IShapeSubject  masterList;
	private static IShapeList selectedList;
	private static IShapeList clipBoard;
	
	static ListManager manager;

	public ListManager(IShapeSubject masterList, IShapeList selectedList, IShapeList clipBoard) {
		ListManager.masterList = masterList;
		ListManager.selectedList = selectedList;
		ListManager.clipBoard = clipBoard;
	}
	
	public static IShapeSubject  getMaster() {
		return masterList;
	}
	
	public static IShapeList getSelected() {
		return selectedList;
	}
	
	public static IShapeList getClipBoard() {
		return clipBoard;
	}
	
	public static void getManager(ListManager thisManager) {
		manager = thisManager;
	}
}
