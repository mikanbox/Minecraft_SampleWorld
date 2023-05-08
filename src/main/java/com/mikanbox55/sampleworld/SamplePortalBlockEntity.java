package com.mikanbox55.sampleworld;

import com.mikanbox55.sampleworld.operations.SimpleTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class SamplePortalBlockEntity extends Block implements EntityBlock {


    public SamplePortalBlockEntity() {
        super(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops());
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide()) {
            player.sendMessage(new TextComponent("Server teleport call "  + UUID.randomUUID()), UUID.randomUUID());


            ResourceKey<Level> toWorldKey = level.dimension().location().equals(Level.OVERWORLD) ? Level.OVERWORLD : Level.NETHER;
            ServerLevel destinationWorld = player.getServer().getLevel(toWorldKey);

            player.changeDimension(destinationWorld,
                    new SimpleTeleporter(
                            new PortalInfo(new Vec3(pos.getX()+0, pos.getY()+5, pos.getZ()+0.5), Vec3.ZERO, 0, 90)
                    )
            );

        }

        return InteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockpos, BlockState blockstate) {
        return null;
    }


}
