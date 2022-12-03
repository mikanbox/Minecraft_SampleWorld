package com.mikanbox55.sampleworld;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(EntryPoint.MODID)
public class EntryPoint {
    public static final String MODID = "sampleworld";
    public static final ResourceLocation DIM_ID = new ResourceLocation(MODID, "sample_world_location");

    public EntryPoint() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        Register.FORGEREGISTRIES.forEach(item -> item.register(bus));
    }

}
