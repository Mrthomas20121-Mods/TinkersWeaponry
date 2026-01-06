package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.TinkersWeaponry;
import mrthomas20121.thermalconstruct.init.TinkersWeaponryItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;
import slimeknights.mantle.recipe.data.ICommonRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;
import slimeknights.tconstruct.library.recipe.ingredient.MaterialIngredient;

import java.util.function.Consumer;

public class TinkersWeaponryRecipeProvider extends RecipeProvider implements IMaterialRecipeHelper, IToolRecipeHelper, ISmelteryRecipeHelper, ICommonRecipeHelper {

    public TinkersWeaponryRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        // material folders
        String materialFolder = "materials/";
        String smelteryFolder = "smeltery/";

        // modifier folders
        String upgradeFolder = "tools/modifiers/upgrade/";
        String abilityFolder = "tools/modifiers/ability/";
        String slotlessFolder = "tools/modifiers/slotless/";
        String upgradeSalvage = "tools/modifiers/salvage/upgrade/";
        String abilitySalvage = "tools/modifiers/salvage/ability/";
        String defenseFolder = "tools/modifiers/defense/";
        String defenseSalvage = "tools/modifiers/salvage/defense/";
        String compatFolder = "tools/modifiers/compat/";
        String compatSalvage = "tools/modifiers/salvage/compat/";
        String worktableFolder = "tools/modifiers/worktable/";
        String partFolder = "tools/parts/";
        String castFolder = "smeltery/casts/";

        //castCreation(consumer, MaterialIngredient.of(TinkersWeaponryItems.GREAT_BLADE.get()), TinkersWeaponryItems.GREAT_BLADE_CAST, castFolder, "great_blade");
        //castCreation(consumer, MaterialIngredient.of(TinkersWeaponryItems.SPEAR_HEAD.get()), TinkersWeaponryItems.SPEAR_HEAD_CAST, castFolder, "spear_head");

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
