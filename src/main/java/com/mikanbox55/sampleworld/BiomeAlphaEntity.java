package com.mikanbox55.sampleworld;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;

import javax.swing.text.StyleConstants;

public class BiomeAlphaEntity {
    public static Biome decorateBiome() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeFeatures = new BiomeGenerationSettings.Builder();

        spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 3));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 5, 2, 6));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 80, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 95, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 90, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 85, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 100, 4, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 7, 1, 4));
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
        spawnSettings.addSpawn(MobCategory.AXOLOTLS, new MobSpawnSettings.SpawnerData(EntityType.AXOLOTL, 30, 1, 3));

        // I really now hate feature cycle in 1.18... is there anything providing a feature cycle documentation?

        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeFeatures);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeFeatures);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeFeatures);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeFeatures);
        BiomeDefaultFeatures.addDefaultSprings(biomeFeatures);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeFeatures);

        BiomeDefaultFeatures.addDefaultOres(biomeFeatures);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeFeatures);

        BiomeDefaultFeatures.addForestFlowers(biomeFeatures);
        BiomeDefaultFeatures.addWaterTrees(biomeFeatures);
        BiomeDefaultFeatures.addGroveTrees(biomeFeatures);

        BiomeDefaultFeatures.addFerns(biomeFeatures);

        BiomeDefaultFeatures.addMossyStoneBlock(biomeFeatures);

        BiomeDefaultFeatures.addMushroomFieldVegetation(biomeFeatures);
        BiomeDefaultFeatures.addMeadowVegetation(biomeFeatures);

        BiomeDefaultFeatures.addDefaultMushrooms(biomeFeatures);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeFeatures);
        BiomeDefaultFeatures.addCommonBerryBushes(biomeFeatures);
        BiomeDefaultFeatures.addJungleMelons(biomeFeatures);


//        return new Biome.BiomeBuilder()
//                .precipitation(Biome.Precipitation.RAIN)
//                .temperature(0.5F)
//                .downfall(0.5F)
//                .biomeCategory(Biome.BiomeCategory.FOREST)
//                .mobSpawnSettings(MobSpawnSettings.EMPTY)
//                .specialEffects(new BiomeSpecialEffects.Builder()
//                        .skyColor(8103167)
//                        .fogColor(12638463)
//                        .waterColor(4445678)
//                        .waterFogColor(270131)
//                        .build())
//                .generationSettings(BiomeGenerationSettings.EMPTY)
//                .build();

        return biome(Biome.Precipitation.RAIN, 0.5F, 0.7F,
                0x3F76E4,
                0x050533,
                0x33FF68,
                0x45F396, spawnSettings, biomeFeatures);
    }

    private static Biome biome(Biome.Precipitation precipitation, float temperature, float downfall, int waterColor, int waterFogColor, int grassColor, int foliageColor, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder)
    {
        return (new Biome.BiomeBuilder())
                .precipitation(precipitation)
                .temperature(temperature)
                .downfall(0.5F)
                .biomeCategory(Biome.BiomeCategory.FOREST)
//                .specialEffects(new BiomeSpecialEffects.Builder()
//                        .skyColor(getSkyColorWithTemperatureModifier(temperature))
//                        .fogColor(12638463)
//                        .waterColor(waterColor)
//                        .waterFogColor(waterFogColor)
//                        .build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(waterColor)
                        .waterFogColor(waterFogColor)
                        .fogColor(12638463)
                        .skyColor(getSkyColorWithTemperatureModifier(temperature))
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .foliageColorOverride(foliageColor)
                        .grassColorOverride(grassColor)
                        .build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }
    private static int getSkyColorWithTemperatureModifier(float temperature) {
        float f = temperature / 3.0F;
        f = Mth.clamp(f, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.6325F - f * 0.1F, 0.44F + f * 0.11F, 1F);
    }
}
