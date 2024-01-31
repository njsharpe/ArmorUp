package net.njsharpe.armorup.item;

import org.bukkit.Material;
import org.bukkit.potion.PotionEffectType;

public class EffectedArmorTrim extends ModifiedArmorTrim {

    // Husks
    public static final EffectedArmorTrim DUNE_ARMOR_TRIM = new EffectedArmorTrim(
            Material.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE, PotionEffectType.HUNGER);
    public static final EffectedArmorTrim HOST_ARMOR_TRIM = new EffectedArmorTrim(
            Material.HOST_ARMOR_TRIM_SMITHING_TEMPLATE, PotionEffectType.GLOWING);
    public static final EffectedArmorTrim RIB_ARMOR_TRIM = new EffectedArmorTrim(
            Material.RIB_ARMOR_TRIM_SMITHING_TEMPLATE, PotionEffectType.WITHER);
    // Stays
    public static final EffectedArmorTrim SENTRY_ARMOR_TRIM = new EffectedArmorTrim(
            Material.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE, PotionEffectType.SLOW);
    public static final EffectedArmorTrim SHAPER_ARMOR_TRIM = new EffectedArmorTrim(
            Material.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE, PotionEffectType.FAST_DIGGING);
    public static final EffectedArmorTrim SILENCE_ARMOR_TRIM = new EffectedArmorTrim(
            Material.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE, PotionEffectType.INVISIBILITY);
    public static final EffectedArmorTrim SPIRE_ARMOR_TRIM = new EffectedArmorTrim(
            Material.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE, PotionEffectType.LEVITATION);
    public static final EffectedArmorTrim TIDE_ARMOR_TRIM = new EffectedArmorTrim(
            Material.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE, PotionEffectType.SLOW_DIGGING);
    public static final EffectedArmorTrim VEX_ARMOR_TRIM = new EffectedArmorTrim(
            Material.VEX_ARMOR_TRIM_SMITHING_TEMPLATE, PotionEffectType.BAD_OMEN);
    public static final EffectedArmorTrim WARD_ARMOR_TRIM = new EffectedArmorTrim(
            Material.WARD_ARMOR_TRIM_SMITHING_TEMPLATE, PotionEffectType.DARKNESS);
    public static final EffectedArmorTrim WAYFINDER_ARMOR_TRIM = new EffectedArmorTrim(
            Material.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE, PotionEffectType.NIGHT_VISION);
    public static final EffectedArmorTrim WILD_ARMOR_TRIM = new EffectedArmorTrim(
            Material.WILD_ARMOR_TRIM_SMITHING_TEMPLATE, PotionEffectType.CONFUSION);

    private final PotionEffectType effectType;

    public EffectedArmorTrim(Material armorTrim, PotionEffectType effectType) {
        super(armorTrim);
        assert effectType != null;
        this.effectType = effectType;
    }

    public PotionEffectType getEffectType() {
        return this.effectType;
    }

    public static EffectedArmorTrim[] trims() {
        return new EffectedArmorTrim[] {
                DUNE_ARMOR_TRIM,
                HOST_ARMOR_TRIM,
                RIB_ARMOR_TRIM,
                SENTRY_ARMOR_TRIM,
                SHAPER_ARMOR_TRIM,
                SILENCE_ARMOR_TRIM,
                SPIRE_ARMOR_TRIM,
                TIDE_ARMOR_TRIM,
                VEX_ARMOR_TRIM,
                WARD_ARMOR_TRIM,
                WAYFINDER_ARMOR_TRIM,
                WILD_ARMOR_TRIM
        };
    }

}
