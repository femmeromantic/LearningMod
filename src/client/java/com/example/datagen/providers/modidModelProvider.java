package com.example.datagen.providers;

import com.example.ExampleMod;
import com.example.blocks.ModBlocks;
import com.example.items.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class modidModelProvider extends FabricModelProvider {
    public modidModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PEANUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEANUT_BUTTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEANUT_BUTTER_CRUNCHY, Models.GENERATED);
    }

    @Override
    public String getName() {
        return ExampleMod.MOD_ID + "ModelProvider";
    }
}
