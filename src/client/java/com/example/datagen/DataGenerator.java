package com.example.datagen;

import com.example.datagen.providers.modidModelProvider;
import com.example.datagen.providers.modidRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(modidModelProvider::new);
        pack.addProvider(modidRecipeProvider::new);
    }
}
