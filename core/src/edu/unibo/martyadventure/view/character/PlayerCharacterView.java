package edu.unibo.martyadventure.view.character;

import java.util.concurrent.ExecutionException;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import edu.unibo.martyadventure.model.character.PlayerCharacter;
import edu.unibo.martyadventure.model.character.Shoes;
import edu.unibo.martyadventure.view.weapon.WeaponView;
import edu.unibo.martyadventure.view.weapon.WeaponViewFactory;

/**
 * A player character's base providing basic movement, interaction with given
 * the map and visual representation.
 */
public class PlayerCharacterView extends CharacterView {

    private static final int PLAYER_HP = 500;
    public static final int FRAME_WIDTH = 141;
    public static final int FRAME_HEIGHT = 148;
    private static WeaponView playerWeapon = WeaponViewFactory.createPlayerWeaponView();
    private static PlayerCharacter player = new PlayerCharacter(Shoes.SLOW, "", PLAYER_HP, playerWeapon.getWeapon());;

    public PlayerCharacterView(String name, Vector2 initialPosition, TextureRegion textureRegion)
            throws InterruptedException, ExecutionException {
        super(initialPosition, 20f, 10f, 100f, textureRegion, FRAME_WIDTH, FRAME_HEIGHT, playerWeapon);
        player.setName(name);
    }

    public PlayerCharacter getPlayer() {
        return player;
    }

    public void setWeaponView(WeaponView weapon) {
        this.weapon = weapon;
        playerWeapon = weapon;
        PlayerCharacterView.player.setWeapon(weapon.getWeapon());
    }

}
