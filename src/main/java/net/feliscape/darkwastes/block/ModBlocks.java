package net.feliscape.darkwastes.block;

import net.feliscape.darkwastes.Darkwastes;
import net.feliscape.darkwastes.block.custom.GreedyEffigyBlock;
import net.feliscape.darkwastes.block.custom.NimbleEffigyBlock;
import net.feliscape.darkwastes.block.custom.StalwartEffigyBlock;
import net.feliscape.darkwastes.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Darkwastes.MOD_ID);

    public static final RegistryObject<Block> ASH_BLOCK = registerBlock("ash_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SNOW_BLOCK).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> CINDERROCK = registerBlock("cinderrock",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BASALT)));
    public static final RegistryObject<Block> FERVOR_SHARD_BLOCK = registerBlock("fervor_shard_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> FERVOR_SHARD_ORE = registerBlock("fervor_shard_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.BASALT)
                    .strength(1.75f), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> STALWART_EFFIGY = registerBlock("stalwart_effigy",
            () -> new StalwartEffigyBlock(BlockBehaviour.Properties.copy(ModBlocks.CINDERROCK.get()).strength(2f).noOcclusion()));
    public static final RegistryObject<Block> GREEDY_EFFIGY = registerBlock("greedy_effigy",
            () -> new GreedyEffigyBlock(BlockBehaviour.Properties.copy(ModBlocks.CINDERROCK.get()).strength(2f).noOcclusion()));
    public static final RegistryObject<Block> NIMBLE_EFFIGY = registerBlock("nimble_effigy",
            () -> new NimbleEffigyBlock(BlockBehaviour.Properties.copy(ModBlocks.CINDERROCK.get()).strength(2f).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
