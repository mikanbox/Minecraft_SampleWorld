package com.mikanbox55.sampleworld;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class BiomeAlpha {

    public static final ResourceKey<Biome> BIOME_ALPHA = register("biome_alpha");
    private static ResourceKey<Biome> register(String name)
    {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(EntryPoint.MODID, name));
    }

    public BiomeAlpha (String modid, List<DeferredRegister<?>> forgeregistries) {
        DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, modid);
        ResourceLocation DIMENSION_ID = new ResourceLocation(modid,
                "sample_world_location");

        BIOMES.register(BIOME_ALPHA.location().getPath(), BiomeAlphaEntity::decorateBiome);
        forgeregistries.add(BIOMES);
    }

}
