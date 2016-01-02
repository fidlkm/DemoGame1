package com.superschmalgames;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DemoGame extends ApplicationAdapter {
	SpriteBatch batch;

	//Declare textures to be used in the game.
	Texture img1, img2;

	//Declare sprites to be used in the game.
	Sprite sprite1;

	//Declare fonts to be used in the game.
	BitmapFont font1;
	String titleText;
	GlyphLayout layout1;  //The layout variable is used to format and align font text within the rendered window.

	//The create() method gets called once, just to initialize variables and set everything up.
	@Override
	public void create () {

		//Initialize all declared image/batch/sprite/font/etc variables.
		batch = new SpriteBatch();

		font1 = new BitmapFont(Gdx.files.internal("TitleFont.fnt"));
		titleText = "GatorQuest";

		//GlyphLayouts are useful for padding/aligning fonts on the screen (as mentioned above).
		layout1 = new GlyphLayout();
		layout1.setText(font1, titleText);  //Pass in the font and string you're using so it knows its properties.

		img1 = new Texture("kyloren.jpg");  //Set image variables to be pictures saved in /core/assets/.
		img2 = new Texture("badlogic.jpg");

		sprite1 = new Sprite(img2);  //Set the visuals for the sprite to be whatever is in img2.

		//Sprites have their own fields. You can set their position fields like so:
		sprite1.setPosition(Gdx.graphics.getWidth()/2-sprite1.getWidth()/2,
							Gdx.graphics.getHeight()/2-sprite1.getHeight()/2);
	}

	//The render() method is what's called every time the screen refreshes.
	@Override
	public void render () {

		//Clear the screen.
		Gdx.gl.glClearColor(0, 0, 1, 1);   //Arguments are RGB values and Opacity, all between 0 and 1.
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//Whatever is drawn comes between the "begin" and "end" statements. (Verify this is necessary!)
		batch.begin();

		//Two different methods for drawing something to the screen. One uses just a raw image, the other uses
		//a sprite which already contains its own positional data. *Be sure to only use one or the other for now!*
		batch.draw(img1,
				Gdx.graphics.getWidth()/2-img1.getWidth()/2,
				Gdx.graphics.getHeight()/2-img1.getHeight()/2);

		//batch.draw(sprite1,
		// 			sprite1.getX(),
		// 			sprite1.getY());

		//Draw a font to the screen using bitmap fonts. The layout variable is used to adjust the alignment of the
		//font so that it is centered on the screen from left to right and moved up just above the top border of
		//the img1 variable when they're both rendered together.
		font1.draw(batch,
				titleText,
				Gdx.graphics.getWidth()/2-layout1.width/2,
				Gdx.graphics.getHeight()/2+layout1.height+img1.getHeight()/2);

		batch.end();
	}
}
