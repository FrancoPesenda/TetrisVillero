package com.mygdx.game;

import colisions.colision;
import colisions.mapColision;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import forms.forms;
import forms.blockSize;
import forms.FormsGenerator;
import images.Image;
import screens.screen;
import tetrisScreen.drawBatch;

public class tetris10 extends ApplicationAdapter {
	screen background ;
	SpriteBatch draw ;
	float maxX , maxY ;
	int row , column , timeMove , timeDown;
	FormsGenerator newForm;
	forms actualForm ;
	Array<forms>staticsForms;
	boolean thereIsColision ;

	@Override
	public void create () {
		//CREATE THE WINDOWS
		drawBatch.DRAW = new SpriteBatch();
		draw = drawBatch.DRAW;
		background = new screen(Image.POORBACKGROUND.getNameImages(),maxY,maxX) ;
		newForm = new FormsGenerator();
		actualForm = newForm.getForm();
		staticsForms=new Array<>();
		colision.COLISIONMAP = new mapColision( row , column);
		thereIsColision = false ;
		timeMove = 20 ;
		timeDown = 30 ;
	}

	@Override
	public void render () {
		//RENDER
		drawBatch.cleanWindows();
		draw.begin();
		background.draw();
		for (forms backgroundForm: staticsForms) {
			if (backgroundForm != null){
				backgroundForm.setPosition(backgroundForm.getRow(),backgroundForm.getColumn());
				backgroundForm.draw(draw);
			}
		}
		actualForm.draw(draw);
		draw.end();
		if (timeMove>0){timeMove--;}
		if (timeDown>0){timeDown--;}
		//MOVEMENT
		//IZQUIERDA
		if (Gdx.input.isKeyPressed(Input.Keys.A) && timeMove == 0){
			if (!actualForm.formColisionLeft()){actualForm.formGoLeft();}
			timeMove =20;
		}
		//DERECHA
		if (Gdx.input.isKeyPressed(Input.Keys.D) && timeMove == 0){
			if (!actualForm.formColisionRight()){actualForm.formGoRight();}
			timeMove =20;
		}
		//ABAJO
		if (timeDown == 0){
			if (actualForm.formColisionDown()){thereIsColision = true;
			}else {actualForm.formGoDown();}
			colision.COLISIONMAP.showColisionArray();
			timeDown =30;
		}
		//SPAWN
		if (thereIsColision){
			staticsForms.add(actualForm);
			colision.COLISIONMAP.setColision(actualForm.getBlock1Row(),actualForm.getBlock1Column());
			colision.COLISIONMAP.setColision(actualForm.getBlock2Row(),actualForm.getBlock2Column());
			colision.COLISIONMAP.setColision(actualForm.getBlock3Row(),actualForm.getBlock3Column());
			colision.COLISIONMAP.setColision(actualForm.getBlock4Row(),actualForm.getBlock4Column());
			thereIsColision = false ;
			actualForm = newForm.getForm();
		}

	}
	
	@Override
	public void dispose () {
		draw.dispose();
		background.dispose();
		actualForm.dispose();
	}

	private void setRowColumnSize(){
		float rowTemp = maxY / blockSize.BLOCKSIZE ;
		float columnTemp = maxX / blockSize.BLOCKSIZE ;
		this.row = (int)rowTemp;
		this.column = (int)columnTemp;
	}

	public tetris10( float maxY , float maxX ){
		this.maxY = maxY ;
		this.maxX = maxX ;
		blockSize.BLOCKSIZE = (int)maxY/16;
		setRowColumnSize();
	}


}
