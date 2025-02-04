package vazkii.botania.forge.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.MinecraftForge;

import vazkii.botania.api.BotaniaForgeClientCapabilities;
import vazkii.botania.api.block.IWandHUD;
import vazkii.botania.api.item.TinyPotatoRenderEvent;
import vazkii.botania.forge.CapabilityUtil;
import vazkii.botania.forge.network.ForgePacketHandler;
import vazkii.botania.network.IPacket;
import vazkii.botania.xplat.IClientXplatAbstractions;

import javax.annotation.Nullable;

import java.util.Random;

public class ForgeClientXplatImpl implements IClientXplatAbstractions {
	@Override
	public void fireRenderTinyPotato(BlockEntity potato, Component name, float tickDelta, PoseStack ms, MultiBufferSource buffers, int light, int overlay) {
		MinecraftForge.EVENT_BUS.post(new TinyPotatoRenderEvent(potato, name, tickDelta, ms, buffers, light, overlay));
	}

	@Override
	public void sendToServer(IPacket packet) {
		ForgePacketHandler.CHANNEL.sendToServer(packet);
	}

	@Nullable
	@Override
	public IWandHUD findWandHud(Level level, BlockPos pos, BlockState state, @Nullable BlockEntity be) {
		return CapabilityUtil.findCapability(BotaniaForgeClientCapabilities.WAND_HUD, level, pos, state, be);
	}

	@Override
	public BakedModel wrapPlatformModel(BakedModel original) {
		return new ForgePlatformModel(original);
	}

	@Override
	public void setFilterSave(AbstractTexture texture, boolean filter, boolean mipmap) {
		texture.setBlurMipmap(filter, mipmap);
	}

	@Override
	public void restoreLastFilter(AbstractTexture texture) {
		texture.restoreLastBlurMipmap();
	}

	@Override
	public void tessellateBlock(Level level, BlockState state, BlockPos pos, PoseStack ps, MultiBufferSource buffers, int overlay) {
		var renderer = Minecraft.getInstance().getBlockRenderer();
		for (RenderType type : RenderType.chunkBufferLayers()) {
			if (ItemBlockRenderTypes.canRenderInLayer(state, type)) {
				ForgeHooksClient.setRenderType(type);
				renderer.getModelRenderer().tesselateBlock(level, renderer.getBlockModel(state),
						state, pos, ps, buffers.getBuffer(type), false, new Random(),
						state.getSeed(pos), overlay);
			}
		}
		ForgeHooksClient.setRenderType(null);
	}
}
