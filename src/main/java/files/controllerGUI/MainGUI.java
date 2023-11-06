package files.controllerGUI;

import files.ControllerModel;

/**
 * This class is useless but I kept only to give a more structured taste to the gui part
 */
public abstract class MainGUI {

    private ControllerModel controller ;



    public ControllerModel getController() {
        return controller;
    }
    public void setController(ControllerModel controller) {
        this.controller = controller;
    }
}
