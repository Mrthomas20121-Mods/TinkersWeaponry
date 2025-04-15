package mrthomas20121.thermalconstruct.util;

import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.IToolStat;
import slimeknights.tconstruct.library.tools.stat.ToolStatId;

public class PercentFloatToolStat extends FloatToolStat {

    public PercentFloatToolStat(ToolStatId name, int color, float defaultValue, float minValue, float maxValue, @Nullable TagKey<Item> tag) {
        super(name, color, defaultValue, minValue, maxValue, tag);
    }

    public PercentFloatToolStat(ToolStatId name, int color, float defaultValue, float minValue, float maxValue) {
        super(name, color, defaultValue, minValue, maxValue);
    }

    @Override
    public Component formatValue(float value) {
        return IToolStat.formatNumberPercent(getTranslationKey(), getColor(), value);
    }
}
