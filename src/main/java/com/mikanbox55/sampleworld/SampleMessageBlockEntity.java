package com.mikanbox55.sampleworld;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class SampleMessageBlockEntity  extends Block implements EntityBlock {
    public SampleMessageBlockEntity() {
        super(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops());
    }

    // This method is called twice in client and server side.
    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide()) {
            player.sendMessage(new TextComponent("Touch block server " + UUID.randomUUID()), UUID.randomUUID());
        } else {
            player.sendMessage(new TextComponent("Touch block client " + UUID.randomUUID()), UUID.randomUUID());
        }

        return InteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockpos, BlockState blockstate) {
        return null;
    }

}
