package mrthomas20121.thermalweaponry.datagen;

import mrthomas20121.thermalweaponry.TinkersWeaponry;
import mrthomas20121.thermalweaponry.TinkersWeaponryModifierIds;
import mrthomas20121.thermalweaponry.init.TinkersWeaponryItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class TinkersWeaponryLangProvider extends LanguageProvider {

    public TinkersWeaponryLangProvider(PackOutput output) {
        super(output, TinkersWeaponry.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        add("itemGroup.tinkersweaponry.tool_parts", "Tinkers' Weaponry Tool Parts");
        add("itemGroup.tinkersweaponry.tools", "Tinkers' Weaponry Tools");

        add(TinkersWeaponryItems.GREAT_BLADE.get(), "Great Blade");
        add(TinkersWeaponryItems.SPEAR_HEAD.get(), "Spear Head");

        add(TinkersWeaponryItems.GREATSWORD.get(), "Greatsword");
        add(TinkersWeaponryItems.PIKE.get(), "Pike");
        add(TinkersWeaponryItems.LANCE.get(), "Lance");

        addToolDesc(TinkersWeaponryItems.GREATSWORD.get(), "The greatsword is a weapon with healing properties");
        addToolDesc(TinkersWeaponryItems.PIKE.get(), "The Pike is a weapon very good at killing aquatic mobs.");
        addToolDesc(TinkersWeaponryItems.LANCE.get(), "The Lance is a weapon very good at piercing mobs.");

        addPattern("great_blade", "Great Blade");
        addPattern("spear_head", "Spear Head");

        addCast(TinkersWeaponryItems.GREAT_BLADE_CAST, "Great Blade");
        addCast(TinkersWeaponryItems.SPEAR_HEAD_CAST, "Spear Head");

        addModifier(TinkersWeaponryModifierIds.LENGTHY, "Lengthy");
        addModifierDesc(TinkersWeaponryModifierIds.LENGTHY, "Increase entity and block range by 1.5.");
        addModifierFlavor(TinkersWeaponryModifierIds.LENGTHY, "Think Big!");
    }

    public void addCast(CastItemObject cast, String castName) {
        add(cast.getSand(), castName + " Sand Cast");
        add(cast.getRedSand(), castName + " Red Sand Cast");
        add(cast.get(), castName + " Cast");
    }

    public void addToolDesc(Item key, String name) {
        add(key.getDescriptionId()+".description", name);
    }

    public void addModifier(ModifierId material, String s) {
        add("modifier."+material.getNamespace()+"."+material.getPath(), s);
    }

    public void addModifierFlavor(ModifierId material, String s) {
        add("modifier."+material.getNamespace()+"."+material.getPath()+".flavor", s);
    }

    public void addModifierDesc(ModifierId material, String s) {
        add("modifier."+material.getNamespace()+"."+material.getPath()+".description", s);
    }

    public void addPattern(String paternName, String value) {
        add("pattern.%s.%s".formatted(TinkersWeaponry.MOD_ID, paternName), value);
    }


}
