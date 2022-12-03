package com.mikanbox55.sampleworld;


import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import java.util.ArrayList;
import java.util.List;


public class Register {
    public static List<DeferredRegister<?>> FORGEREGISTRIES = new ArrayList<>();
    private static final DeferredRegister<Biome> BIOMES = register(DeferredRegister.create(ForgeRegistries.BIOMES, EntryPoint.MODID));

//    private static final DeferredRegister<DimensionType> DIMENSION_TYPE = register();



    public static final RegistryObject<Biome> BIOME = BIOMES.register(
            EntryPoint.DIM_ID.getPath(),
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


    //    登録は後で一括で行う
    private static <T> DeferredRegister<T> register(DeferredRegister<T> registry) {
        FORGEREGISTRIES.add(registry);
        return registry;
    }
}
