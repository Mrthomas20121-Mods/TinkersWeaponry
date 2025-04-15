package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.TinkersWeaponry;
import mrthomas20121.thermalconstruct.TinkersWeaponryModifierIds;
import mrthomas20121.thermalconstruct.init.TinkersWeaponryItems;
import mrthomas20121.thermalconstruct.util.TinkersWeaponryToolDefinitions;
import mrthomas20121.thermalconstruct.util.TinkersWeaponryToolStats;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ToolActions;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.tinkering.AbstractToolDefinitionDataProvider;
import slimeknights.tconstruct.library.materials.RandomMaterial;
import slimeknights.tconstruct.library.tools.definition.module.ToolModule;
import slimeknights.tconstruct.library.tools.definition.module.build.MultiplyStatsModule;
import slimeknights.tconstruct.library.tools.definition.module.build.SetStatsModule;
import slimeknights.tconstruct.library.tools.definition.module.build.ToolActionsModule;
import slimeknights.tconstruct.library.tools.definition.module.build.ToolTraitsModule;
import slimeknights.tconstruct.library.tools.definition.module.material.DefaultMaterialsModule;
import slimeknights.tconstruct.library.tools.definition.module.material.PartStatsModule;
import slimeknights.tconstruct.library.tools.definition.module.mining.IsEffectiveModule;
import slimeknights.tconstruct.library.tools.definition.module.mining.MiningSpeedModifierModule;
import slimeknights.tconstruct.library.tools.definition.module.weapon.CircleWeaponAttack;
import slimeknights.tconstruct.library.tools.definition.module.weapon.ParticleWeaponAttack;
import slimeknights.tconstruct.library.tools.definition.module.weapon.SweepWeaponAttack;
import slimeknights.tconstruct.library.tools.nbt.MultiplierNBT;
import slimeknights.tconstruct.library.tools.nbt.StatsNBT;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.TinkerModifiers;

import static slimeknights.tconstruct.tools.TinkerToolParts.toolHandle;

public class TinkersWeaponryToolDefinitionDataProvider extends AbstractToolDefinitionDataProvider {

    public TinkersWeaponryToolDefinitionDataProvider(PackOutput packOutput) {
        super(packOutput, TinkersWeaponry.MOD_ID);
    }

    @Override
    protected void addToolDefinitions() {

        ToolModule[] swordHarvest = {
                IsEffectiveModule.tag(TinkerTags.Blocks.MINABLE_WITH_SWORD),
                MiningSpeedModifierModule.blocks(7.5f, Blocks.COBWEB)
        };

        RandomMaterial tier1Material = RandomMaterial.random().tier(1).build();
        RandomMaterial randomMaterial = RandomMaterial.random().build();
        DefaultMaterialsModule defaultTwoParts = DefaultMaterialsModule.builder().material(tier1Material, tier1Material).build();
        DefaultMaterialsModule defaultThreeParts = DefaultMaterialsModule.builder().material(tier1Material, tier1Material, tier1Material).build();
        DefaultMaterialsModule defaultFourParts = DefaultMaterialsModule.builder().material(tier1Material, tier1Material, tier1Material, tier1Material).build();

        define(TinkersWeaponryToolDefinitions.GREATSWORD)
                // parts
                .module(PartStatsModule.parts()
                        .part(TinkersWeaponryItems.GREAT_BLADE.get())
                        .part(toolHandle, 0.5f)
                        .part(toolHandle, 0.5f).build())
                .module(defaultThreeParts)
                // stats
                .module(new SetStatsModule(StatsNBT.builder()
                        .set(ToolStats.ATTACK_DAMAGE, 4f)
                        .set(ToolStats.ATTACK_SPEED, 1.2f).build()))
                .module(new MultiplyStatsModule(MultiplierNBT.builder()
                        .set(ToolStats.MINING_SPEED, 0.5f)
                        .set(ToolStats.DURABILITY, 1.1f).build()))
                .smallToolStartingSlots()
                // traits
                .module(ToolTraitsModule.builder()
                        .trait(TinkerModifiers.silkyShears).build())
                .module(ToolActionsModule.of(ToolActions.SWORD_DIG))
                // behavior
                .module(swordHarvest)
                .module(new CircleWeaponAttack(2));

        define(TinkersWeaponryToolDefinitions.SPEAR)
                // parts
                .module(PartStatsModule.parts()
                        .part(TinkersWeaponryItems.SPEAR_HEAD.get())
                        .part(toolHandle, 0.5f)
                        .part(toolHandle, 0.5f).build())
                .module(defaultThreeParts)
                // stats
                .module(new SetStatsModule(StatsNBT.builder()
                        .set(TinkersWeaponryToolStats.CRIT_CHANCE, 0.3f)
                        .set(ToolStats.ATTACK_DAMAGE, 3f)
                        .set(ToolStats.ATTACK_SPEED, 1.8f).build()))
                .module(new MultiplyStatsModule(MultiplierNBT.builder()
                        .set(ToolStats.MINING_SPEED, 0.5f)
                        .set(ToolStats.DURABILITY, 1.1f).build()))
                .smallToolStartingSlots()
                // traits
                .module(ToolTraitsModule.builder()
                        .trait(TinkersWeaponryModifierIds.LENGTHY).build())
                .module(ToolActionsModule.of(ToolActions.SWORD_DIG))
                // behavior
                .module(swordHarvest)
                .module(new SweepWeaponAttack(1));

        define(TinkersWeaponryToolDefinitions.LANCE)
                // parts
                .module(PartStatsModule.parts()
                        .part(TinkersWeaponryItems.SPEAR_HEAD.get())
                        .part(toolHandle, 0.5f)
                        .part(toolHandle, 0.5f).build())
                .module(defaultThreeParts)
                // stats
                .module(new SetStatsModule(StatsNBT.builder()
                        .set(ToolStats.ATTACK_DAMAGE, 3f)
                        .set(ToolStats.ATTACK_SPEED, 1.8f).build()))
                .module(new MultiplyStatsModule(MultiplierNBT.builder()
                        .set(ToolStats.MINING_SPEED, 0.5f)
                        .set(ToolStats.DURABILITY, 1.1f).build()))
                .smallToolStartingSlots()
                // traits
                .module(ToolTraitsModule.builder()
                        .trait(TinkersWeaponryModifierIds.LENGTHY)
                        .trait(TinkerModifiers.piercing)
                        .trait(TinkerModifiers.silkyShears).build())
                .module(ToolActionsModule.of(ToolActions.SWORD_DIG))
                // behavior
                .module(swordHarvest)
                .module(new ParticleWeaponAttack(ParticleTypes.ELECTRIC_SPARK));
    }

    @Override
    public String getName() {
        return null;
    }
}
