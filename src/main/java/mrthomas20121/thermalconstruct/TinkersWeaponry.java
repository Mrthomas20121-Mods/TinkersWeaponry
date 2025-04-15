package mrthomas20121.thermalconstruct;

import mrthomas20121.thermalconstruct.datagen.TinkersWeaponryDatagen;
import mrthomas20121.thermalconstruct.init.TinkersWeaponryItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TinkersWeaponry.MOD_ID)
public class TinkersWeaponry {

	public static final String MOD_ID = "tinkersweaponry";

	public static String makeDescriptionId(String type, String name) {
		return type + "." + MOD_ID + "." + name;
	}

	public static ResourceLocation getResource(String name) {
		return new ResourceLocation(MOD_ID, name);
	}

	public TinkersWeaponry() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		TinkersWeaponryItems.ITEMS.register(bus);
		TinkersWeaponryItems.CREATIVE_TABS.register(bus);

		bus.addListener(EventPriority.NORMAL, false, GatherDataEvent.class, TinkersWeaponryDatagen::init);
	}
}
