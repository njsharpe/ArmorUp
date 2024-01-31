package net.njsharpe.armorup.item;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;

public class AttributedArmorTrim extends ModifiedArmorTrim {

    public static final AttributedArmorTrim EYE_ARMOR_TRIM = new AttributedArmorTrim(
            Material.EYE_ARMOR_TRIM_SMITHING_TEMPLATE, Attribute.GENERIC_LUCK);
    public static final AttributedArmorTrim RAISER_ARMOR_TRIM = new AttributedArmorTrim(
            Material.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE, Attribute.GENERIC_ATTACK_DAMAGE);
    public static final AttributedArmorTrim RIB_ARMOR_TRIM = new AttributedArmorTrim(
            Material.RIB_ARMOR_TRIM_SMITHING_TEMPLATE, Attribute.GENERIC_MOVEMENT_SPEED);
    public static final AttributedArmorTrim SNOUT_ARMOR_TRIM = new AttributedArmorTrim(
            Material.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE, Attribute.GENERIC_KNOCKBACK_RESISTANCE);
    public static final AttributedArmorTrim WILD_ARMOR_TRIM = new AttributedArmorTrim(
            Material.WILD_ARMOR_TRIM_SMITHING_TEMPLATE, Attribute.GENERIC_ARMOR_TOUGHNESS);

    private final Attribute attribute;

    public AttributedArmorTrim(Material armorTrim, Attribute attribute) {
        super(armorTrim);
        this.attribute = attribute;
    }

    public Attribute getAttribute() {
        return this.attribute;
    }

    public static AttributedArmorTrim[] trims() {
        return new AttributedArmorTrim[] {
                EYE_ARMOR_TRIM,
                RAISER_ARMOR_TRIM,
                RIB_ARMOR_TRIM,
                SNOUT_ARMOR_TRIM,
                WILD_ARMOR_TRIM
        };
    }

}
