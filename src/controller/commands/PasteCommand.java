package controller.commands;

import java.util.ArrayList;
import java.util.List;

import model.shapeManipulation.CreateShape;
import model.shapeManipulation.ListManager;
import model.shapeManipulation.MasterList;

public class PasteCommand implements ICommand, IUndoable {
	
	static List<CreateShape> clipBoard;
	static MasterList master;
	static CreateShape shapeToPaste;
	
	private static ArrayList<CreateShape> pastedShapes = new ArrayList<CreateShape>();	
	
	@Override
	public void run() {
		for (CreateShape shape : ListManager.getClipBoard().grabList()) {
			shapeToPaste = shape;
			pastedShapes.add(shape);
			ListManager.getMaster().addShape(shapeToPaste);			
			CommandHistory.add(this);		
		}
		ListManager.getClipBoard().grabList().clear();		
	}

	@Override
	public void undo() {
		for(CreateShape shapeToPaste : pastedShapes) {
		ListManager.getMaster().removeShape(shapeToPaste);
		}
	}

	@Override
	public void redo() {
		for (CreateShape shapeToPaste : pastedShapes) {
		ListManager.getMaster().addShape(shapeToPaste);
		}
	}	
}
