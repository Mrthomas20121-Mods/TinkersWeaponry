package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.TinkersWeaponry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.TagBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.client.data.material.GeneratorPartTextureJsonGenerator;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.tools.data.sprite.TinkerMaterialSpriteProvider;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = TinkersWeaponry.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TinkersWeaponryDatagen {

    @SubscribeEvent
    public static void init(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        TinkerMaterialSpriteProvider materialSprites = new TinkerMaterialSpriteProvider();

        boolean server = event.includeServer();
        TinkersWeaponryBlockTagsProvider blockTags = new TinkersWeaponryBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(server, blockTags);
        generator.addProvider(server, new TinkersWeaponryModifierTagsProvider(packOutput, existingFileHelper));
        generator.addProvider(server, new TinkersWeaponryItemTagsProvider(packOutput, lookupProvider, blockTags.contentsGetter(), existingFileHelper));
        generator.addProvider(server, new TinkersWeaponryRecipeProvider(packOutput));
        generator.addProvider(server, new TinkersWeaponryModifierProvider(packOutput));
        generator.addProvider(server, new TinkersWeaponryToolDefinitionDataProvider(packOutput));
        generator.addProvider(server, new WeaponryStationSlotLayoutProvider(packOutput));

        TinkersWeaponryPartSpriteProvider partSprites = new TinkersWeaponryPartSpriteProvider();

        boolean client = event.includeClient();
        generator.addProvider(client, new TinkersWeaponryItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(client, new WeaponryToolItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(client, new GeneratorPartTextureJsonGenerator(packOutput, TinkersWeaponry.MOD_ID, partSprites));
        //generator.addProvider(client)
        generator.addProvider(client, new MaterialPartTextureGenerator(packOutput, existingFileHelper, partSprites, materialSprites));
        generator.addProvider(client, new TinkersWeaponryColorProvider(packOutput));
        generator.addProvider(client, new TinkersWeaponryLangProvider(packOutput));
    }
}
