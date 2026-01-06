package mrthomas20121.thermalconstruct.init;

import mrthomas20121.thermalconstruct.TinkersWeaponry;
import mrthomas20121.thermalconstruct.util.TinkersWeaponryToolDefinitions;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.registration.deferred.ItemDeferredRegister;
import slimeknights.mantle.registration.deferred.SynchronizedDeferredRegister;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.common.registration.ItemDeferredRegisterExtension;
import slimeknights.tconstruct.library.materials.MaterialRegistry;
import slimeknights.tconstruct.library.materials.definition.MaterialVariantId;
import slimeknights.tconstruct.library.tools.helper.ToolBuildHandler;
import slimeknights.tconstruct.library.tools.item.IModifiable;
import slimeknights.tconstruct.library.tools.part.IMaterialItem;
import slimeknights.tconstruct.library.tools.part.ToolPartItem;
import slimeknights.tconstruct.tools.TinkerToolParts;
import slimeknights.tconstruct.tools.TinkerTools;
import slimeknights.tconstruct.tools.item.ModifiableSwordItem;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class TinkersWeaponryItems {

    public static ItemDeferredRegisterExtension ITEMS = new ItemDeferredRegisterExtension(TinkersWeaponry.MOD_ID);
    public static final SynchronizedDeferredRegister<CreativeModeTab> CREATIVE_TABS = SynchronizedDeferredRegister.create(Registries.CREATIVE_MODE_TAB, TinkersWeaponry.MOD_ID);

    public static final ItemObject<ToolPartItem> GREAT_BLADE = ITEMS.register("great_blade", () -> new ToolPartItem(new Item.Properties(), HeadMaterialStats.ID));

    public static final ItemObject<ToolPartItem> SPEAR_HEAD = ITEMS.register("spear_head", () -> new ToolPartItem(new Item.Properties(), HeadMaterialStats.ID));

    public static final CastItemObject GREAT_BLADE_CAST = ITEMS.registerCast("great_blade", new Item.Properties());

    public static final CastItemObject SPEAR_HEAD_CAST = ITEMS.registerCast("spear_head", new Item.Properties());

    public static Item.Properties TOOLS = new Item.Properties().stacksTo(1);

    public static final ItemObject<ModifiableSwordItem> GREATSWORD = ITEMS.register("greatsword", () -> new ModifiableSwordItem(TOOLS, TinkersWeaponryToolDefinitions.GREATSWORD));
    public static final ItemObject<ModifiableSwordItem> PIKE = ITEMS.register("pike", () -> new ModifiableSwordItem(TOOLS, TinkersWeaponryToolDefinitions.PIKE));
    public static final ItemObject<ModifiableSwordItem> LANCE = ITEMS.register("lance", () -> new ModifiableSwordItem(TOOLS, TinkersWeaponryToolDefinitions.LANCE));

    public static final RegistryObject<CreativeModeTab> tabToolsPart = CREATIVE_TABS.register(
            "tinkersweaponry_tool_parts", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.tinkersweaponry.tool_parts"))
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
            "tinkersweaponry_tools", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.tinkersweaponry.tools"))
                    .icon(() -> LANCE.get().getRenderTool())
                    .displayItems(TinkersWeaponryItems::addToolTabItems)
                    .withTabsBefore(TinkerTools.tabTools.getId())
                    .build());

    private static void addToolTabItems(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output tab) {
        Consumer<ItemStack> output = tab::accept;
        acceptTool(output, GREATSWORD);
        acceptTool(output, LANCE);
        acceptTool(output, PIKE);
    }

    private static void acceptTool(Consumer<ItemStack> output, Supplier<? extends IModifiable> tool) {
        ToolBuildHandler.addVariants(output, tool.get(), "");
    }

    private static void addToolPartTabItems(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output tab) {
        accept(tab::accept, GREAT_BLADE);
        accept(tab::accept, SPEAR_HEAD);
        tab.accept(GREAT_BLADE_CAST.get());
        tab.accept(SPEAR_HEAD_CAST.get());
        tab.accept(GREAT_BLADE_CAST.getSand());
        tab.accept(SPEAR_HEAD_CAST.getSand());
        tab.accept(GREAT_BLADE_CAST.getRedSand());
        tab.accept(SPEAR_HEAD_CAST.getRedSand());
    }

    private static void accept(Consumer<ItemStack> output, Supplier<? extends IMaterialItem> item) {
        item.get().addVariants(output, "");
    }
}
