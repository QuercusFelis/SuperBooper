package com.musicalpastries.superboopers.Actors.Items;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.musicalpastries.superboopers.Actors.SuperBooperActor;


/**
 * woodcat - 10/14/2018.
 */
public abstract class ListItem extends SuperBooperActor {
    //master sprite atlas
    public static TextureAtlas atlas;
    private static boolean atlasSet = false;

    private int quantity;
    private String description;
    private String name;
    private String interactText;
    private String type;
    private Image icon;

    public ListItem(int quantity, String name, String description, String interactText, String type) {
        this.quantity = quantity;
        this.description = description;
        this.name = name;
        this.interactText = interactText;
        this.type = type;
    }

    public void incrementQuantity(){
        quantity++;
    }

    public void decrimentQuantity(){
        quantity--;
    }

    public static void setAtlas() {
        //setAtlas(items.txt, "AndroidStudioProjects/SuperBooper/android/assets/items.txt");
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public int getQuantity() {
        return quantity;
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
