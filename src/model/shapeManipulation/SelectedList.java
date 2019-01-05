package model.shapeManipulation;

import java.util.List;

public class SelectedList implements IShapeList {
	
	public List<CreateShape> shapeList;

	public SelectedList(List<CreateShape> shapeList) {
		this.shapeList = shapeList; 
	}

	@Override
	public void addShape(CreateShape shape) {
		shapeList.add(shape);		
	}

	@Override
	public void removeShape(CreateShape shape) {
		shapeList.remove(shape);		
	}
	
	@Override
	public List<CreateShape> grabList() {
		return shapeList;
	}
}
