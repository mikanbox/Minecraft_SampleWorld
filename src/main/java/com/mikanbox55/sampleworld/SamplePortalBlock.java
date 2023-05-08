package com.mikanbox55.sampleworld;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class SamplePortalBlock {
    public SamplePortalBlock (String modid, List<DeferredRegister<?>> forgeregistries) {


        DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, modid);
        RegistryObject<SamplePortalBlockEntity> BLOCK = BLOCKS.register("sampleportalblock",
                SamplePortalBlockEntity::new
        );


        forgeregistries.add(BLOCKS);

        DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, modid);
        RegistryObject<BlockItem> EXAMPLE_ITEM = ITEMS.register("sampleportalblock", () -> new BlockItem(
                BLOCK.get(),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)) );
        forgeregistries.add(ITEMS);
    }
}
