package screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import tetrisScreen.drawBatch;
import forms.blockSize;

public class screen {

    private Texture texture ;
    private Sprite sprite ;

    public void setSize( float width , float height){
        sprite.setSize( width , height );
    }

    public void draw(){
        sprite.draw(drawBatch.DRAW);
    }

    public void dispose(){ texture.dispose(); }

    public screen( String image , float height , float width){
        texture = new Texture( image );
        sprite = new Sprite(texture);
        this.setSize( width , height);
    }

    public screen(String image ){
        texture = new Texture( image );
        sprite = new Sprite(texture);
    }

}
