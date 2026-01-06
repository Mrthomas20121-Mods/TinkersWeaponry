package mrthomas20121.thermalconstruct.util;

import mrthomas20121.thermalconstruct.TinkersWeaponry;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.tools.definition.ToolDefinitionLoader;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ToolStatId;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class TinkersWeaponryToolStats {

    public static final PercentFloatToolStat CRIT_CHANCE = ToolStats.register(new PercentFloatToolStat(named("crit_chance"), 0xFFCC6A47, 0f, 0, 1, TinkerTags.Items.MELEE_WEAPON));

    private static ToolStatId named(String name) {
        return new ToolStatId(TinkersWeaponry.MOD_ID, name);
    }

    public static void init() {}
}
