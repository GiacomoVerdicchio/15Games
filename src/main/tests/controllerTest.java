import files.ControllerModel;
import files.Printer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class controllerTest {
    Printer p=new Printer();
    ControllerModel testControllerModel;

    @Test
    public void testBasic()
    {
        testControllerModel = new ControllerModel(4,4);
        assertFalse(testControllerModel.moveNumber(-123,-132));
        assertFalse(testControllerModel.moveNumber(123,131));

        assertTrue(testControllerModel.moveNumber(2,3));
        assertEquals(testControllerModel.getMatrix()[2][3],0);
        assertEquals(testControllerModel.getMatrix()[3][3],12);
    }


    @Test
    public void testLungo() {
        testControllerModel = new ControllerModel(4, 4);
        assertTrue(testControllerModel.moveNumber(3, 2));
        assertEquals(testControllerModel.getMatrix()[3][3],15);
        assertEquals(testControllerModel.getMatrix()[3][2],0);

        assertTrue(testControllerModel.moveNumber(2, 2));
        assertEquals(testControllerModel.getMatrix()[3][2],11);
        assertEquals(testControllerModel.getMatrix()[2][2],0);


        p.printMatrix(testControllerModel.getMatrix());
    }
}
