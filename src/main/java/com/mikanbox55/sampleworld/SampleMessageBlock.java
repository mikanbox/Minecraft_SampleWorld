package com.mikanbox55.sampleworld;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class SampleMessageBlock {
    public SampleMessageBlock (String modid, List<DeferredRegister<?>> forgeregistries) {

        DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, modid);
        RegistryObject<SampleMessageBlockEntity> BLOCK = BLOCKS.register("samplemessageblock",
                SampleMessageBlockEntity::new
        );
        forgeregistries.add(BLOCKS);

        DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, modid);
        ITEMS.register("samplemessageblock", () -> new BlockItem(
                BLOCK.get(),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)) );
        forgeregistries.add(ITEMS);
    }
}
