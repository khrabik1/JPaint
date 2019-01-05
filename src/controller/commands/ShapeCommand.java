package controller.commands;

import java.io.IOException;

import model.ShapeConfiguration;
import model.StartAndEndPointMode;
import view.gui.CustomPair;
import model.persistence.ApplicationState;

public class ShapeCommand {
	private static ApplicationState appState;
	private static ICommand command;
	
	public static void commandRunner(int X, int Y, CustomPair startingPair, 
										CustomPair endingPair, int height, int width, 
										ShapeConfiguration shapeConfig) 
												throws IOException {

		//ICommand command = null;
		StartAndEndPointMode endPoint = appState.getActiveStartAndEndPointMode();
		
		switch(endPoint) {

		case DRAW:
			command = CommandFactory.drawCommand(X, Y, startingPair, endingPair, height, width, shapeConfig);
			break;
		case SELECT:
			command = CommandFactory.selectCommand(startingPair, endingPair);
			break;
		case MOVE:
			command = CommandFactory.moveCommand(startingPair);
			break;
		
		default:
			throw new IOException("No such command"); 
			}

		command.run();
		}
	
	public static void grabEndpoint(ApplicationState state) {
		appState = state;		
	}
}


