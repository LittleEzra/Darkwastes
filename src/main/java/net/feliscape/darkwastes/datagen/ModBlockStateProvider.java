package net.feliscape.darkwastes.datagen;

import net.feliscape.darkwastes.Darkwastes;
import net.feliscape.darkwastes.block.ModBlocks;
import net.feliscape.darkwastes.block.custom.ModFlammableRotatablePillarBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Darkwastes.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ASH_BLOCK);
        blockWithItem(ModBlocks.CINDERROCK);
        blockWithItem(ModBlocks.FERVOR_SHARD_BLOCK);
        blockWithItem(ModBlocks.FERVOR_SHARD_ORE);

        logBlock((ModFlammableRotatablePillarBlock)ModBlocks.CHARRED_LOG.get());
        logBlock((ModFlammableRotatablePillarBlock)ModBlocks.STRIPPED_CHARRED_LOG.get());
        blockWithItem(ModBlocks.CHARRED_PLANKS);

        slabBlock(((SlabBlock) ModBlocks.CHARRED_SLAB.get()), blockTexture(ModBlocks.CHARRED_PLANKS.get()), blockTexture(ModBlocks.CHARRED_PLANKS.get()));
        stairsBlock(((StairBlock) ModBlocks.CHARRED_STAIRS.get()), blockTexture(ModBlocks.CHARRED_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.CHARRED_BUTTON.get()), blockTexture(ModBlocks.CHARRED_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.CHARRED_PRESSURE_PLATE.get()), blockTexture(ModBlocks.CHARRED_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.CHARRED_FENCE.get()), blockTexture(ModBlocks.CHARRED_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.CHARRED_FENCE_GATE.get()), blockTexture(ModBlocks.CHARRED_PLANKS.get()));

        doorBlock(((DoorBlock) ModBlocks.CHARRED_DOOR.get()), modLoc("block/charred_door_bottom"),modLoc("block/charred_door_top"));
        trapdoorBlock(((TrapDoorBlock) ModBlocks.CHARRED_TRAPDOOR.get()), modLoc("block/charred_trapdoor"), true);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    public void logBlockWithItem(RotatedPillarBlock block) {
        axisBlockWithItem(block, blockTexture(block), extend(blockTexture(block), "_top"));
    }

    public void axisBlockWithItem(RotatedPillarBlock block, ResourceLocation side, ResourceLocation end) {
        axisBlockWithItem(block,
                models().cubeColumn(name(block), side, end),
                models().cubeColumnHorizontal(name(block) + "_horizontal", side, end));
    }

    public void axisBlockWithItem(RotatedPillarBlock block, ModelFile vertical, ModelFile horizontal) {
        getVariantBuilder(block)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y)
                .modelForState().modelFile(vertical).addModel()
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Z)
                .modelForState().modelFile(horizontal).rotationX(90).addModel()
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.X)
                .modelForState().modelFile(horizontal).rotationX(90).rotationY(90).addModel();
        simpleBlockItem(block, vertical);
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
    private String name(Block block) {
        return key(block).getPath();
    }
    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }

}
