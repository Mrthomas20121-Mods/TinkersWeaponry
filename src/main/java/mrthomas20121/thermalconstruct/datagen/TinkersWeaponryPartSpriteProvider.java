package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.TinkersWeaponry;
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
    }
}
