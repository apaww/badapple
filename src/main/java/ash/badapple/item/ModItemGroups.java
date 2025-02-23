package ash.badapple.item;

import ash.badapple.BadApple;
import ash.badapple.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BAD_APPLE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BadApple.MOD_ID, "bad_apple_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SUPER_APPLE))
            .displayName(Text.translatable("itemgroup.badapple.bad_apple_items"))
            .entries((displayContext, entries) -> {
                entries.add(ModItems.COOKED_SUPER_APPLE);
                entries.add(ModItems.SUPER_APPLE);
            }).build());

    public static final ItemGroup BAD_APPLE_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BadApple.MOD_ID, "bad_apple_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.APPLE_BLOCK))
                    .displayName(Text.translatable("itemgroup.badapple.bad_apple_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.APPLE_BLOCK);
                        entries.add(ModBlocks.ERROR_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        BadApple.LOGGER.info("Registering Item Groups for " + BadApple.MOD_ID);
    }
}
