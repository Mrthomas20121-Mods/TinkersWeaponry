package mrthomas20121.thermalweaponry.datagen;

import mrthomas20121.thermalweaponry.TinkersWeaponry;
import mrthomas20121.thermalweaponry.init.TinkersWeaponryItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.common.data.model.MaterialModelBuilder;
import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.library.tools.part.MaterialItem;

public class TinkersWeaponryItemModelProvider extends ItemModelProvider {

    public TinkersWeaponryItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TinkersWeaponry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        part(TinkersWeaponryItems.SPEAR_HEAD);
        part(TinkersWeaponryItems.GREAT_BLADE);

        cast(TinkersWeaponryItems.SPEAR_HEAD_CAST, "spear_head");
        cast(TinkersWeaponryItems.GREAT_BLADE_CAST, "great_blade");
    }

    public void cast(CastItemObject cast, String castName) {
        basicItem(cast.get(), "cast/"+castName);
        basicItem(cast.getSand(), "sand_cast/"+castName);
        basicItem(cast.getRedSand(), "red_sand_cast/"+castName);
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

    @SuppressWarnings("deprecation") // no its not
    private ResourceLocation id(ItemLike item) {
        return BuiltInRegistries.ITEM.getKey(item.asItem());
    }

    /** Creates a part model with the given texture */
    private MaterialModelBuilder<ItemModelBuilder> part(ResourceLocation part, String texture) {
        return withExistingParent(part.getPath(), "forge:item/default")
                .texture("texture", new ResourceLocation(TinkersWeaponry.MOD_ID, "item/tool/" + texture))
                .customLoader(MaterialModelBuilder::new);
    }

    /** Creates a part model in the parts folder */
    private MaterialModelBuilder<ItemModelBuilder> part(Item item, String texture) {
        return part(id(item), texture);
    }

    /** Creates a part model with the given texture */
    private MaterialModelBuilder<ItemModelBuilder> part(ItemObject<? extends MaterialItem> part, String texture) {
        return part(part.getId(), texture);
    }

    /** Creates a part model in the parts folder */
    private void part(ItemObject<? extends MaterialItem> part) {
        part(part, "parts/" + part.getId().getPath());
    }
}
