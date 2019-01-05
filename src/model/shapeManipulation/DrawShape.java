package model.shapeManipulation;

import java.awt.Color;
import java.awt.Graphics2D;

import view.gui.PaintCanvas;

public class DrawShape implements IShapeObserver {
	
	PaintCanvas canvas;
	static Graphics2D graphics2d;
	static DrawShape drawShape;
	static MasterList masterList;		
	
	public DrawShape(PaintCanvas canvas) {
		graphics2d = canvas.getGraphics2D();
	}
	
	public static void drawShapeStrategy(CreateShape shape, DrawShape drawShape) {
		IShapeDrawer shapeStrategy;
				
		switch(shape.shapeType) {
		case ELLIPSE:
			shapeStrategy = new EllipseStrategy();
			break;
		case CIRCLE:
			shapeStrategy = new CircleStrategy();
			break;
		case TRIANGLE:
			shapeStrategy = new TriangleStrategy();
			break;
		case RECTANGLE:
			shapeStrategy = new RectangleStrategy();
			break;
		default:
			throw new IllegalArgumentException("Invalid shape type");	
		}
		
	shapeStrategy.draw(shape, graphics2d);	
	
	}	

	@Override
	public void update() {
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0,0,1200,800);
		
		for (CreateShape shape : ((MasterList) ListManager.getMaster()).grabList() ) {		
			drawShapeStrategy(shape, drawShape);	
		}		
	}	
}
