package info.charlieward.lousyutils.block;

import info.charlieward.lousyutils.LousyUtils;
import info.charlieward.lousyutils.block.jump.*;
import info.charlieward.lousyutils.items.ModCreativeModeTab;
import info.charlieward.lousyutils.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LousyUtils.MODID);

    public static final RegistryObject<Block> JUMP_BLOCK = registerBlock("jump_block",
            () -> new JumpBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.LOUSY_UTILS_TAB);

    public static final RegistryObject<Block> JUMP_BLOCK_TIER_2 = registerBlock("jump_block_tier_2",
            () -> new JumpBlockTier2(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.LOUSY_UTILS_TAB);

    public static final RegistryObject<Block> JUMP_BLOCK_TIER_3 = registerBlock("jump_block_tier_3",
            () -> new JumpBlockTier3(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.LOUSY_UTILS_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
