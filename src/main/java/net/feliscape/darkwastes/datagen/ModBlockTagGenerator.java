package net.feliscape.darkwastes.datagen;

import net.feliscape.darkwastes.Darkwastes;
import net.feliscape.darkwastes.block.ModBlocks;
import net.feliscape.darkwastes.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Darkwastes.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //this.tag(ModTags.Blocks.NAME)
        //        .add(Tags.Blocks.STONE);

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.FERVOR_SHARD_BLOCK.get(),
                        ModBlocks.FERVOR_SHARD_ORE.get()
                );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.FERVOR_SHARD_BLOCK.get(),
                        ModBlocks.FERVOR_SHARD_ORE.get(),
                        ModBlocks.CINDERROCK.get(),
                        ModBlocks.STALWART_EFFIGY.get(),
                        ModBlocks.GREEDY_EFFIGY.get(),
                        ModBlocks.NIMBLE_EFFIGY.get()
                );
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.ASH_BLOCK.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.CHARRED_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.CHARRED_FENCE_GATE.get());
    }
}
