package net.benny.mccourse.block.custom;

import net.benny.mccourse.MCCourseMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.Biome;

import java.util.List;

public class SoundBlock extends Block {

    public static final BooleanProperty STEPPED_ONCE = BooleanProperty.of("stepped_on");


    public SoundBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(STEPPED_ONCE, false));
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
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STEPPED_ONCE);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(!state.get(STEPPED_ONCE)){
            world.playSound(entity, pos, SoundEvents.BLOCK_NOTE_BLOCK_BIT.value(), SoundCategory.BLOCKS, 1f, 1f);
            world.setBlockState(pos,state.with(STEPPED_ONCE,true));
            world.scheduleBlockTick(pos,this,10);
        }

        super.onSteppedOn(world, pos, state, entity);

    }

    private static boolean almostEqual(double a, double b, double eps){
        return Math.abs(a-b)<eps;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(state.get(STEPPED_ONCE)){
            List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, new Box(pos.getX()-10,pos.getY()-10,pos.getZ()-10,pos.getX()+10,pos.getY()+10,pos.getZ()+10), EntityPredicates.VALID_ENTITY);
            LivingEntity entity = world.getClosestEntity(entities,TargetPredicate.DEFAULT, null, pos.getX(), pos.getY(), pos.getZ());

            if (entity == null){
                entity = world.getClosestEntity(entities,TargetPredicate.createNonAttackable(), null, pos.getX(), pos.getY(), pos.getZ());
                MCCourseMod.LOGGER.info("2nd check");
            }

            if (entity == null){
                return;
            }

            //mby calculate vector instead of flat coords - could work better


            if(!almostEqual(pos.getX(),entity.getX(),1.3) || !almostEqual(pos.getY(),entity.getY() - 1,0.5) || !almostEqual(pos.getZ(),entity.getZ(),1.3)){
                MCCourseMod.LOGGER.info(pos.getX() + " " + pos.getY() + " " + pos.getZ() + "||" + entity.getX() + " " + entity.getY() + " " + entity.getZ());
                world.setBlockState(pos,state.with(STEPPED_ONCE,false));
            }
            else{
                world.scheduleBlockTick(pos,this,10);
            }

        }
        super.scheduledTick(state, world, pos, random);
    }
}
//getEntitiesByClass(LivingEntity.class,new Box(pos),LivingEntity::isOnGround).isEmpty()

