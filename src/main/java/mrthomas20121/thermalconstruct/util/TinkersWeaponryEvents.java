package mrthomas20121.thermalconstruct.util;

import mrthomas20121.thermalconstruct.TinkersWeaponry;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

@Mod.EventBusSubscriber(modid = TinkersWeaponry.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TinkersWeaponryEvents {

    @SubscribeEvent
    public static void critEvent(CriticalHitEvent event) {
        Player player = event.getEntity();
        if(!event.isVanillaCritical()) {
            ItemStack itemStack = player.getMainHandItem();
            if(!itemStack.isEmpty() && itemStack.is(TinkerTags.Items.MELEE_WEAPON)) {
                ToolStack toolStack = ToolStack.from(itemStack);

                float critChance = toolStack.getStats().get(TinkersWeaponryToolStats.CRIT_CHANCE);
                if(critChance == 1) {
                    event.setResult(Event.Result.ALLOW);
                }
                else if(critChance > 0) {
                    if(player.getRandom().nextFloat() < critChance) {
                        event.setResult(Event.Result.ALLOW);
                    }
                }
            }
        }
    }
}
