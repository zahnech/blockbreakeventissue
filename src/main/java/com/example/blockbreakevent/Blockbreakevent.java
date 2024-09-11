package com.example.blockbreakevent;

import com.example.blockbreakevent.event.BlockBreakingHandler;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blockbreakevent implements ModInitializer {
	public static final String MOD_ID = "blockbreakevent";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		AttackBlockCallback.EVENT.register(new BlockBreakingHandler());
		PlayerBlockBreakEvents.AFTER.register(new BlockBreakingHandler());
		PlayerBlockBreakEvents.CANCELED.register(new BlockBreakingHandler());
	}
}