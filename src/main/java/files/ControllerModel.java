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
                if(y-1==zeroY || y+1==zeroY)
                {
                    model.setMatrix(x,y,0);
                    model.setMatrix(zeroX,zeroY,valueOfTheMatrix);
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
        for(int i=0;i<model.getHeight();i++)
        {
            for(int j=0;j<model.getHeight();j++)
            {
                if(i== model.getHeight()-1 && j== model.getHeight()-1)
                    c=0;

                if(c!=matrix[i][j])
                    return false;
                c++;
            }
        }
        return true;
    }
}
