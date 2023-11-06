package files;

import java.util.Random;

public class Model {
    private int height;
    private int length;
    private int [][] matrix;

    //private files.Phase mPhase;


    public Model(int height, int length)
    {
        //mPhase=files.Phase.START;
        this.height = height;
        this.length = length;
        matrix = new int[height] [length];
        int c=1;
        for(int i = 0;i<this.height;i++) {
            for (int j = 0; j < this.length; j++) {
                matrix[i][j] = c;
                c++;
            }
        }
        matrix[height-1][length-1] = 0;

        randomize();
    }

    private void randomize()
    {
        Random r ;
        int times=0;
        while(times<1000)
        {
            for(int i = 0; i < this.height-1; i++)
            {
                for(int j = 0; j < this.length-1; j++)
                {
                    r=new Random();
                    if(r.nextInt()%2==0) {    //swap(matrix[i][j+1],matrix[i][j]);
                        int temp = matrix[i][j + 1];
                        matrix[i][j + 1] = matrix[i][j];
                        matrix[i][j] = temp;
                    }
                    else {
                        //swap(matrix[i+1][j],matrix[i][j]);
                        int temp = matrix[i+1][j];
                        matrix[i+1][j] = matrix[i][j];
                        matrix[i][j] = temp;
                    }
                }
            }times++;
            if(new Random().nextInt()%2==0)
            {
                int temp = matrix[height-1][length-1];
                matrix[height-1][length-1] = matrix[0][0];
                matrix[0][0] = temp;
            }
        }
    }

    public int getLength() {
        return length;
    }
    public int getHeight() {
        return height;
    }
    public int[][] getMatrix() {
        return matrix;
    }
    public void setMatrix(int i, int j, int value) {
        matrix[i][j] = value;
    }

    public int retrieveX(int value)
    {
        for(int i = 0; i < height; i++)
            for(int j=0;j<length;j++)
            {
                if(matrix[i][j]==value)
                {
                    return i;
                }
            }

        return -1;
    }
    public int retrieveY(int value)
    {
        for(int i = 0; i < height; i++)
            for(int j=0;j<length;j++)
            {
                if(matrix[i][j]==value)
                {
                    return j;
                }
            }

        return -1;
    }
}
