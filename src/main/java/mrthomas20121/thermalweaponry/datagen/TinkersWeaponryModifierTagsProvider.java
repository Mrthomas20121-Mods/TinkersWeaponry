package mrthomas20121.thermalweaponry.datagen;

import mrthomas20121.thermalweaponry.TinkersWeaponry;
import mrthomas20121.thermalweaponry.TinkersWeaponryModifierIds;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierTagProvider;

public class TinkersWeaponryModifierTagsProvider extends AbstractModifierTagProvider {

    public TinkersWeaponryModifierTagsProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, TinkersWeaponry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(TinkerTags.Modifiers.GENERAL_ABILITIES).add(TinkersWeaponryModifierIds.LENGTHY);
    }

    @Override
    public String getName() {
        return "Tinkers Weaponry Modifier tags";
    }
}
