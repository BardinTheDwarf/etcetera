package com.ninni.etcetera;

import com.google.common.reflect.Reflection;
import com.ninni.etcetera.block.EtceteraBlocks;
import com.ninni.etcetera.block.entity.EtceteraBlockEntityType;
import com.ninni.etcetera.client.TidalHelmetHud;
import com.ninni.etcetera.client.model.EtceteraEntityModelLayers;
import com.ninni.etcetera.client.renderer.block.entity.ItemStandBlockEntityRenderer;
import com.ninni.etcetera.client.renderer.entity.TidalArmorRenderer;
import com.ninni.etcetera.client.renderer.entity.TurtleRaftRenderer;
import com.ninni.etcetera.entity.EtceteraEntityType;
import com.ninni.etcetera.item.EtceteraItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class EtceteraClient implements ClientModInitializer {

	@Override
	@SuppressWarnings("UnstableApiUsage")
	public void onInitializeClient() {
		BlockEntityRendererRegistry.register(EtceteraBlockEntityType.ITEM_STAND, ItemStandBlockEntityRenderer::new);

		ArmorRenderer.register(new TidalArmorRenderer(), EtceteraItems.TIDAL_HELMET);
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
			EtceteraBlocks.IRIDESCENT_GLASS
		);

		Reflection.initialize(EtceteraEntityModelLayers.class);
		EntityRendererRegistry.register(EtceteraEntityType.TURTLE_RAFT, TurtleRaftRenderer::new);

		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
			EtceteraBlocks.BISMUTH_BARS,
			EtceteraBlocks.COMPACTED_DRIPSTONE,
			EtceteraBlocks.BOUQUET,
			EtceteraBlocks.POTTED_BOUQUET,
			EtceteraBlocks.ITEM_STAND,
			EtceteraBlocks.FRAME
		);
		TidalHelmetHud.init();
	}
}