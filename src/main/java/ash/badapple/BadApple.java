package ash.badapple;

import ash.badapple.block.ModBlocks;
import ash.badapple.item.ModItemGroups;
import ash.badapple.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BadApple implements ModInitializer {
	public static final String MOD_ID = "badapple";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModItemGroups.registerItemGroups();
	}
}