package controller.commands;

import model.shapeManipulation.CreateShape;
import model.shapeManipulation.ListManager;
import model.shapeManipulation.MasterList;

import view.gui.CustomPair;

public class SelectShape implements ICommand {
	
	CustomPair boundStart;
	CustomPair boundEnd;
	static SelectShape boundingBox;	
	
	public SelectShape(CustomPair boundStart, CustomPair boundEnd) {
		this.boundStart = boundStart;
		this.boundEnd = boundEnd;
	}
	
	public static void selectCommand(CustomPair boundStart, CustomPair boundEnd) {
		
		ListManager.getSelected().grabList().clear();
		
		 boundingBox = new SelectShape(boundStart, boundEnd);
		
		for (CreateShape shape : ((MasterList) ListManager.getMaster()).grabList()) {
				if (boundingBox.boundStart.X < shape.startingPair.X && boundingBox.boundEnd.X > shape.endingPair.X
						&& boundingBox.boundStart.Y < shape.startingPair.Y && boundingBox.boundEnd.Y > shape.endingPair.Y) {
					ListManager.getSelected().addShape(shape);					
				}				
			}
		}	

	@Override
	public void run(){
		
		
		selectCommand(boundStart, boundEnd);
	}
	
	
	
	public static SelectShape getBoundingBox() {
		
		return boundingBox;
	}	
}