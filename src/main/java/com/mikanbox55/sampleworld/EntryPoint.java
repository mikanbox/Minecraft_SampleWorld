package com.mikanbox55.sampleworld;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(EntryPoint.MODID)
public class EntryPoint {
    public static final String MODID = "sampleworld";
    public static List<DeferredRegister<?>> FORGEREGISTRIES = new ArrayList<>();
    private static final Logger LOGGER = LogManager.getLogger();


    public EntryPoint() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        new com.mikanbox55.sampleworld.SampleDimension(MODID, FORGEREGISTRIES);
        new com.mikanbox55.sampleworld.SampleBlock(MODID, FORGEREGISTRIES);
        new com.mikanbox55.sampleworld.SamplePortalBlock(MODID, FORGEREGISTRIES);
        new com.mikanbox55.sampleworld.SampleMessageBlock(MODID, FORGEREGISTRIES);
        new com.mikanbox55.sampleworld.BiomeAlpha(MODID, FORGEREGISTRIES);


        FORGEREGISTRIES.forEach(item -> item.register(modEventBus));
    }


}
