package com.UniSim.game.Screens;

import com.UniSim.game.UniSim;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SettingsScreen implements Screen {
    private UniSim game;
    private Stage stage;
    private Skin skin;

    private Texture backgroundTexture;

    public SettingsScreen(UniSim game) {
        this.game = game;
        stage = new Stage(new FitViewport(2560, 1440));  // Use FitViewport here
        skin = new Skin(Gdx.files.internal("uiskin.json")); // Load the skin for UI elements
        Gdx.input.setInputProcessor(stage);

        // Create a table to organize UI elements
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        backgroundTexture = new Texture("LoadScreenBackground.png");

        // Back button
        Button backButton = new Button(skin);
        backButton.add(new Label("Back", skin)); // Add label to the button
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new LandingScreen(game)); // Go back to the landing screen
            }
        });

        // Resolution buttons
        Button res720Button = new Button(skin);
        res720Button.add(new Label("1280x720", skin));
        res720Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.graphics.setWindowedMode(1280, 720); // Change window size to 1280x720
            }
        });

        Button res1080Button = new Button(skin);
        res1080Button.add(new Label("1920x1080", skin));
        res1080Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.graphics.setWindowedMode(1920, 1080); // Change window size to 1920x1080
            }
        });

        Button res1440Button = new Button(skin);
        res1440Button.add(new Label("2560x1440", skin));
        res1440Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.graphics.setWindowedMode(2560, 1440); // Change window size to 2560x1440
            }
        });

        // Music volume slider
        Label musicLabel = new Label("Music Volume", skin);
        Slider musicSlider = new Slider(0, 1, 0.01f, false, skin);
        musicSlider.setValue(0.5f); // Set default value (50%)

        // Sound volume slider
        Label soundLabel = new Label("Sound Volume", skin);
        Slider soundSlider = new Slider(0, 1, 0.01f, false, skin);
        soundSlider.setValue(0.5f); // Set default value (50%)

        // Add elements to the table
        //table.add(backButton).pad(10);
        //table.row();
        //table.add(res720Button).pad(10);
        //table.row();
        //table.add(res1080Button).pad(10);
        //table.row();
        //table.add(res1440Button).pad(10);
        //table.row();
        //table.add(musicLabel).pad(10);
        //table.row();
        //table.add(musicSlider).pad(10);
        //table.row();
        //table.add(soundLabel).pad(10);
        //table.row();
        //table.add(soundSlider).pad(10);

        backButton.setSize(200, 100);
        backButton.setPosition(10, 1320);

        res720Button.setSize(200, 60);
        res720Button.setPosition(200, 1200);

        res1080Button.setSize(200, 60);
        res1080Button.setPosition(500, 1200);

        res1440Button.setSize(200, 60);
        res1440Button.setPosition(800, 1200);

        stage.addActor(backButton);
        stage.addActor(res720Button);
        stage.addActor(res1080Button);
        stage.addActor(res1440Button);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);  // Set a background color for the settings screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        SpriteBatch batch = new SpriteBatch();
        batch.begin();
        batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();

        // Draw the stage (which includes all UI elements)
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose(); // Dispose the skin
    }
}