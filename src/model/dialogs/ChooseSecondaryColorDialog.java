package model.dialogs;

import java.awt.Color;
import java.util.ArrayList;

import model.ColorAdapter;
import model.ShapeColor;
import model.interfaces.IApplicationState;
import view.interfaces.IDialogChoice;

public class ChooseSecondaryColorDialog implements IDialogChoice<ColorAdapter> {

    private final IApplicationState applicationState;
    private final ArrayList<ColorAdapter> colors;

    public ChooseSecondaryColorDialog(IApplicationState applicationState) {
        this.applicationState = applicationState;
        colors = new ArrayList<ColorAdapter>();
        colors.add(new ColorAdapter(Color.BLACK, ShapeColor.BLACK));
        colors.add(new ColorAdapter(Color.BLUE, ShapeColor.BLUE));
        colors.add(new ColorAdapter(Color.CYAN, ShapeColor.CYAN));
        colors.add(new ColorAdapter(Color.DARK_GRAY, ShapeColor.DARK_GRAY));
        colors.add(new ColorAdapter(Color.GRAY, ShapeColor.GRAY));
        colors.add(new ColorAdapter(Color.GREEN, ShapeColor.GREEN));
        colors.add(new ColorAdapter(Color.LIGHT_GRAY, ShapeColor.LIGHT_GRAY));
        colors.add(new ColorAdapter(Color.MAGENTA, ShapeColor.MAGENTA));
        colors.add(new ColorAdapter(Color.ORANGE, ShapeColor.ORANGE));
        colors.add(new ColorAdapter(Color.PINK, ShapeColor.PINK));
        colors.add(new ColorAdapter(Color.RED, ShapeColor.RED));
        colors.add(new ColorAdapter(Color.WHITE, ShapeColor.WHITE));
        colors.add(new ColorAdapter(Color.YELLOW, ShapeColor.YELLOW));
    }

    @Override
    public String getDialogTitle() {
        return "Secondary Color";
    }

    @Override
    public String getDialogText() {
        return "Select a secondary color from the menu below:";
    }

    @Override
    public ColorAdapter[] getDialogOptions() {
    	return colors.toArray(new ColorAdapter[0]);
    }

    @Override
    public ColorAdapter getCurrentSelection() {
        return applicationState.getActiveSecondaryColor();
    }
}
