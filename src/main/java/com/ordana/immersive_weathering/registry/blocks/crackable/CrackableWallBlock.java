package com.ordana.immersive_weathering.registry.blocks.crackable;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CrackableWallBlock extends CrackedWallBlock {

    public CrackableWallBlock(CrackLevel crackLevel, Settings settings) {
        super(crackLevel, settings);
        this.setDefaultState(this.getDefaultState().with(WEATHERABLE, WeatheringState.FALSE));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        return super.getOutlineShape(state.with(WEATHERABLE, WeatheringState.FALSE), getter, pos, context);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView getter, BlockPos pos, ShapeContext context) {
        return super.getCollisionShape(state.with(WEATHERABLE, WeatheringState.FALSE), getter, pos, context);
    }

    @Override
    public boolean isWeatherable(BlockState state) {
        return state.contains(WEATHERABLE) && state.get(WEATHERABLE).isWeatherable();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateBuilder) {
        super.appendProperties(stateBuilder);
        stateBuilder.add(WEATHERABLE);
    }
    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos neighbor, boolean isMoving) {
        super.neighborUpdate(state, world, pos, block, neighbor,true);
        this.updateWeatheredStateOnNeighborChanged(state, world, pos);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext placeContext) {
        BlockState state = super.getPlacementState(placeContext);
        return getWeatheredStateForPlacement(state, placeContext.getBlockPos(), placeContext.getWorld());
    }

    @Override
    public void randomTick(BlockState state, ServerWorld serverWorld, BlockPos pos, net.minecraft.util.math.random.Random random) {
        this.tryWeather(state, serverWorld, pos, random);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, net.minecraft.util.math.random.Random random) {
        world.updateNeighbors(pos, this);
    }
}