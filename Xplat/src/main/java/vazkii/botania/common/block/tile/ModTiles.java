/*
 * This class is distributed as part of the Botania Mod.
 * Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 */
package vazkii.botania.common.block.tile;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import vazkii.botania.api.block.IWandHUD;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.block.tile.corporea.*;
import vazkii.botania.common.block.tile.mana.*;
import vazkii.botania.common.block.tile.string.*;
import vazkii.botania.common.lib.LibBlockNames;
import vazkii.botania.xplat.IXplatAbstractions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import static vazkii.botania.common.block.ModBlocks.*;
import static vazkii.botania.common.lib.ResourceLocationHelper.prefix;

public class ModTiles {
	private static final Map<ResourceLocation, BlockEntityType<?>> ALL = new HashMap<>();
	public static final BlockEntityType<TileAltar> ALTAR = type(prefix(LibBlockNames.ALTAR), TileAltar::new,
			defaultAltar, forestAltar, plainsAltar, mountainAltar, fungalAltar,
			swampAltar, desertAltar, taigaAltar, mesaAltar, mossyAltar
	);
	public static final BlockEntityType<TileSpreader> SPREADER = type(prefix(LibBlockNames.SPREADER), TileSpreader::new, manaSpreader, redstoneSpreader, elvenSpreader, gaiaSpreader);
	public static final BlockEntityType<TilePool> POOL = type(prefix(LibBlockNames.POOL), TilePool::new, manaPool, dilutedPool, fabulousPool, creativePool);
	public static final BlockEntityType<TileRuneAltar> RUNE_ALTAR = type(prefix(LibBlockNames.RUNE_ALTAR), TileRuneAltar::new, runeAltar);
	public static final BlockEntityType<TilePylon> PYLON = type(prefix(LibBlockNames.PYLON), TilePylon::new, manaPylon, naturaPylon, gaiaPylon);
	public static final BlockEntityType<TileDistributor> DISTRIBUTOR = type(prefix(LibBlockNames.DISTRIBUTOR), TileDistributor::new, distributor);
	public static final BlockEntityType<TileEnchanter> ENCHANTER = type(prefix(LibBlockNames.ENCHANTER), TileEnchanter::new, enchanter);
	public static final BlockEntityType<TileTurntable> TURNTABLE = type(prefix(LibBlockNames.TURNTABLE), TileTurntable::new, turntable);
	public static final BlockEntityType<TileTinyPlanet> TINY_PLANET = type(prefix(LibBlockNames.TINY_PLANET), TileTinyPlanet::new, tinyPlanet);
	public static final BlockEntityType<TileOpenCrate> OPEN_CRATE = type(prefix(LibBlockNames.OPEN_CRATE), TileOpenCrate::new, openCrate);
	public static final BlockEntityType<TileCraftCrate> CRAFT_CRATE = type(prefix(LibBlockNames.CRAFT_CRATE), TileCraftCrate::new, craftCrate);
	public static final BlockEntityType<TileForestEye> FOREST_EYE = type(prefix(LibBlockNames.FOREST_EYE), TileForestEye::new, forestEye);
	public static final BlockEntityType<TilePlatform> PLATFORM = type(prefix(LibBlockNames.PLATFORM), TilePlatform::new, abstrusePlatform, spectralPlatform, infrangiblePlatform);
	public static final BlockEntityType<TileAlfPortal> ALF_PORTAL = type(prefix(LibBlockNames.ALF_PORTAL), TileAlfPortal::new, alfPortal);
	public static final BlockEntityType<TileBifrost> BIFROST = type(prefix(LibBlockNames.BIFROST), TileBifrost::new, bifrost);
	public static final BlockEntityType<TileFloatingFlower> MINI_ISLAND = type(prefix(LibBlockNames.MINI_ISLAND), TileFloatingFlower::new, Arrays.stream(DyeColor.values()).map(ModBlocks::getFloatingFlower).toArray(Block[]::new));
	public static final BlockEntityType<TileTinyPotato> TINY_POTATO = type(prefix(LibBlockNames.TINY_POTATO), TileTinyPotato::new, tinyPotato);
	public static final BlockEntityType<TileSpawnerClaw> SPAWNER_CLAW = type(prefix(LibBlockNames.SPAWNER_CLAW), TileSpawnerClaw::new, spawnerClaw);
	public static final BlockEntityType<TileEnderEye> ENDER_EYE = type(prefix(LibBlockNames.ENDER_EYE_BLOCK), TileEnderEye::new, enderEye);
	public static final BlockEntityType<TileStarfield> STARFIELD = type(prefix(LibBlockNames.STARFIELD), TileStarfield::new, starfield);
	public static final BlockEntityType<TileRFGenerator> FLUXFIELD = type(prefix(LibBlockNames.FLUXFIELD), TileRFGenerator::new, rfGenerator);
	public static final BlockEntityType<TileBrewery> BREWERY = type(prefix(LibBlockNames.BREWERY), TileBrewery::new, brewery);
	public static final BlockEntityType<TileTerraPlate> TERRA_PLATE = type(prefix(LibBlockNames.TERRA_PLATE), TileTerraPlate::new, terraPlate);
	public static final BlockEntityType<TileRedStringContainer> RED_STRING_CONTAINER = type(prefix(LibBlockNames.RED_STRING_CONTAINER), IXplatAbstractions.INSTANCE::newRedStringContainer, redStringContainer);
	public static final BlockEntityType<TileRedStringDispenser> RED_STRING_DISPENSER = type(prefix(LibBlockNames.RED_STRING_DISPENSER), TileRedStringDispenser::new, redStringDispenser);
	public static final BlockEntityType<TileRedStringFertilizer> RED_STRING_FERTILIZER = type(prefix(LibBlockNames.RED_STRING_FERTILIZER), TileRedStringFertilizer::new, redStringFertilizer);
	public static final BlockEntityType<TileRedStringComparator> RED_STRING_COMPARATOR = type(prefix(LibBlockNames.RED_STRING_COMPARATOR), TileRedStringComparator::new, redStringComparator);
	public static final BlockEntityType<TileRedStringRelay> RED_STRING_RELAY = type(prefix(LibBlockNames.RED_STRING_RELAY), TileRedStringRelay::new, redStringRelay);
	public static final BlockEntityType<TileManaFlame> MANA_FLAME = type(prefix(LibBlockNames.MANA_FLAME), TileManaFlame::new, manaFlame);
	public static final BlockEntityType<TilePrism> PRISM = type(prefix(LibBlockNames.PRISM), TilePrism::new, prism);
	public static final BlockEntityType<TileCorporeaIndex> CORPOREA_INDEX = type(prefix(LibBlockNames.CORPOREA_INDEX), TileCorporeaIndex::new, corporeaIndex);
	public static final BlockEntityType<TileCorporeaFunnel> CORPOREA_FUNNEL = type(prefix(LibBlockNames.CORPOREA_FUNNEL), TileCorporeaFunnel::new, corporeaFunnel);
	public static final BlockEntityType<TilePump> PUMP = type(prefix(LibBlockNames.PUMP), TilePump::new, pump);
	public static final BlockEntityType<TileFakeAir> FAKE_AIR = type(prefix(LibBlockNames.FAKE_AIR), TileFakeAir::new, fakeAir);
	public static final BlockEntityType<TileCorporeaInterceptor> CORPOREA_INTERCEPTOR = type(prefix(LibBlockNames.CORPOREA_INTERCEPTOR), TileCorporeaInterceptor::new, corporeaInterceptor);
	public static final BlockEntityType<TileCorporeaCrystalCube> CORPOREA_CRYSTAL_CUBE = type(prefix(LibBlockNames.CORPOREA_CRYSTAL_CUBE), TileCorporeaCrystalCube::new, corporeaCrystalCube);
	public static final BlockEntityType<TileIncensePlate> INCENSE_PLATE = type(prefix(LibBlockNames.INCENSE_PLATE), TileIncensePlate::new, incensePlate);
	public static final BlockEntityType<TileHourglass> HOURGLASS = type(prefix(LibBlockNames.HOURGLASS), TileHourglass::new, hourglass);
	public static final BlockEntityType<TileSparkChanger> SPARK_CHANGER = type(prefix(LibBlockNames.SPARK_CHANGER), TileSparkChanger::new, sparkChanger);
	public static final BlockEntityType<TileCocoon> COCOON = type(prefix(LibBlockNames.COCOON), TileCocoon::new, cocoon);
	public static final BlockEntityType<TileLightRelay> LIGHT_RELAY = type(prefix(LibBlockNames.LIGHT_RELAY), TileLightRelay::new, lightRelayDefault, lightRelayDetector, lightRelayToggle, lightRelayFork);
	public static final BlockEntityType<TileCacophonium> CACOPHONIUM = type(prefix(LibBlockNames.CACOPHONIUM), TileCacophonium::new, cacophonium);
	public static final BlockEntityType<TileBellows> BELLOWS = type(prefix(LibBlockNames.BELLOWS), TileBellows::new, bellows);
	public static final BlockEntityType<TileCell> CELL_BLOCK = type(prefix(LibBlockNames.CELL_BLOCK), TileCell::new, cellBlock);
	public static final BlockEntityType<TileRedStringInterceptor> RED_STRING_INTERCEPTOR = type(prefix(LibBlockNames.RED_STRING_INTERCEPTOR), TileRedStringInterceptor::new, redStringInterceptor);
	public static final BlockEntityType<TileGaiaHead> GAIA_HEAD = type(prefix(LibBlockNames.GAIA_HEAD), TileGaiaHead::new, gaiaHead, gaiaHeadWall);
	public static final BlockEntityType<TileCorporeaRetainer> CORPOREA_RETAINER = type(prefix(LibBlockNames.CORPOREA_RETAINER), TileCorporeaRetainer::new, corporeaRetainer);
	public static final BlockEntityType<TileTeruTeruBozu> TERU_TERU_BOZU = type(prefix(LibBlockNames.TERU_TERU_BOZU), TileTeruTeruBozu::new, teruTeruBozu);
	public static final BlockEntityType<TileAvatar> AVATAR = type(prefix(LibBlockNames.AVATAR), TileAvatar::new, avatar);
	public static final BlockEntityType<TileAnimatedTorch> ANIMATED_TORCH = type(prefix(LibBlockNames.ANIMATED_TORCH), TileAnimatedTorch::new, animatedTorch);

	private static <T extends BlockEntity> BlockEntityType<T> type(ResourceLocation id, BiFunction<BlockPos, BlockState, T> func, Block... blocks) {
		var ret = IXplatAbstractions.INSTANCE.createBlockEntityType(func, blocks);
		var old = ALL.put(id, ret);
		if (old != null) {
			throw new IllegalArgumentException("Duplicate id " + id);
		}
		return ret;
	}

	public static void registerTiles(BiConsumer<BlockEntityType<?>, ResourceLocation> r) {
		for (var e : ALL.entrySet()) {
			r.accept(e.getValue(), e.getKey());
		}
	}

	public interface BECapConsumer<T> {
		void accept(Function<BlockEntity, T> factory, BlockEntityType<?>... types);
	}

	public static void registerWandHudCaps(BECapConsumer<IWandHUD> consumer) {
		consumer.accept(be -> new TileAnimatedTorch.WandHud((TileAnimatedTorch) be), ModTiles.ANIMATED_TORCH);
		consumer.accept(be -> new TileBrewery.WandHud((TileBrewery) be), ModTiles.BREWERY);
		consumer.accept(be -> new TileCorporeaRetainer.WandHud((TileCorporeaRetainer) be), ModTiles.CORPOREA_RETAINER);
		consumer.accept(be -> new TileCraftCrate.WandHud((TileCraftCrate) be), ModTiles.CRAFT_CRATE);
		consumer.accept(be -> new TileEnchanter.WandHud((TileEnchanter) be), ModTiles.ENCHANTER);
		consumer.accept(be -> new TileHourglass.WandHud((TileHourglass) be), ModTiles.HOURGLASS);
		consumer.accept(be -> new TilePool.WandHud((TilePool) be), ModTiles.POOL);
		consumer.accept(be -> new TilePrism.WandHud((TilePrism) be), ModTiles.PRISM);
		consumer.accept(be -> new TileSpreader.WandHud((TileSpreader) be), ModTiles.SPREADER);
		consumer.accept(be -> new TileTurntable.WandHud((TileTurntable) be), ModTiles.TURNTABLE);
	}
}
