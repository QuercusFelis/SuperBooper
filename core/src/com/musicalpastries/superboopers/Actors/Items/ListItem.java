package com.musicalpastries.superboopers.Actors.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.musicalpastries.superboopers.Actors.SuperBooperActor;


/**
 * woodcat - 10/14/2018.
 */
public abstract class ListItem extends SuperBooperActor {
    //master sprite atlas
    public static TextureAtlas atlas;
    private static boolean atlasSet = false;

    private int num;
    private String description;
    private String name;
    private String interactText;
    private String type;
    private Image icon;

    public ListItem(int num, String name, String description, String interactText, String type) {
        super(0, new double[0]);
        this.num = num;
        this.description = description;
        this.name = name;
        this.interactText = interactText;
        this.type = type;

    }

    @Override
    protected void setupGraphics(int id, double[] rgb) {
        try{
            setIcon(new Image(new Texture(Gdx.files.internal("back.png"))));
        } catch (GdxRuntimeException e){
            setIcon(new Image(new Texture(Gdx.files.external("AndroidStudioProjects/SuperBooper/android/assets/back.png"))));
        }
    }

    public void incrementNum(){
        num++;
    }

    public void decrimentNum(){
        num--;
    }

    public static void setAtlas() {
        //setAtlas(items.txt, "AndroidStudioProjects/SuperBooper/android/assets/items.txt");
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public int getNum() {
        return num;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String getName() {
        return name;
    }


    public String getInteractText() {
        return interactText;
    }

    public String getType() {
        return type;
    }

    public Image getIcon() {
        return icon;
    }

    public Image getIconCopy() { return new Image(icon.getDrawable());
    }
}
