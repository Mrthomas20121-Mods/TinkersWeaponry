package mrthomas20121.thermalconstruct.datagen;

import mrthomas20121.thermalconstruct.init.TinkersWeaponryItems;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.tinkering.AbstractStationSlotLayoutProvider;
import slimeknights.tconstruct.tools.TinkerToolParts;
import slimeknights.tconstruct.tools.TinkerTools;

public class WeaponryStationSlotLayoutProvider extends AbstractStationSlotLayoutProvider {

    public WeaponryStationSlotLayoutProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addLayouts() {
        defineModifiable(TinkersWeaponryItems.GREATSWORD)
                .sortIndex(SORT_WEAPON + SORT_LARGE)
                .addInputItem(TinkersWeaponryItems.GREAT_BLADE, 48, 26)
                .addInputItem(TinkerToolParts.toolHandle, 12, 62)
                .addInputItem(TinkerToolParts.toolHandle, 30, 44)
                .build();

        defineModifiable(TinkersWeaponryItems.LANCE)
                .sortIndex(SORT_WEAPON + SORT_LARGE)
                .addInputItem(TinkersWeaponryItems.SPEAR_HEAD, 48, 26)
                .addInputItem(TinkerToolParts.toughHandle, 12, 62)
                .addInputItem(TinkerToolParts.toughHandle, 30, 44)
                .build();

        defineModifiable(TinkersWeaponryItems.PIKE)
                .sortIndex(SORT_WEAPON + SORT_LARGE)
                .addInputItem(TinkersWeaponryItems.SPEAR_HEAD, 48, 26)
                .addInputItem(TinkerToolParts.toughHandle, 12, 62)
                .addInputItem(TinkerToolParts.toughHandle, 30, 44)
                .build();
    }

    @Override
    public String getName() {
        return "Tinkers' Weaponry Slot layouts";
    }
}
