package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.TinkersWeaponry;
import mrthomas20121.thermalconstruct.init.TinkersWeaponryItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.common.registration.CastItemObject;

import java.util.Objects;

public class TinkersWeaponryItemModelProvider extends ItemModelProvider {

    public TinkersWeaponryItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TinkersWeaponry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(TinkersWeaponryItems.SPEAR_HEAD.get(), "tool/parts/spear_head");
        basicItem(TinkersWeaponryItems.GREAT_BLADE.get(), "tool/parts/great_blade");

        cast(TinkersWeaponryItems.SPEAR_HEAD_CAST, "spear_head");
        cast(TinkersWeaponryItems.GREAT_BLADE_CAST, "great_blade");
    }

    public void cast(CastItemObject cast, String castName) {
        basicItem(cast.get(), "cast/"+castName + "_gold");
        basicItem(cast.getSand(), "cast/"+castName + "_sand");
        basicItem(cast.getRedSand(), "cast/"+castName + "_red_sand");
    }

    public ItemModelBuilder basicItem(Item item, String texture)
    {
        ResourceLocation loc = ForgeRegistries.ITEMS.getKey(item);
        return getBuilder(loc.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", new ResourceLocation(loc.getNamespace(), "item/" + texture));
    }

    public ItemModelBuilder basicItem(ResourceLocation item, String texture)
    {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", new ResourceLocation(item.getNamespace(), "item/" + texture));
    }
}
