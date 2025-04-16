package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.TinkersWeaponry;
import mrthomas20121.thermalconstruct.TinkersWeaponryModifierIds;
import net.minecraft.data.PackOutput;

public class TinkersWeaponryColorProvider extends MantleColorGenerator {

    public TinkersWeaponryColorProvider(PackOutput packOutput) {
        super(packOutput, TinkersWeaponry.MOD_ID);
    }

    @Override
    void addColors() {

        addModifier(TinkersWeaponryModifierIds.LENGTHY, "#FF9B49");
    }
}
