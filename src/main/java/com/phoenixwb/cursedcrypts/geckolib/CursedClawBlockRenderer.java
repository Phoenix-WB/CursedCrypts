package com.phoenixwb.cursedcrypts.geckolib;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.phoenixwb.cursedcrypts.blockentity.CursedClawBlockEntity;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class CursedClawBlockRenderer extends GeoBlockRenderer<CursedClawBlockEntity> {
	public CursedClawBlockRenderer(Context rendererDispatcherIn) {
		super(rendererDispatcherIn, new CursedClawBlockModel());
	}

	@Override
	public RenderType getRenderType(CursedClawBlockEntity animatable, float partialTicks, PoseStack stack,
			@Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
