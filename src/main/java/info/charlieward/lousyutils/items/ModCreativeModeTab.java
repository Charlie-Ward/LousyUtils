package info.charlieward.lousyutils.items;

import info.charlieward.lousyutils.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab LOUSY_UTILS_TAB = new CreativeModeTab("lousyutilstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.JUMP_BLOCK.get());
        }
    };
}
