package main;

import java.util.ArrayList;
import model.shapeManipulation.IShapeList;
import java.util.List;
import controller.IJPaintController;
import controller.JPaintController;
import controller.commands.ShapeCommand;
import model.persistence.ApplicationState;
import model.shapeManipulation.CreateShape;
import model.shapeManipulation.DrawShape;
import model.shapeManipulation.IShapeObserver;
import model.shapeManipulation.IShapeSubject;
import model.shapeManipulation.ListManager;
import model.shapeManipulation.MasterList;
import model.shapeManipulation.SelectedList;
import view.gui.ClickHandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
    	
    	PaintCanvas canvas = new PaintCanvas();
    	
        IGuiWindow guiWindow = new GuiWindow(canvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();
        
        canvas.addMouseListener(new ClickHandler());
        ClickHandler.stateGrabber(appState);
        ShapeCommand.grabEndpoint(appState);
        
        final List<CreateShape> master = new ArrayList<CreateShape>();
        IShapeSubject masterList = new MasterList(master);        
        IShapeObserver observer = new DrawShape(canvas);
        masterList.registerObserver(observer);
        
        final List<CreateShape> selected = new ArrayList<CreateShape>();
        IShapeList selectedList = new SelectedList(selected);
              
        final List<CreateShape> clipBoard = new ArrayList<CreateShape>();
        IShapeList clipBoardList = new SelectedList(clipBoard);
        
        ListManager listManager = new ListManager(masterList, selectedList, clipBoardList);
        ListManager.getManager(listManager);        
    }
}
