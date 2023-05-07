package com.mikanbox55.sampleworld;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class SampleDimension {
    public SampleDimension (String modid, List<DeferredRegister<?>> forgeregistries) {
        ResourceLocation DIM_ID = new ResourceLocation(modid,
                "sample_world_location");
        DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, modid);
        RegistryObject<Biome> BIOME = BIOMES.register(
            DIM_ID.getPath(),
            () -> new Biome.BiomeBuilder()
                    .precipitation(Biome.Precipitation.RAIN)
                    .temperature(0.5F)
                    .downfall(0.5F)
                    .biomeCategory(Biome.BiomeCategory.FOREST)
                    .mobSpawnSettings(MobSpawnSettings.EMPTY)
                    .specialEffects(new BiomeSpecialEffects.Builder()
                        .skyColor(8103167)
                        .fogColor(12638463)
                        .waterColor(4445678)
                        .waterFogColor(270131)
                        .build())
                    .generationSettings(BiomeGenerationSettings.EMPTY)
                    .build()
        );
        forgeregistries.add(BIOMES);
    }
}
