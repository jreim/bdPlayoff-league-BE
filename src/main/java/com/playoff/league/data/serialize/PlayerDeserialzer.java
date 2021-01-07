package com.playoff.league.data.serialize;

import com.google.gson.*;
import com.playoff.league.data.NFLTeam;
import com.playoff.league.data.Player;

import java.lang.reflect.Type;

public class PlayerDeserialzer implements JsonSerializer<Player> {
//	@Override
//	public JsonElement serialize(NFLTeam nflTeam, Type type, JsonSerializationContext jsonSerializationContext) {
//		return null;
//	}

//	@Override
	public Player deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

		return null;
	}

	@Override
	public JsonElement serialize(Player player, Type type, JsonSerializationContext jsonSerializationContext) {
		return null;
	}
}
