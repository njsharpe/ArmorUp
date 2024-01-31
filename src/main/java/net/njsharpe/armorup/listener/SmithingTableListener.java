package net.njsharpe.armorup.listener;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import net.kyori.adventure.text.Component;
import net.njsharpe.armorup.item.EffectedArmorTrim;
import net.njsharpe.armorup.item.ModifiedArmorTrim;
import net.njsharpe.armorup.item.AttributedArmorTrim;
import net.njsharpe.armorup.item.EnchantedArmorTrim;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.SmithItemEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.SmithingInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.BiConsumer;

public class SmithingTableListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onSmithingTableCraft(SmithItemEvent event) {
        Player player = (Player) event.getWhoClicked();

        for(EnchantedArmorTrim trim : EnchantedArmorTrim.trims()) {
            this.processArmorTrim(trim, event, (t, r) -> {
                try {
                    r.addEnchantment(t.getEnchantment(), 1);
                } catch (IllegalArgumentException ex) {
                    player.sendMessage(Component.text("Idiot :)"));
                    r.addUnsafeEnchantment(t.getEnchantment(), 1);
                }
            });
        }

        for(AttributedArmorTrim trim : AttributedArmorTrim.trims()) {
            this.processArmorTrim(trim, event, (t, r) -> {

                EquipmentSlot slot;
                if(EnchantmentTarget.ARMOR_HEAD.includes(r)) {
                    slot = EquipmentSlot.HEAD;
                } else if(EnchantmentTarget.ARMOR_TORSO.includes(r)) {
                    slot = EquipmentSlot.CHEST;
                } else if(EnchantmentTarget.ARMOR_LEGS.includes(r)) {
                    slot = EquipmentSlot.LEGS;
                } else if(EnchantmentTarget.ARMOR_FEET.includes(r)) {
                    slot = EquipmentSlot.FEET;
                } else {
                    slot = EquipmentSlot.HAND;
                }

                assert slot != EquipmentSlot.HAND: "How did you smith non-armor?";

                ItemMeta meta = r.getItemMeta();
                String name = "attributable_" + t.getArmorTrim().name().toLowerCase();
                AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), name, 1,
                        AttributeModifier.Operation.ADD_NUMBER, slot);
                meta.addAttributeModifier(t.getAttribute(), modifier);
                r.setItemMeta(meta);
            });
        }

        for(EffectedArmorTrim trim : EffectedArmorTrim.trims()) {
            this.processArmorTrim(trim, event, (t, r) -> {
                ItemMeta meta = r.getItemMeta();
                PersistentDataContainer container = meta.getPersistentDataContainer();
                container.set(ModifiedArmorTrim.KEY, PersistentDataType.STRING,
                        t.getEffectType().getKey().value());
                r.setItemMeta(meta);
            });
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onArmorEquip(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();
        PlayerInventory inventory = player.getInventory();

        Set<PotionEffectType> effectTypes = new HashSet<>();
        for(ItemStack item : inventory.getArmorContents()) {
            if(item == null || item.getType().isAir()) {
                continue;
            }
            this.processArmor(player, item, (p, et) -> {
                if(!p.hasPotionEffect(et)) {
                    PotionEffect effect = new PotionEffect(et, PotionEffect.INFINITE_DURATION, 0,
                            true, false, false);
                    p.addPotionEffect(effect);
                }
                effectTypes.add(et);
            });
        }

        for(PotionEffect effect : player.getActivePotionEffects()) {
            PotionEffectType effectType = effect.getType();
            if(effectTypes.contains(effectType)) {
                continue;
            }
            player.removePotionEffect(effectType);
        }
    }

    private <T extends ModifiedArmorTrim> void processArmorTrim(T armorTrim, SmithItemEvent event,
                                                                BiConsumer<T, ItemStack> consumer) {
        SmithingInventory inventory = event.getInventory();
        ItemStack template = inventory.getInputTemplate();
        if(template == null || !template.getType().equals(armorTrim.getArmorTrim())) {
            return;
        }
        ItemStack stack = inventory.getResult();
        if(stack == null) {
            return;
        }
        consumer.accept(armorTrim, stack);
    }

    @SuppressWarnings("deprecation")
    private void processArmor(Player player, ItemStack itemStack,
                              BiConsumer<Player, PotionEffectType> consumer) {
        assert itemStack != null;
        if(itemStack.getType().isAir()) {
            return;
        }

        ItemMeta meta = itemStack.getItemMeta();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        if(!container.has(ModifiedArmorTrim.KEY)) {
            return;
        }

        String key = container.get(ModifiedArmorTrim.KEY, PersistentDataType.STRING);
        if(key == null) {
            return;
        }

        NamespacedKey namespacedKey = NamespacedKey.minecraft(key);
        PotionEffectType type = PotionEffectType.getByKey(namespacedKey);
        assert type != null: "Invalid potion type saved to item!";
        consumer.accept(player, type);
    }

}
