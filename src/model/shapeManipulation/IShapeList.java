package model.shapeManipulation;

import java.util.List;

public interface IShapeList {

	public void addShape(CreateShape shape);
	
	public void removeShape(CreateShape shape);
	
	public List<CreateShape> grabList();
}
