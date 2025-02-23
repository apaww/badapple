package ash.badapple.item;

import ash.badapple.BadApple;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SUPER_APPLE = registerItem("super_apple", new Item.Settings());
    public static final Item COOKED_SUPER_APPLE = registerItem("cooked_super_apple", new Item.Settings());

    private static Item registerItem(String name, Item.Settings itemSettings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BadApple.MOD_ID, name));
        Item item = new Item(itemSettings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModItems() {
        BadApple.LOGGER.info("Registering Mod Items for " + BadApple.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SUPER_APPLE);
            entries.add(COOKED_SUPER_APPLE);
        });
    }
}
