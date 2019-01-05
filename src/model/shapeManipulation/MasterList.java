package model.shapeManipulation;


import java.util.ArrayList;
import java.util.List;

public class MasterList implements IShapeSubject, IShapeList {
	
	private List<IShapeObserver> observers = new ArrayList<IShapeObserver>();
	
	public List<CreateShape> shapeList;

	public MasterList(List<CreateShape> shapeList) {
		this.shapeList = shapeList; 
	}
			
	@Override
	public void addShape(CreateShape shape) {
		shapeList.add(shape); 		
		notifyObservers();	
	}
	
	@Override
	public void removeShape(CreateShape shape) {
		shapeList.remove(shape);
		notifyObservers();	
	}
	
	@Override
	public void registerObserver(IShapeObserver observer) {
		observers.add(observer);	
	}


	@Override
	public void notifyObservers() {
		for(IShapeObserver observer: observers) {
			observer.update();			
		}
	}
	
	@Override
	public List<CreateShape> grabList() {
		return shapeList;
	}
}
