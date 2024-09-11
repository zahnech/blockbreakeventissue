package com.example.blockbreakevent.event;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlockBreakingHandler implements AttackBlockCallback, PlayerBlockBreakEvents.Canceled, PlayerBlockBreakEvents.After{
    static boolean isBreakingBlock = false;
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, BlockPos pos, Direction direction) {
        if (!world.isClient()) {
            player.sendMessage(Text.literal(player.getName().getString() + " started breaking a block (AttackBlockCallback)"));
            isBreakingBlock = true;
        }
        return ActionResult.PASS;
    }

    @Override
    public void onBlockBreakCanceled(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity) {
        if (!world.isClient()) {
            player.sendMessage(Text.literal(player.getName().getString() + " stopped breaking a block (PlayerBlockBreakEvents.Canceled)"));
            isBreakingBlock = false;
        }
    }


    @Override
    public void afterBlockBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity) {
        if (!world.isClient()) {
            player.sendMessage(Text.literal(player.getName().getString() + " finished breaking a block (PlayerBlockBreakEvents.After)"));
            isBreakingBlock = false;
        }
    }
}
