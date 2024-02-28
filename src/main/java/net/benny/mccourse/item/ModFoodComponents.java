package net.benny.mccourse.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().hunger(4).saturationModifier(0.5f).
            statusEffect(new StatusEffectInstance(StatusEffects.GLOWING),0.25f).build();
    public static final FoodComponent BAKED_CAULIFLOWER = new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).
            statusEffect(new StatusEffectInstance(StatusEffects.GLOWING),0.5f).build();

    public static final FoodComponent SALTED_CAULIFLOWER = new FoodComponent.Builder().hunger(8).saturationModifier(0.8f).
            statusEffect(new StatusEffectInstance(StatusEffects.GLOWING),0.75f).
            statusEffect(new StatusEffectInstance(StatusEffects.GLOWING),1.0f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 2),1.0f)
    .build();
}
