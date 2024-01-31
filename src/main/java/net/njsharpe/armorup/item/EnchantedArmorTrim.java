package net.njsharpe.armorup.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class EnchantedArmorTrim extends ModifiedArmorTrim {

    public static final EnchantedArmorTrim EYE_ARMOR_TRIM = new EnchantedArmorTrim(
            Material.EYE_ARMOR_TRIM_SMITHING_TEMPLATE, Enchantment.PROTECTION_PROJECTILE);
    public static final EnchantedArmorTrim COAST_ARMOR_TRIM = new EnchantedArmorTrim(
            Material.COAST_ARMOR_TRIM_SMITHING_TEMPLATE, Enchantment.WATER_WORKER);
    // Husks
    public static final EnchantedArmorTrim DUNE_ARMOR_TRIM = new EnchantedArmorTrim(
            Material.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE, Enchantment.BINDING_CURSE);
    // Strays
    public static final EnchantedArmorTrim SENTRY_ARMOR_TRIM = new EnchantedArmorTrim(
            Material.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE, Enchantment.VANISHING_CURSE);
    public static final EnchantedArmorTrim TIDE_ARMOR_TRIM = new EnchantedArmorTrim(
            Material.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE, Enchantment.OXYGEN);

    private final Enchantment enchantment;

    public EnchantedArmorTrim(Material armorTrim, Enchantment enchantment) {
        super(armorTrim);
        assert enchantment != null;

        this.enchantment = enchantment;
    }

    public Enchantment getEnchantment() {
        return this.enchantment;
    }

    public static EnchantedArmorTrim[] trims() {
        return new EnchantedArmorTrim[] {
                EYE_ARMOR_TRIM,
                COAST_ARMOR_TRIM,
                DUNE_ARMOR_TRIM,
                SENTRY_ARMOR_TRIM,
                TIDE_ARMOR_TRIM
        };
    }

}
