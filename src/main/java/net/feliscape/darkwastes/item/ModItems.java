package net.feliscape.darkwastes.item;

import net.feliscape.darkwastes.Darkwastes;
import net.feliscape.darkwastes.item.custom.FuelItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Darkwastes.MOD_ID);

    public static final RegistryObject<Item> ASH = ITEMS.register("ash",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FERVOR_SHARDS = ITEMS.register("fervor_shards",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PEAT_BREAD = ITEMS.register("peat_bread",
            () -> new Item(new Item.Properties().food(ModFoods.PEAT_BREAD)));
    public static final RegistryObject<Item> EMBERBERRY = ITEMS.register("emberberry",
            () -> new Item(new Item.Properties().food(ModFoods.EMBERBERRY)));

    public static final RegistryObject<Item> TWIG = ITEMS.register("twig",
            () -> new FuelItem(new Item.Properties(), 200));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
