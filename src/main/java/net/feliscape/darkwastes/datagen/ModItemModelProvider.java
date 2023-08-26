package net.feliscape.darkwastes.datagen;

import net.feliscape.darkwastes.Darkwastes;
import net.feliscape.darkwastes.block.ModBlocks;
import net.feliscape.darkwastes.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Darkwastes.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ASH);
        simpleItem(ModItems.FERVOR_SHARDS);
        simpleItem(ModItems.PEAT_BREAD);
        simpleItem(ModItems.EMBERBERRY);
        simpleItem(ModItems.TWIG);

        evenSimplerBlockItem(ModBlocks.CHARRED_LOG);
        evenSimplerBlockItem(ModBlocks.STRIPPED_CHARRED_LOG);

        simpleBlockItem(ModBlocks.CHARRED_DOOR);

        fenceItem(ModBlocks.CHARRED_FENCE, ModBlocks.CHARRED_PLANKS);
        buttonItem(ModBlocks.CHARRED_BUTTON, ModBlocks.CHARRED_PLANKS);

        evenSimplerBlockItem(ModBlocks.CHARRED_SLAB);
        evenSimplerBlockItem(ModBlocks.CHARRED_STAIRS);
        evenSimplerBlockItem(ModBlocks.CHARRED_FENCE_GATE);
        evenSimplerBlockItem(ModBlocks.CHARRED_PRESSURE_PLATE);

        trapdoorItem(ModBlocks.CHARRED_TRAPDOOR);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Darkwastes.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Darkwastes.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(Darkwastes.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(Darkwastes.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(Darkwastes.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(Darkwastes.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Darkwastes.MOD_ID,"item/" + item.getId().getPath()));
    }
}
