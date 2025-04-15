package mrthomas20121.thermalconstruct.init;

import mrthomas20121.thermalconstruct.TinkersWeaponry;
import mrthomas20121.thermalconstruct.util.TinkersWeaponryToolDefinitions;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.registration.deferred.ItemDeferredRegister;
import slimeknights.mantle.registration.deferred.SynchronizedDeferredRegister;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.common.registration.ItemDeferredRegisterExtension;
import slimeknights.tconstruct.library.materials.MaterialRegistry;
import slimeknights.tconstruct.library.materials.definition.MaterialVariantId;
import slimeknights.tconstruct.library.tools.helper.ToolBuildHandler;
import slimeknights.tconstruct.library.tools.part.ToolPartItem;
import slimeknights.tconstruct.tools.TinkerToolParts;
import slimeknights.tconstruct.tools.item.ModifiableSwordItem;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

public class TinkersWeaponryItems {

    public static ItemDeferredRegisterExtension ITEMS = new ItemDeferredRegisterExtension(TinkersWeaponry.MOD_ID);
    public static final SynchronizedDeferredRegister<CreativeModeTab> CREATIVE_TABS = SynchronizedDeferredRegister.create(Registries.CREATIVE_MODE_TAB, TinkersWeaponry.MOD_ID);

    public static final ItemObject<ToolPartItem> GREAT_BLADE = ITEMS.register("great_blade", () -> new ToolPartItem(new Item.Properties(), HeadMaterialStats.ID));

    public static final ItemObject<ToolPartItem> SPEAR_HEAD = ITEMS.register("spear_head", () -> new ToolPartItem(new Item.Properties(), HeadMaterialStats.ID));

    public static final CastItemObject GREAT_BLADE_CAST = ITEMS.registerCast("great_blade", new Item.Properties());

    public static final CastItemObject SPEAR_HEAD_CAST = ITEMS.registerCast("spear_head", new Item.Properties());

    public static Item.Properties TOOLS = new Item.Properties().stacksTo(1);

    public static final ItemObject<ModifiableSwordItem> GREATSWORD = ITEMS.register("greatsword", () -> new ModifiableSwordItem(TOOLS, TinkersWeaponryToolDefinitions.GREATSWORD));
    public static final ItemObject<ModifiableSwordItem> SPEAR = ITEMS.register("spear", () -> new ModifiableSwordItem(TOOLS, TinkersWeaponryToolDefinitions.SPEAR));
    public static final ItemObject<ModifiableSwordItem> PIKE = ITEMS.register("pike", () -> new ModifiableSwordItem(TOOLS, TinkersWeaponryToolDefinitions.PIKE));
    public static final ItemObject<ModifiableSwordItem> LANCE = ITEMS.register("lance", () -> new ModifiableSwordItem(TOOLS, TinkersWeaponryToolDefinitions.LANCE));

    public static final RegistryObject<CreativeModeTab> tabToolsPart = CREATIVE_TABS.register(
            "smeltery", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.tinkers_weaponry.tool_parts"))
                    .icon(() -> {
                        MaterialVariantId material;
                        if (MaterialRegistry.isFullyLoaded()) {
                            material = ToolBuildHandler.RANDOM.getMaterial(HeadMaterialStats.ID, RandomSource.create());
                        } else {
                            material = ToolBuildHandler.getRenderMaterial(0);
                        }
                        return GREAT_BLADE.get().withMaterialForDisplay(material);
                    })
                    .displayItems(TinkersWeaponryItems::addToolPartTabItems)
                    .withTabsBefore(TinkerToolParts.tabToolParts.getId())
                    .build());

    public static final RegistryObject<CreativeModeTab> tabTools = CREATIVE_TABS.register(
            "smeltery", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.tinkers_weaponry.tools"))
                    .icon(() -> SPEAR.get().getRenderTool())
                    .displayItems(TinkersWeaponryItems::addToolTabItems)
                    .withTabsBefore(TinkerToolParts.tabToolParts.getId())
                    .build());

    private static void addToolTabItems(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {

        output.accept(GREATSWORD.get());
        output.accept(SPEAR.get());
        output.accept(LANCE.get());
    }

    private static void addToolPartTabItems(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {
        output.accept(GREAT_BLADE.get());
        output.accept(SPEAR_HEAD.get());
    }
}
