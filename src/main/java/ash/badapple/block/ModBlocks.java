package ash.badapple.block;

import ash.badapple.BadApple;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block APPLE_BLOCK = registerBlock("apple_block",
            AbstractBlock.Settings.create().strength(4f).sounds(BlockSoundGroup.MOSS_BLOCK));
    public static final Block ERROR_BLOCK = registerBlock("error_block",
            AbstractBlock.Settings.create().strength(1f).sounds(BlockSoundGroup.ANVIL));

    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(BadApple.MOD_ID, name));
        Block block = new Block(blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }
    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BadApple.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }
    public static void registerModBlocks() {
        BadApple.LOGGER.info("Registering Mod Blocks for " + BadApple.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.APPLE_BLOCK);
            entries.add(ModBlocks.ERROR_BLOCK);
        });
    }
}
