package mrthomas20121.thermalconstruct.client;

import mrthomas20121.thermalconstruct.TinkersWeaponry;
import mrthomas20121.thermalconstruct.init.TinkersWeaponryItems;
import net.minecraft.client.color.item.ItemColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import slimeknights.tconstruct.library.client.model.TinkerItemProperties;
import slimeknights.tconstruct.tools.TinkerTools;

import static slimeknights.tconstruct.library.client.model.tools.ToolModel.registerItemColors;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = TinkersWeaponry.MOD_ID)
public class ClientEvents {

    @SubscribeEvent
    static void clientSetupEvent(FMLClientSetupEvent event) {

        event.enqueueWork(() -> {
            TinkerItemProperties.registerToolProperties(TinkersWeaponryItems.GREATSWORD);
            TinkerItemProperties.registerToolProperties(TinkersWeaponryItems.LANCE);
            TinkerItemProperties.registerToolProperties(TinkersWeaponryItems.PIKE);
        });
    }

    @SubscribeEvent
    static void itemColors(RegisterColorHandlersEvent.Item event) {
        final ItemColors colors = event.getItemColors();

        registerItemColors(colors, TinkersWeaponryItems.GREATSWORD);
        registerItemColors(colors, TinkersWeaponryItems.LANCE);
        registerItemColors(colors, TinkersWeaponryItems.PIKE);

    }
}
