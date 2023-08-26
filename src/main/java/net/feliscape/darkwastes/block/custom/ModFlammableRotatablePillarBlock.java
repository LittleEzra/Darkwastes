package net.feliscape.darkwastes.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModFlammableRotatablePillarBlock extends RotatedPillarBlock {
    private int flammability;
    private int encouragement;

    public ModFlammableRotatablePillarBlock(Properties pProperties, int flammability, int encouragement) {
        super(pProperties);
        this.flammability = flammability;
        this.encouragement = encouragement;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return flammability;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return encouragement;
    }
}
