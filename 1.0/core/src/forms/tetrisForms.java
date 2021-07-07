package forms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class tetrisForms extends blocks{
    Texture texture ;

    public void mostrarPosicion(){
        System.out.println("Posiciones");
        System.out.println(getY() + " " + getX());
        System.out.println(getRow() + " " + getColumn());
    }

    public void formGoLeft(){
        if (getColumn()>0 && getColumn()<=9){
            blockGoLeft();
        }
    }

    public void formGoRight(){
        if (getColumn()>=0 && getColumn()<9){
            blockGoRight();
        }
    }

    public void formGoDown(){
        if (getRow()>0){
            blockGoDown();
        }
    }

    public void draw(SpriteBatch batch){
        getSprite().draw(batch);
    }

    public void dispose(){ texture.dispose(); }

    public tetrisForms(String image , int row, int column) {
        super(row, column);
        texture = new Texture(image);
        setSprite(texture);
        setSize(blockSize.BLOCKSIZE*4,blockSize.BLOCKSIZE);

    }
}
