package net.benny.mccourse.item.custom;

import com.google.common.collect.ImmutableMap;
import net.benny.mccourse.item.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.Map;

public class ModArmorItem extends ArmorItem {

    private static final StatusEffectInstance[] STATUS_EFFECTS_TO_ADD = {new StatusEffectInstance(StatusEffects.HASTE, 10, 1),
    new StatusEffectInstance(StatusEffects.REGENERATION,10,10)};
    private static  final Map<ArmorMaterial, StatusEffectInstance[]> MATERIAL_TO_EFFECT_MAP =
            new ImmutableMap.Builder<ArmorMaterial,StatusEffectInstance[]>()
                    .put(ModArmorMaterials.PINK_GARNET, STATUS_EFFECTS_TO_ADD).build();
    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        if(!world.isClient && entity instanceof LivingEntity current_entity){
            if(hasFullSuitOfArmorOn(current_entity)){
                System.out.println("Full suit of armor detected");
                evaluateArmorEffects(current_entity);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(LivingEntity currentEntity) {
        for(Map.Entry<ArmorMaterial,StatusEffectInstance[]> entry : MATERIAL_TO_EFFECT_MAP.entrySet()){
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance[] mapStatusEffects = entry.getValue();
            if(hasMatchingArmorOn(mapArmorMaterial,currentEntity)){
                
            }
        }
    }

    private boolean hasMatchingArmorOn(ArmorMaterial mapArmorMaterial, LivingEntity currentEntity) {
        for(ItemStack armorStack : currentEntity.getArmorItems()){
            if(!(armorStack.getItem() instanceof ArmorItem)){
                return false;
            }
        }
        Iterable<ItemStack> equippedArmor = currentEntity.getArmorItems();
        ArmorItem boots = getArmorInSlot(equippedArmor,0);
        ArmorItem pants = getArmorInSlot(equippedArmor,1);
        ArmorItem chest = getArmorInSlot(equippedArmor,2);
        ArmorItem hat = getArmorInSlot(equippedArmor,3);

        assert chest != null;
        if (chest.getMaterial() != mapArmorMaterial) return false;
        assert hat != null;
        if (hat.getMaterial() != mapArmorMaterial) return false;
        assert pants != null;
        if (pants.getMaterial() != mapArmorMaterial) return false;
        assert boots != null;
        return boots.getMaterial() == mapArmorMaterial;
    }

    private boolean hasFullSuitOfArmorOn(LivingEntity currentEntity) {
        Iterable<ItemStack> equippedArmor = currentEntity.getArmorItems();

        return !(getArmorInSlot(equippedArmor,0)==null) && !(getArmorInSlot(equippedArmor,1)==null)
                && !(getArmorInSlot(equippedArmor,2)==null) && !(getArmorInSlot(equippedArmor,3)==null);
    }


    private ArmorItem getArmorInSlot(Iterable<ItemStack> armorStack, int slot){
        int i = 0;
        Iterator<ItemStack> iterator = armorStack.iterator();
        ItemStack equippedPiece = iterator.next();
        if (slot==0){
            if(equippedPiece.getItem() instanceof ArmorItem){
                return (ArmorItem)equippedPiece.getItem();
            }
        }
        else{
            i++;
            while(i!=slot){
                equippedPiece = iterator.next();
                i++;
            }
            if(equippedPiece.getItem() instanceof ArmorItem){
                return (ArmorItem)equippedPiece.getItem();
            }
        }
        return null;
    }


}
