package com.project.data;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class GameHelper {
	
	private static Map<String, Game> gameMap = new HashMap<String, Game>();

	/**
	 * Game Instances invoked by users
	 * @return Map on gameInstaces, defined by hash.
	 */
	public static Game getGame(String hash) {
		return gameMap.get(hash);
	}
	
	/**
	 * Add new game to game Map
	 * @return hash that identifies game.
	 * @throws NoSuchAlgorithmException 
	 */
	public static String addGame(String algorithm1, String algorithm2, String hash) {
		synchronized (Game.class) {
			gameMap.put(hash, new Game(algorithm1, algorithm2));
		}
		return hash;
	}

	public static Byte[] getNextTable(String hash) {
		Game game = gameMap.get(hash);
		return game.getNextBoard();
	}
}