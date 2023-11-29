package files;

import java.util.Scanner;

public class MainCLI {
    private ControllerModel controllerModel;
    Scanner scanner;
    Printer printer ;

    public MainCLI() {
        scanner = new Scanner(System.in).useDelimiter("\\n");
        printer=new Printer();
    }

    public void mainThreadCLI()
    {
        setup();
        while(!controllerModel.hasWin(controllerModel.getMatrix()))
        {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");


            printer.printMatrix(controllerModel.getMatrix());

            System.out.println("Insert a movement: specify the index of the cell to move");
            System.out.println("Row: ");
            String in = scanner.nextLine();
            //checks on the input
            Integer row=Integer.parseInt(in);

            System.out.println("Column: ");
            in = scanner.nextLine();
            //checks on the input
            Integer column=Integer.parseInt(in);

            boolean isOk= controllerModel.moveNumberAtOnce(row-1,column-1);
            if(!isOk)
                System.out.println("Is not a valid movement");
        }
    }

    private void setup()
    {
        System.out.println("OK, use standard dimensions? [Yes,No]");
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        String in = scanner.nextLine();

        if(in.equals("yes") || in.equals("YES") || in.equals("Yes"))
        {
            controllerModel = new ControllerModel(4,4);
        }
        else {
            System.out.println("Ok, so specify the dimensions ");
            in = scanner.nextLine();
            Integer rows = Integer.parseInt(in);

            controllerModel = new ControllerModel(rows ,rows);
        }
    }

}
