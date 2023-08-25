package net.feliscape.darkwastes.datagen;

import net.feliscape.darkwastes.Darkwastes;
import net.feliscape.darkwastes.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
