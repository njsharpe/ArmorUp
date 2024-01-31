package net.njsharpe.armorup.item;

import net.njsharpe.armorup.ArmorUp;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public class ModifiedArmorTrim {

    public static final NamespacedKey KEY = new NamespacedKey(ArmorUp.getInstance(), "modified_armor_trim");

    private final Material armorTrim;

    public ModifiedArmorTrim(Material armorTrim) {
        assert this.isArmorTrim(armorTrim): "Expected Smithing Template, got: " + armorTrim;
        this.armorTrim = armorTrim;
    }

    public Material getArmorTrim() {
        return this.armorTrim;
    }

    public boolean isArmorTrim(Material material) {
        return switch (material) {
            case EYE_ARMOR_TRIM_SMITHING_TEMPLATE,
                    COAST_ARMOR_TRIM_SMITHING_TEMPLATE,
                    DUNE_ARMOR_TRIM_SMITHING_TEMPLATE,
                    HOST_ARMOR_TRIM_SMITHING_TEMPLATE,
                    RAISER_ARMOR_TRIM_SMITHING_TEMPLATE,
                    RIB_ARMOR_TRIM_SMITHING_TEMPLATE,
                    SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE,
                    SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE,
                    SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE,
                    SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE,
                    SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE,
                    TIDE_ARMOR_TRIM_SMITHING_TEMPLATE,
                    VEX_ARMOR_TRIM_SMITHING_TEMPLATE,
                    WARD_ARMOR_TRIM_SMITHING_TEMPLATE,
                    WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE,
                    WILD_ARMOR_TRIM_SMITHING_TEMPLATE -> true;
            default -> false;
        };
    }

}
