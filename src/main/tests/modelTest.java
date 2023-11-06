import files.Model;
import files.Printer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class modelTest {
    Model testModel;
    Printer print;

    @Test
    public void test()
    {

        //to run this test you have to disable the randomization
        testModel=new Model(4,4);
        int [][] m=testModel.getMatrix();
        print=new Printer();
        print.printMatrix(m);


        assertEquals(3,testModel.retrieveX(0));
        assertEquals(3,testModel.retrieveY(0));
    }

    @Test
    public void testPrinter()
    {
        testModel=new Model(4,4);
        int [][] m=testModel.getMatrix();
        print=new Printer();
        print.printMatrix(m);
    }
    @Test
    public void swap() {
        testModel=new Model(4,4);
        testModel.swap(3,3,2,3);
        System.out.println("");
    }
}
