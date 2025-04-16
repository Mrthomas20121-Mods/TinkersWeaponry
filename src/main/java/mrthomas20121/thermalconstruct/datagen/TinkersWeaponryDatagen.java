package mrthomas20121.thermalconstruct.datagen;

import com.google.common.collect.Multimap;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.client.data.material.GeneratorPartTextureJsonGenerator;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.tools.data.sprite.TinkerMaterialSpriteProvider;

import java.util.concurrent.CompletableFuture;

public class TinkersWeaponryDatagen {

    public static void init(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        TinkerMaterialSpriteProvider materialSprites = new TinkerMaterialSpriteProvider();

        boolean server = event.includeServer();
        TinkersWeaponryBlockTagsProvider blockTagsProvider = new TinkersWeaponryBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(server, blockTagsProvider);
        generator.addProvider(server, new TinkersWeaponryItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(server, new TinkersWeaponryRecipeProvider(packOutput));
        generator.addProvider(server, new TinkersWeaponryModifierProvider(packOutput));
        generator.addProvider(server, new WeaponryStationSlotLayoutProvider(packOutput));
        generator.addProvider(server, new TinkersWeaponryToolDefinitionDataProvider(packOutput));

        TinkersWeaponryPartSpriteProvider partSprites = new TinkersWeaponryPartSpriteProvider();

        boolean client = event.includeClient();
        generator.addProvider(client, new TinkersWeaponryItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(client, new WeaponryToolItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(client, new GeneratorPartTextureJsonGenerator(packOutput, TConstruct.MOD_ID, partSprites));
        generator.addProvider(client, new MaterialPartTextureGenerator(packOutput, existingFileHelper, partSprites, materialSprites));
        generator.addProvider(client, new TinkersWeaponryColorProvider(packOutput));
        generator.addProvider(client, new TinkersWeaponryLangProvider(packOutput));
    }
}
