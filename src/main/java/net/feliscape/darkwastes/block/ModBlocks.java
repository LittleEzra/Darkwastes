package net.feliscape.darkwastes.block;

import net.feliscape.darkwastes.Darkwastes;
import net.feliscape.darkwastes.block.custom.GreedyEffigyBlock;
import net.feliscape.darkwastes.block.custom.ModFlammableRotatablePillarBlock;
import net.feliscape.darkwastes.block.custom.NimbleEffigyBlock;
import net.feliscape.darkwastes.block.custom.StalwartEffigyBlock;
import net.feliscape.darkwastes.item.ModItems;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
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

    public static final RegistryObject<Block> CHARRED_LOG = registerBlock("charred_log",
            () -> new ModFlammableRotatablePillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .mapColor(MapColor.COLOR_BLACK), 5, 5));
    public static final RegistryObject<Block> STRIPPED_CHARRED_LOG = registerBlock("stripped_charred_log",
            () -> new ModFlammableRotatablePillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .mapColor(MapColor.COLOR_GRAY), 5, 5));
    public static final RegistryObject<Block> CHARRED_PLANKS = registerBlock("charred_planks",
            () -> simpleFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .mapColor(MapColor.COLOR_GRAY), 5, 20));
    public static final RegistryObject<Block> CHARRED_SLAB = registerBlock("charred_slab",
            () -> flammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)
                    .mapColor(MapColor.COLOR_GRAY), 5, 20));
    public static final RegistryObject<Block> CHARRED_STAIRS = registerBlock("charred_stairs",
            () -> flammableStairBlock(CHARRED_PLANKS.get(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)
                    .mapColor(MapColor.COLOR_GRAY), 5, 20));
    public static final RegistryObject<Block> CHARRED_FENCE = registerBlock("charred_fence",
            () -> flammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)
                    .mapColor(MapColor.COLOR_GRAY), 5, 20));
    public static final RegistryObject<Block> CHARRED_FENCE_GATE = registerBlock("charred_fence_gate",
            () -> flammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)
                    .mapColor(MapColor.COLOR_GRAY), 5, 20));

    public static final RegistryObject<Block> CHARRED_BUTTON = registerBlock("charred_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON),
                    BlockSetType.OAK, 30, true));
    public static final RegistryObject<Block> CHARRED_PRESSURE_PLATE = registerBlock("charred_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> CHARRED_DOOR = registerBlock("charred_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> CHARRED_TRAPDOOR = registerBlock("charred_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion(), BlockSetType.OAK));

    private static Boolean never(BlockState p_50779_, BlockGetter p_50780_, BlockPos p_50781_, EntityType<?> p_50782_) {
        return (boolean)false;
    }
    private static Boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }

    private static Boolean always(BlockState p_50810_, BlockGetter p_50811_, BlockPos p_50812_, EntityType<?> p_50813_) {
        return (boolean)true;
    }
    private static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
        return true;
    }

    private static Boolean ocelotOrParrot(BlockState p_50822_, BlockGetter p_50823_, BlockPos p_50824_, EntityType<?> p_50825_) {
        return (boolean)(p_50825_ == EntityType.OCELOT || p_50825_ == EntityType.PARROT);
    }

    private static Block simpleFlammableBlock(BlockBehaviour.Properties properties, int flammability, int encouragement){
        return new Block(properties){
            @Override
            public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return true;
            }

            @Override
            public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return flammability;
            }

            @Override
            public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return encouragement;
            }
        };
    }
    private static SlabBlock flammableSlabBlock(BlockBehaviour.Properties properties, int flammability, int encouragement){
        return new SlabBlock(properties){
            @Override
            public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return true;
            }

            @Override
            public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return flammability;
            }

            @Override
            public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return encouragement;
            }
        };
    }
    private static StairBlock flammableStairBlock(Block base, BlockBehaviour.Properties properties, int flammability, int encouragement){
        return new StairBlock(base::defaultBlockState, properties){
            @Override
            public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return true;
            }

            @Override
            public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return flammability;
            }

            @Override
            public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return encouragement;
            }
        };
    }
    private static FenceBlock flammableFenceBlock(BlockBehaviour.Properties properties, int flammability, int encouragement){
        return new FenceBlock(properties){
            @Override
            public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return true;
            }

            @Override
            public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return flammability;
            }

            @Override
            public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return encouragement;
            }
        };
    }
    private static FenceGateBlock flammableFenceGateBlock(BlockBehaviour.Properties properties, int flammability, int encouragement){
        return new FenceGateBlock(properties, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN){
            @Override
            public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return true;
            }

            @Override
            public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return flammability;
            }

            @Override
            public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return encouragement;
            }
        };
    }

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
