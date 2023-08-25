package net.feliscape.darkwastes.datagen.loot;

import net.feliscape.darkwastes.block.ModBlocks;
import net.feliscape.darkwastes.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // If you want a block to drop nothing ever, call .noLootTable() on the block. That will make it exempt from this.

        dropSelf(ModBlocks.ASH_BLOCK.get());
        dropSelf(ModBlocks.CINDERROCK.get());
        dropSelf(ModBlocks.FERVOR_SHARD_BLOCK.get());
        dropSelf(ModBlocks.STALWART_EFFIGY.get());
        dropSelf(ModBlocks.GREEDY_EFFIGY.get());
        dropSelf(ModBlocks.NIMBLE_EFFIGY.get());

        this.add(ModBlocks.FERVOR_SHARD_ORE.get(),
                block -> createOreDrop(ModBlocks.FERVOR_SHARD_ORE.get(), ModItems.FERVOR_SHARDS.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
