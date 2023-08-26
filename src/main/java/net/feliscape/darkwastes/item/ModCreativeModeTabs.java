package net.feliscape.darkwastes.item;

import net.feliscape.darkwastes.Darkwastes;
import net.feliscape.darkwastes.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Darkwastes.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DARKWASTES_TAB = CREATIVE_MODE_TABS.register("darkwastes_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ASH.get()))
                    .title(Component.translatable("creativetab.darkwastes_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ASH.get());
                        pOutput.accept(ModBlocks.ASH_BLOCK.get());

                        pOutput.accept(ModItems.FERVOR_SHARDS.get());
                        pOutput.accept(ModBlocks.FERVOR_SHARD_BLOCK.get());
                        pOutput.accept(ModBlocks.FERVOR_SHARD_ORE.get());
                        pOutput.accept(ModBlocks.CINDERROCK.get());

                        pOutput.accept(ModBlocks.STALWART_EFFIGY.get());
                        pOutput.accept(ModBlocks.GREEDY_EFFIGY.get());
                        pOutput.accept(ModBlocks.NIMBLE_EFFIGY.get());

                        pOutput.accept(ModItems.PEAT_BREAD.get());
                        pOutput.accept(ModItems.EMBERBERRY.get());
                        pOutput.accept(ModItems.TWIG.get());

                        pOutput.accept(ModBlocks.CHARRED_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_CHARRED_LOG.get());
                        pOutput.accept(ModBlocks.CHARRED_PLANKS.get());
                        pOutput.accept(ModBlocks.CHARRED_SLAB.get());
                        pOutput.accept(ModBlocks.CHARRED_STAIRS.get());
                        pOutput.accept(ModBlocks.CHARRED_FENCE.get());
                        pOutput.accept(ModBlocks.CHARRED_FENCE_GATE.get());

                        pOutput.accept(ModBlocks.CHARRED_DOOR.get());
                        pOutput.accept(ModBlocks.CHARRED_TRAPDOOR.get());

                        pOutput.accept(ModBlocks.CHARRED_BUTTON.get());
                        pOutput.accept(ModBlocks.CHARRED_PRESSURE_PLATE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
