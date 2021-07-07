package forms;

import colisions.colision;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class blocks {

    private Sprite sprite ;
    private int row , column ;

    public void showInfoBlock(){
        System.out.println("Fila: " + getRow() + " " + "Columna: " + getColumn());
        System.out.println("Posicion en Y: " + getY() + " Posicion en X: " + getX());
    }

    public void blockGoLeft(){
            column--;
            setX();
    }

    public void blockGoRight(){
            column++;
            setX();
    }

    public void blockGoDown(){
            row--;
            setY();
    }

    public boolean blockColisionLeft(){
        if (colision.COLISIONMAP.getColisionBlockLefth(getRow(),getColumn())){return true;}else {return false;}
    }

    public boolean blockColisionRight(){
        if (colision.COLISIONMAP.getColisionBlockRight(getRow(),getColumn())){return true;}else {return false;}
    }

    public boolean blockColisionDown(){
        if (colision.COLISIONMAP.getColisionBlockDown(getRow(),getColumn())){return true;}else {return false;}
    }

    private void setX(){sprite.setX(column*blockSize.BLOCKSIZE); }

    private void setY(){sprite.setY(row*blockSize.BLOCKSIZE); }

    private void setPosition(){
        sprite.setPosition(column*blockSize.BLOCKSIZE , row*blockSize.BLOCKSIZE);
    }

    public void setPosition(int row , int column){
        sprite.setPosition(column*blockSize.BLOCKSIZE , row*blockSize.BLOCKSIZE);
    }

    public void setSprite(Texture texture){
        sprite = new Sprite(texture);
        setPosition();
    }

    public void setSize(int height , int width){
        sprite.setSize(width,height);
    }

    public Sprite getSprite(){return sprite; }

    public int getRow(){ return row;}

    public int getColumn(){return column;}

    public float getX(){return sprite.getX();}

    public float getY(){return sprite.getY();}

    public blocks( int row , int column){

        sprite = new Sprite();
        this.row = row ;
        this.column = column ;
        setPosition();
        setSize(blockSize.BLOCKSIZE ,blockSize.BLOCKSIZE);

    }

}
