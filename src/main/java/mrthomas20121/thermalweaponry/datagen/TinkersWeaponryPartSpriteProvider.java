package mrthomas20121.thermalweaponry.datagen;

import mrthomas20121.thermalweaponry.TinkersWeaponry;
import slimeknights.tconstruct.library.client.data.material.AbstractPartSpriteProvider;

public class TinkersWeaponryPartSpriteProvider extends AbstractPartSpriteProvider {

    public TinkersWeaponryPartSpriteProvider() {
        super(TinkersWeaponry.MOD_ID);
    }

    @Override
    public String getName() {
        return "Tinkers Weaponry Part Sprite Provider";
    }

    @Override
    protected void addAllSpites() {
        addHead("great_blade");
        addHead("spear_head");

        buildTool("greatsword").withLarge().addHead("head").addHandle("handle").addHandle("guard");
        buildTool("lance").withLarge().addHead("head").addHandle("handle").addHandle("guard");
        buildTool("pike").withLarge().addHead("head").addHandle("handle").addHandle("guard");
    }
}
