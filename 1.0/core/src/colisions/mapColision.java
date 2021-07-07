package colisions;

public class mapColision {

    private boolean[][] COLISIONARRAY;
    private int ROW;
    private int COLUMN;
    //CONTROL COLISION RIGHT, ROW-(row+2) give the same block in ArrayColisions // Columne alone give the lefht number in ArrayColision
    public boolean getColisionBlockLefth(int row , int column){
        return COLISIONARRAY[ROW-(row+2)][column];
    }
    //CONTROL COLISION RIGHT, ROW-(row+2) give the same block in ArrayColisions // Columne +2 give the right block in ArrayColision
    public boolean getColisionBlockRight(int row , int column){
        return COLISIONARRAY[ROW-(row+2)][column+2];
    }
    //CONTROL COLISION DOWN, ROW-(row + 1 ) = +1 give the block down in ArrayColision
    public boolean getColisionBlockDown(int row, int column){
        return COLISIONARRAY[ROW-(row+1)][column+1] ;
    }

    public void setColision( int row , int column){
        COLISIONARRAY[ROW - (row+2)][column+1] = true;
    }

    public void showColisionArray(){
        System.out.println("----------------------------------------------------------");
        for (int y = 0; y < getRow(); y++) {
            for (int x = 0; x < getColumn(); x++) {
                System.out.printf(" " + COLISIONARRAY[y][x]);
            }
            System.out.println();
        }
    }

    public void setColisionArray(){

        for (int y = 0; y < getRow(); y++) {
            for (int x = 0; x < getColumn(); x++) {
                if (x==0 || x==getColumn()-1 || y == 0 || y == getRow()-1){
                    COLISIONARRAY[y][x] = true ;
                }else {
                    COLISIONARRAY[y][x] = false ;
                }
            }
        }
    }

    public void setRow( int row){ROW = row; }

    public void setColumn( int column ){COLUMN = column; }

    public void setRowColummn( int row , int column ){ROW = row ; COLUMN = column ; }

    public int getColumn(){ return COLUMN; }

    public int getRow(){ return ROW;}

    public mapColision( int row , int column){
        this.ROW = row+2;
        this.COLUMN = column+2 ;
        COLISIONARRAY = new boolean[ROW+2][COLUMN+2];
        setColisionArray();
    }

}
