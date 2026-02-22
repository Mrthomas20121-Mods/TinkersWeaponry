package mrthomas20121.thermalweaponry.datagen;

import mrthomas20121.thermalweaponry.TinkersWeaponryModifierIds;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.modifiers.modules.behavior.AttributeModule;
import slimeknights.tconstruct.library.modifiers.modules.build.StatBoostModule;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class TinkersWeaponryModifierProvider extends AbstractModifierProvider {

    public TinkersWeaponryModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addModifiers() {

        buildModifier(TinkersWeaponryModifierIds.LENGTHY)
                .addModule(AttributeModule.builder(ForgeMod.ENTITY_REACH.get(), AttributeModifier.Operation.ADDITION)
                        .unique("tinkersweaponry.sword.entity_reach")
                        .flat(1.5f))
                .addModule(StatBoostModule.add(ToolStats.DURABILITY).flat(0.9f));
    }

    @Override
    public String getName() {
        return "Thermal Modifier Provider";
    }
}
