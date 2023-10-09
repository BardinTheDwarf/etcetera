package com.ninni.etcetera.registry;

import com.ninni.etcetera.block.enums.DrumType;
import com.ninni.etcetera.block.enums.LightBulbBrightness;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;

public interface EtceteraProperties {
    EnumProperty<DrumType> DRUM_TYPE = EnumProperty.of("type", DrumType.class);
    EnumProperty<LightBulbBrightness> BRIGHTNESS = EnumProperty.of("brightness", LightBulbBrightness.class);
    BooleanProperty GLASS = BooleanProperty.of("glass");
    IntProperty SOLID = IntProperty.of("solid", 1, 3);
}