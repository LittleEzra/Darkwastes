package net.feliscape.darkwastes.level.levelgen.feature.placers;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class CharredTrunkPlacer extends TrunkPlacer {
    public static final Codec<CharredTrunkPlacer> CODEC = RecordCodecBuilder.create((trunkPlacerInstance) -> {
        return trunkPlacerParts(trunkPlacerInstance).apply(trunkPlacerInstance, CharredTrunkPlacer::new);
    });

    public CharredTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return TrunkPlacerType.STRAIGHT_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom,
                                                            int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {
        setDirtAt(pLevel, pBlockSetter, pRandom, pPos.below(), pConfig);

        for(int i = 0; i < pFreeTreeHeight; ++i) {
            this.placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);
            // Check if we should place a branch
            if (i > 2 && pRandom.nextDouble() * i / pFreeTreeHeight < 0.25f){
                // Get a random horizontal direction
                Direction direction = Direction.get(pRandom.nextBoolean() ? Direction.AxisDirection.POSITIVE : Direction.AxisDirection.NEGATIVE,
                        pRandom.nextBoolean() ? Direction.Axis.X : Direction.Axis.Z);
                // Place branch in direction
                int branchSize = pRandom.nextInt(1, 3);

                for (int branchI = 0; branchI < branchSize; branchI++){
                    this.placeLog(pLevel, pBlockSetter, pRandom, pPos.relative(direction, branchI), pConfig);
                }
            }
        }

        return ImmutableList.of();
    }
}
