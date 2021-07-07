package forms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class forms extends blocks{
    private Texture texture ;
    private blocks block1 ;
    private blocks block2 ;
    private blocks block3 ;
    private blocks block4 ;
    private int rowA , columnB , rowC, columnD, rowE, columnF, rowG, columnH, heightI, widthJ;

    public void formGoLeft(){
            blockGoLeft();
            block1.blockGoLeft();
            block2.blockGoLeft();
            block3.blockGoLeft();
            block4.blockGoLeft();

    }

    public void formGoRight(){
            blockGoRight();
            block1.blockGoRight();
            block2.blockGoRight();
            block3.blockGoRight();
            block4.blockGoRight();

    }

    public void formGoDown(){
            blockGoDown();
            block1.blockGoDown();
            block2.blockGoDown();
            block3.blockGoDown();
            block4.blockGoDown();
    }

    public boolean formColisionLeft(){
        if (block1.blockColisionLeft() || block2.blockColisionLeft() || block3.blockColisionLeft() || block4.blockColisionLeft()){return true;}
        else {return false;}
    }

    public boolean formColisionRight(){
        if (block1.blockColisionRight() || block2.blockColisionRight() || block3.blockColisionRight() || block4.blockColisionRight()){return true;}
        else {return false;}
    }

    public boolean formColisionDown(){
        if (block1.blockColisionDown() || block2.blockColisionDown() || block3.blockColisionDown()|| block4.blockColisionDown()){return true;}
        else {return false;}
    }

    public void draw(SpriteBatch batch){
        getSprite().draw(batch);
    }

    public void dispose(){ texture.dispose(); }

    public void setPositionsValues( int numberForm){
        switch (numberForm){
            case 0:
                //CUADRADO
                rowE = 1 ; columnF = 0 ; rowG = 1 ; columnH = 1 ;
                rowA =0  ; columnB = 0 ; rowC = 0 ; columnD = 1 ;
                //SPRITE
                heightI = 2 ; widthJ = 2 ;
                break;
            case 1:
                //I
                rowG = 3 ; columnH = 0 ;
                rowE = 2 ; columnF = 0 ;
                rowC = 1 ; columnD = 0 ;
                rowA = 0 ; columnB = 0 ;
                //SPRITE
                heightI = 4 ; widthJ = 1 ;
                break;
            case 2:
                //L
                rowG = 2 ; columnH = 0 ; rowE = 2 ; columnF = 1 ;
                                         rowC = 1 ; columnD = 1 ;
                /**SPRITE*/              rowA = 0 ; columnB = 1 ;

                heightI = 3 ; widthJ = 2 ;
                break;
            case 3:
                //LINVERTIDA
                rowE = 2 ; columnF = 0 ;rowG = 2 ; columnH = 1 ;
                rowC = 1 ; columnD = 0 ;
                rowA = 0 ; columnB = 0 ;
                //BASE
                heightI = 3 ; widthJ = 2 ;
                break;
            case 4:
                //S
                rowG = 2 ; columnH = 0 ;
                rowE = 1 ; columnF = 0 ;  rowC = 1 ; columnD = 1 ;
                /**BASE*/                 rowA = 0 ; columnB = 1 ;
                heightI = 3 ; widthJ = 2 ;
                break;
            case 5:
                //SINVERTIDA
                                         rowG = 2 ; columnH = 1 ;
                rowE = 1 ; columnF = 0 ; rowC = 1 ; columnD = 1 ;
                rowA = 0 ; columnB = 0 ;
                //BASE
                heightI = 3 ; widthJ = 2 ;
                break;
            case 6:
                //T
                                        rowG = 1 ; columnH = 1 ;
                rowA = 0 ; columnB = 0 ;rowC = 0 ; columnD = 1 ;rowE = 0 ; columnF = 2 ;
                //BASE
                heightI = 2 ; widthJ = 3 ;
                break;
        }
    }

    public int getBlock1Row(){return block1.getRow();}

    public int getBlock1Column(){return block1.getColumn();}

    public int getBlock2Row(){return block2.getRow();}

    public int getBlock2Column(){return block2.getColumn();}

    public int getBlock3Row(){return block3.getRow();}

    public int getBlock3Column(){return block3.getColumn();}

    public int getBlock4Row(){return block4.getRow();}

    public int getBlock4Column(){return block4.getColumn();}

    public forms(String image , int row, int column , int numberForm ) {
        super(row, column);
        texture = new Texture(image);
        setSprite(texture);
        setPositionsValues(numberForm);
        setSize(blockSize.BLOCKSIZE* heightI,blockSize.BLOCKSIZE* widthJ);
        setPosition(row,column);
        block1 = new blocks(getRow()+ rowA,getColumn()+ columnB);
        block2 = new blocks(getRow()+ rowC,getColumn()+ columnD);
        block3 = new blocks(getRow()+ rowE,getColumn()+ columnF);
        block4 = new blocks(getRow()+ rowG,getColumn()+ columnH);

    }

}
