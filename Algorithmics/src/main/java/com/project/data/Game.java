package com.project.data;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class Game {

	private static Map<String, Game> gameMap = new HashMap<String, Game>();
	private static SecureRandom random = new SecureRandom();
	private String algorithm1;
	private String algorithm2;
	
	
	public Game(String algorithm1, String algorithm2) {
		this.algorithm1 = algorithm1;
		this.algorithm2 = algorithm2;
	}

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
	public static String addGame(String algorithm1, String algorithm2) {
		String hash = null;
		synchronized (Game.class) {
			hash  = new BigInteger(130, random).toString(32);
			gameMap.put(hash, new Game(algorithm1, algorithm2));
		}
		return hash;
	}
}
