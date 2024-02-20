package net.benny.mccourse.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            int scannerRange = 20;
            boolean foundBlock = false;

            for(int i = positionClicked.getY(); i == 0 || i >= positionClicked.getY() - scannerRange; i--){
                BlockState state = context.getWorld().getBlockState(positionClicked.down(positionClicked.getY() - i + 1));
                Block block = state.getBlock();

                if(isValuableBlock(state)){
                    outputValuableCoordinates(positionClicked.down(positionClicked.getY() - i + 1), player, block);
                    foundBlock = true;
                    break;

                }
            }
            if (!foundBlock){
                player.sendMessage(Text.translatable("item.mccourse.metal_detector.no_valuables"));
            }

            context.getStack().damage(1,context.getPlayer(),
                    playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        }

        return ActionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos position, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Valuable found " +block.getName().getString() + " @ " + position.getX() + " " + position.getY() + " " + position.getZ()));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.getBlock() == Blocks.IRON_ORE || state.getBlock() == Blocks.GOLD_ORE || state.getBlock() == Blocks.DIAMOND_ORE || state.getBlock() == Blocks.REDSTONE_ORE;
    }
}
