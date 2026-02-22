package mrthomas20121.thermalweaponry.datagen;

import mrthomas20121.thermalweaponry.TinkersWeaponry;
import mrthomas20121.thermalweaponry.init.TinkersWeaponryItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import slimeknights.mantle.recipe.data.ICommonRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;

import java.util.function.Consumer;

public class TinkersWeaponryRecipeProvider extends RecipeProvider implements IMaterialRecipeHelper, IToolRecipeHelper, ISmelteryRecipeHelper, ICommonRecipeHelper {

    public TinkersWeaponryRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        String partFolder = "tools/parts/";
        String castFolder = "smeltery/casts/";

        toolBuilding(consumer, TinkersWeaponryItems.GREATSWORD.get(), "tools/building/");
        toolBuilding(consumer, TinkersWeaponryItems.LANCE.get(), "tools/building/");
        toolBuilding(consumer, TinkersWeaponryItems.PIKE.get(), "tools/building/");

        partRecipes(consumer, TinkersWeaponryItems.GREAT_BLADE, TinkersWeaponryItems.GREAT_BLADE_CAST, 2, partFolder, castFolder);
        partRecipes(consumer, TinkersWeaponryItems.SPEAR_HEAD, TinkersWeaponryItems.SPEAR_HEAD_CAST, 2, partFolder, castFolder);
    }

    @Override
    public String getModId() {
        return TinkersWeaponry.MOD_ID;
    }
}
