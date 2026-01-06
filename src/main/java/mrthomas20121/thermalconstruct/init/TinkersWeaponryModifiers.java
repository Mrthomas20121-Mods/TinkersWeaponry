package mrthomas20121.thermalconstruct.init;

import mrthomas20121.thermalconstruct.TinkersWeaponry;
import mrthomas20121.thermalconstruct.util.AnalyticModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class TinkersWeaponryModifiers {

    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersWeaponry.MOD_ID);

    public static StaticModifier<AnalyticModifier> ANALYTIC = MODIFIERS.register("analytic", AnalyticModifier::new);
}
