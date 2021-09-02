package com.khorbos.oreseverywhere.common.world.dimensions;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

public class MiningWorldBiomeProviderSettings implements IBiomeProviderSettings {
    private final long seed;
    private final WorldType worldType;
    private MiningWorldGenSettings generatorSettings = new MiningWorldGenSettings();

    public MiningWorldBiomeProviderSettings(WorldInfo info) {
        this.seed = info.getSeed();
        this.worldType = info.getGenerator();
    }

    public MiningWorldBiomeProviderSettings setGeneratorSettings(MiningWorldGenSettings settings) {
        this.generatorSettings = settings;
        return this;
    }

    public long getSeed() {
        return this.seed;
    }

    public WorldType getWorldType() {
        return this.worldType;
    }

    public MiningWorldGenSettings getGeneratorSettings() {
        return this.generatorSettings;
    }
}
