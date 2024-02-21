package net.benny.mccourse.block.custom;

import net.benny.mccourse.MCCourseMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SoundBlock extends Block {

    boolean boopOnce = true;
    public SoundBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        /*if(world.isClient()){
            if(hand == Hand.MAIN_HAND){
                MCCourseMod.LOGGER.info("CLIENT | MAIN HAND");
            }
            else{
                MCCourseMod.LOGGER.info("CLIENT | OFF HAND");
            }
        } else{
            if(hand == Hand.MAIN_HAND){
                MCCourseMod.LOGGER.info("SERVER | MAIN HAND");
            } else{
                MCCourseMod.LOGGER.info("SERVER | OFF HAND");
            }
        }*/

        if(player.isSneaking()) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BANJO.value(), SoundCategory.BLOCKS, 1f, 1f);
            return ActionResult.SUCCESS;
        } else{
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_COW_BELL.value(), SoundCategory.BLOCKS, 1f, 1f);
            return ActionResult.CONSUME;
        }

        //return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(boopOnce){
            world.playSound(entity, pos, SoundEvents.BLOCK_NOTE_BLOCK_BIT.value(), SoundCategory.BLOCKS, 1f, 1f);
            boopOnce = false;
        }

        super.onSteppedOn(world, pos, state, entity);
        boopOnce = true;

    }

}
