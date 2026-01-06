package mrthomas20121.thermalconstruct.util;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ToolStatsModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;

import java.util.List;

public class AnalyticModifier extends Modifier implements ToolStatsModifierHook, TooltipModifierHook {

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);

        hookBuilder.addHook(this, ModifierHooks.TOOL_STATS).addHook(this, ModifierHooks.TOOLTIP);
    }

    @Override
    public int getPriority() {
        return 100000;
    }

    @Override
    public void addToolStats(IToolContext context, ModifierEntry modifier, ModifierStatsBuilder builder) {
        TinkersWeaponryToolStats.CRIT_CHANCE.add(builder, 0.3);
    }

    @Override
    public void addTooltip(IToolStackView tool, ModifierEntry modifier, @Nullable Player player, List<Component> tooltip, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        if(tooltipKey.equals(TooltipKey.SHIFT)) {
            tooltip.add(TinkersWeaponryToolStats.CRIT_CHANCE.formatValue(tool.getStats().get(TinkersWeaponryToolStats.CRIT_CHANCE)));
        }
    }
}
