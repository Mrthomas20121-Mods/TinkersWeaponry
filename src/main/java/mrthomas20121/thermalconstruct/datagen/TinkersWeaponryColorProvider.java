package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.TinkersWeaponry;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class TinkersWeaponryColorProvider extends MantleColorGenerator {

    public TinkersWeaponryColorProvider(PackOutput packOutput) {
        super(packOutput, TinkersWeaponry.MOD_ID);
    }

    @Override
    void addColors() {
    }

    private void addMaterialAndModifiers(MaterialId mat, String color, ModifierId... modifiers) {
        addMaterial(mat, color);

        for (ModifierId id : modifiers) {
            addModifier(id, color);
        }
    }
}
