package mrthomas20121.thermalconstruct;

import slimeknights.tconstruct.library.modifiers.ModifierId;

public class TinkersWeaponryModifierIds {

    public static ModifierId LENGTHY = create("lengthy");

    public static ModifierId create(String name) {
        return new ModifierId(TinkersWeaponry.MOD_ID, name);
    }
}
