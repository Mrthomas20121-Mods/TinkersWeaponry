package mrthomas20121.thermalconstruct;

import mrthomas20121.thermalconstruct.init.TinkersWeaponryItems;
import mrthomas20121.thermalconstruct.init.TinkersWeaponryModifiers;
import mrthomas20121.thermalconstruct.util.TinkersWeaponryToolStats;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TinkersWeaponry.MOD_ID)
public class TinkersWeaponry {

	public static final String MOD_ID = "tinkersweaponry";

	public TinkersWeaponry() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		TinkersWeaponryItems.ITEMS.register(bus);
		TinkersWeaponryItems.CREATIVE_TABS.register(bus);
		TinkersWeaponryModifiers.MODIFIERS.register(bus);

		// init tool stats so they're loaded before datapacks
		TinkersWeaponryToolStats.init();
	}
}
