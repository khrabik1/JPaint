package model.shapeManipulation;

public interface IShapeSubject {	
	
	void registerObserver(IShapeObserver observer);
	
	void notifyObservers();
	
	void addShape(CreateShape shape);
	
	void removeShape(CreateShape shape);
	
}
