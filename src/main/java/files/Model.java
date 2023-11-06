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
        int random;
        int times=0;
        while(times<1000)
        {
            int x=retrieveX(0);
            int y=retrieveY(0);
            random=new Random().nextInt(4);

            if(x==0)            //up
            {    while(random==0 || (random==1 && y==length-1) || (random==3 && y==0))
                    {random=new Random().nextInt(4);}   }
            if(y==length-1)     //right
            {    while(random==1 || (random==2 && x==height-1) || (random==0 && x==0))
                    {random=new Random().nextInt(4);}   }
            if(x==height-1)     //down
            {    while(random==2 || (random==3 && y==0)|| (random==1 && y==length-1))
                    {random=new Random().nextInt(4);}   }
            if(y==0)            //left
            {    while(random==3 || (random==0 && x==0)|| (random==2 && x==height-1))
                    {random=new Random().nextInt(4);}   }

            switch (random) {
                case 0:
                    swap(x, y, x - 1, y);
                    break;
                case 1:
                    swap(x, y, x, y + 1);
                    break;
                case 2:
                    swap(x, y, x + 1, y);
                    break;
                case 3:
                    swap(x, y, x, y-1);
                    break;
            }
            times++;
        }
    }

    public void swap(int x1,int y1,int x2,int y2)
    {
        int temp = matrix[x1][y1];
        setMatrix(x1,y1,matrix[x2][y2]);
        setMatrix(x2,y2,temp);
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
