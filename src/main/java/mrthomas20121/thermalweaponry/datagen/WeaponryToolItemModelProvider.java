package mrthomas20121.thermalweaponry.datagen;

import com.google.gson.JsonObject;
import mrthomas20121.thermalweaponry.TinkersWeaponry;
import mrthomas20121.thermalweaponry.init.TinkersWeaponryItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.library.data.AbstractToolItemModelProvider;

import java.io.IOException;

import static slimeknights.tconstruct.TConstruct.getResource;

public class WeaponryToolItemModelProvider extends AbstractToolItemModelProvider {

    public WeaponryToolItemModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, existingFileHelper, TinkersWeaponry.MOD_ID);
    }

    @Override
    protected void addModels() throws IOException {
        JsonObject toolBlocking = readJson(getResource("base/tool_blocking"));

        tool(TinkersWeaponryItems.GREATSWORD, toolBlocking, "head");
        tool(TinkersWeaponryItems.LANCE, toolBlocking, "head");
        tool(TinkersWeaponryItems.PIKE, toolBlocking, "head");
    }

    @Override
    public String getName() {
        return "Tinkers Weaponry Tools Models";
    }
}
