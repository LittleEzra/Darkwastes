package net.feliscape.darkwastes.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties PEAT_BREAD = new FoodProperties.Builder().nutrition(7)
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 0.75f).build();
    public static final FoodProperties EMBERBERRY = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600), 1.0F).build();
}
