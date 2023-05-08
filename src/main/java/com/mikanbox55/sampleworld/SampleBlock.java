package com.mikanbox55.sampleworld;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class SampleBlock {
    public SampleBlock (String modid, List<DeferredRegister<?>> forgeregistries) {

        DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, modid);
        RegistryObject<Block> BLOCK = BLOCKS.register("sampleblock", () -> new Block(
                BlockBehaviour.Properties.of(Material.AMETHYST).
                        friction(0.5f).
                        strength(1f, 5f).
                        requiresCorrectToolForDrops()
                )
        );
        forgeregistries.add(BLOCKS);

        DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, modid);
        RegistryObject<BlockItem> EXAMPLE_ITEM = ITEMS.register("sampleblock", () -> new BlockItem(
                BLOCK.get(),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)) );
        forgeregistries.add(ITEMS);
    }
}
