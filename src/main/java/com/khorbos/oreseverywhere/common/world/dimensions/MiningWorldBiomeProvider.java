package com.khorbos.oreseverywhere.common.world.dimensions;

import com.google.common.collect.ImmutableSet;
import com.khorbos.oreseverywhere.core.registries.Registries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MiningWorldBiomeProvider extends BiomeProvider {
    private static final Set<Biome> biomeList = ImmutableSet.of(Registries.IRON_BIOME.get(), Registries.COPPER_BIOME.get(), Registries.COAL_BIOME.get());
    private Random rand;
    private final double biomeSize = 16.0D;
    private VoronoiGenerator biomeNoise;

    public MiningWorldBiomeProvider(MiningWorldBiomeProviderSettings settings) {
        super(biomeList);
        rand = new Random();
        this.biomeNoise = new VoronoiGenerator();
        this.biomeNoise.setSeed((int) settings.getSeed());
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return getBiome(new LinkedList<Biome>(biomeList),
                biomeNoise.getValue((double) x / biomeSize, (double) y / biomeSize, (double) z / biomeSize));
    }

    public Biome getBiome(List<Biome> biomeList, double noiseVal) {
        for (int i = biomeList.size(); i >= 0; i--) {
            if (noiseVal > (2.0f / biomeList.size()) * i - 1)
                return biomeList.get(i);
        }
        return biomeList.get(biomeList.size() - 1);
    }
}
