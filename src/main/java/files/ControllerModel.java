package files;

public class ControllerModel {
    private Model model;


    public ControllerModel(int height, int length)
    {
        model = new Model(height,length);
    }

    public boolean moveNumber(int x,int y)
    {
        if(x>=0 && y>=0 && x<model.getHeight() && y<model.getLength())
        {
            //index of 0 in the matrix
            int zeroX=model.retrieveX(0);
            int zeroY=model.retrieveY(0);
            int valueOfTheMatrix=model.getMatrix()[x][y];
            if(x==zeroX)
            {
                if(y-1==zeroY || y+1==zeroY) {
                    model.setMatrix(x, y, 0);
                    model.setMatrix(zeroX, zeroY, valueOfTheMatrix);
                    return true;
                }
            }else if(y==zeroY)
            {
                if(x-1==zeroX || x+1==zeroX)
                {
                    model.setMatrix(x,y,0);
                    model.setMatrix(zeroX,zeroY,valueOfTheMatrix);
                    return true;
                }
            }
        }
        return false;
    }

















    public boolean moveNumberAtOnce(int x,int y)
    {
        if(x>=0 && y>=0 && x<model.getHeight() && y<model.getLength())
        {
            //index of 0 in the matrix
            int zeroX=model.retrieveX(0);
            int zeroY=model.retrieveY(0);
            if(x==zeroX)
            {
                return callerToSwapAtOnce(x, y, zeroY,model.getLength(),true);
            }else if(y==zeroY)
            {
                return callerToSwapAtOnce(y, x, zeroX,model.getHeight(),false);
            }
        }
        return false;
    }

    private boolean callerToSwapAtOnce(int fixedIdColOrRow, int numberToSwap, int zero, int maxPos, boolean swappingInsideRows) {
        for(int i=0; i<=maxPos; i++)
        {
            if(i== zero)
            {
                if(zero>numberToSwap)
                    model.swapAtOnceOnTheLeft(numberToSwap, zero, fixedIdColOrRow,swappingInsideRows);
                else
                    model.swapAtOnceOnTheRight(numberToSwap, zero, fixedIdColOrRow,swappingInsideRows);
                return true;
            }
        }
        return false;
    }

    public int[][] getMatrix()
    {
        return model.getMatrix();
    }
    public int getHeight()
    {
        return model.getHeight();
    }
    public int getLength()
    {
        return model.getLength();
    }
    public boolean hasWin(int [][] matrix)
    {
        int c=1;
        int [][] win = new int[model.getHeight()][model.getLength()];
        for(int i=0;i<model.getHeight();i++) {
            for (int j = 0; j < model.getLength(); j++) {
                win[i][j]=c;
                c++;
            }
        }
        win[model.getHeight()-1][model.getLength()-1]=0;

        for(int i=0;i<model.getHeight();i++)
        {
            for(int j=0;j<model.getLength();j++) {
                if (win[i][j] != matrix[i][j])
                    return false;
            }
        }
        return true;
    }
}
