package com.ordana.immersive_weathering.registry;

import com.ordana.immersive_weathering.ImmersiveWeathering;
import com.ordana.immersive_weathering.registry.features.*;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;

public class ModFeatures {
    public static void registerFeatures() {
        Registry.register(Registry.FEATURE, "immersive_weathering:icicle_cluster", new IcicleClusterFeature(IcicleClusterFeatureConfig.CODEC));


        RegistryKey<PlacedFeature> icicles = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("immersive_weathering", "icicles"));
        if(ImmersiveWeathering.getConfig().worldgenConfig.icicleFeature) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.ICY), GenerationStep.Feature.TOP_LAYER_MODIFICATION, icicles);
        }

        RegistryKey<PlacedFeature> cryosol_patch = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("immersive_weathering", "cryosol_patch"));
        if(ImmersiveWeathering.getConfig().worldgenConfig.cryosolFeature) {
            BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.ICY), GenerationStep.Feature.RAW_GENERATION, cryosol_patch);
        }

        RegistryKey<PlacedFeature> humus_patch = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("immersive_weathering", "humus_patch"));
        if(ImmersiveWeathering.getConfig().worldgenConfig.humusFeature) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST), GenerationStep.Feature.RAW_GENERATION, humus_patch);
        }

        RegistryKey<PlacedFeature> rooted_ceiling = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("immersive_weathering", "rooted_ceiling"));
        if(ImmersiveWeathering.getConfig().worldgenConfig.rootsFeature) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, rooted_ceiling);
        }

        RegistryKey<PlacedFeature> fluvisol_patch_submerged = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("immersive_weathering", "fluvisol_patch_submerged"));
        RegistryKey<PlacedFeature> fluvisol_patch_surface = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("immersive_weathering", "fluvisol_patch_surface"));
        RegistryKey<PlacedFeature> fluvisol_patch_dry = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("immersive_weathering", "fluvisol_patch_dry"));
        if(ImmersiveWeathering.getConfig().worldgenConfig.fluvisolFeature) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), GenerationStep.Feature.RAW_GENERATION, fluvisol_patch_dry);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), GenerationStep.Feature.RAW_GENERATION, fluvisol_patch_surface);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), GenerationStep.Feature.RAW_GENERATION, fluvisol_patch_submerged);
        }

        RegistryKey<PlacedFeature> silt_disk = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("immersive_weathering", "silt_disk"));
        if(ImmersiveWeathering.getConfig().worldgenConfig.siltFeature) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), GenerationStep.Feature.RAW_GENERATION, silt_disk);
        }

        RegistryKey<PlacedFeature> dry_lakebed = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("immersive_weathering", "dry_lakebed"));
        RegistryKey<PlacedFeature> dry_lakebed_large = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("immersive_weathering", "dry_lakebed_large"));
        if(ImmersiveWeathering.getConfig().worldgenConfig.lakebedFeature) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BADLANDS, BiomeKeys.ERODED_BADLANDS, BiomeKeys.WOODED_BADLANDS, BiomeKeys.DESERT), GenerationStep.Feature.RAW_GENERATION, dry_lakebed_large);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BADLANDS, BiomeKeys.ERODED_BADLANDS, BiomeKeys.WOODED_BADLANDS, BiomeKeys.DESERT), GenerationStep.Feature.RAW_GENERATION, dry_lakebed);
        }

        RegistryKey<PlacedFeature> vertisol_patch = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("immersive_weathering", "vertisol_patch"));
        if(ImmersiveWeathering.getConfig().worldgenConfig.vertisolFeature) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BADLANDS, BiomeKeys.ERODED_BADLANDS, BiomeKeys.WOODED_BADLANDS), GenerationStep.Feature.RAW_GENERATION, vertisol_patch);
        }

        RegistryKey<PlacedFeature> oak_leaf_pile = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("immersive_weathering", "oak_leaf_pile"));
        if(ImmersiveWeathering.getConfig().worldgenConfig.oakLeavesFeature) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST), GenerationStep.Feature.VEGETAL_DECORATION, oak_leaf_pile);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.WINDSWEPT_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, oak_leaf_pile);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, oak_leaf_pile);
        }

        RegistryKey<PlacedFeature> ivy_patch = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("immersive_weathering", "ivy_patch"));
        if(ImmersiveWeathering.getConfig().worldgenConfig.ivyFeature) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST), GenerationStep.Feature.VEGETAL_DECORATION, ivy_patch);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.WINDSWEPT_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, ivy_patch);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, ivy_patch);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, ivy_patch);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, ivy_patch);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, ivy_patch);
        }

        RegistryKey<PlacedFeature> dark_oak_leaf_pile = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("immersive_weathering", "dark_oak_leaf_pile"));
        if(ImmersiveWeathering.getConfig().worldgenConfig.darkLeavesFeature) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, dark_oak_leaf_pile);
        }

        RegistryKey<PlacedFeature> birch_leaf_pile = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("immersive_weathering", "birch_leaf_pile"));
        if(ImmersiveWeathering.getConfig().worldgenConfig.birchLeavesFeature) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, birch_leaf_pile);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, birch_leaf_pile);
        }

        RegistryKey<PlacedFeature> spruce_leaf_pile = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("immersive_weathering", "spruce_leaf_pile"));
        if(ImmersiveWeathering.getConfig().worldgenConfig.spruceLeavesFeature) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA), GenerationStep.Feature.VEGETAL_DECORATION, spruce_leaf_pile);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_PINE_TAIGA), GenerationStep.Feature.VEGETAL_DECORATION, spruce_leaf_pile);
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.TAIGA), GenerationStep.Feature.VEGETAL_DECORATION, spruce_leaf_pile);
        }

        RegistryKey<PlacedFeature> quicksand_pool = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("immersive_weathering", "quicksand_pool"));
        if(ImmersiveWeathering.getConfig().worldgenConfig.quicksandFeature) {
            BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DESERT), GenerationStep.Feature.SURFACE_STRUCTURES, quicksand_pool);
        }
    }
}
