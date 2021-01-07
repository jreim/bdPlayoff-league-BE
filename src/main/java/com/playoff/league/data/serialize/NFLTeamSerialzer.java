package com.playoff.league.data.serialize;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.playoff.league.data.NFLTeam;

import java.io.IOException;
import java.lang.reflect.Type;

public class NFLTeamSerialzer extends TypeAdapter<NFLTeam> {
	@Override
	public void write(JsonWriter jsonWriter, NFLTeam nflTeam) throws IOException {
		jsonWriter.beginObject();
		jsonWriter.name("name");
		jsonWriter.value(nflTeam == null ? "FUUUUUCK" : nflTeam.toString());
//		jsonWriter.name("logo");
//		jsonWriter.value(nflTeam.getImage());
		jsonWriter.name("conf");
		jsonWriter.value(nflTeam.getConf().toString());
		jsonWriter.endObject();
	}

	@Override
	public NFLTeam read(JsonReader jsonReader) throws IOException {

		return NFLTeam.valueOf(jsonReader.nextString());
	}


//	@Override
//	public JsonElement serialize(NFLTeam nflTeam, Type type, JsonSerializationContext jsonSerializationContext) {
//		JsonObject element = new JsonObject();
//		element.addProperty("name" , nflTeam.toString());
//		element.addProperty("logo" , nflTeam.getImage());
//		element.addProperty("conf" , nflTeam.getConf().toString());
//
//
//		return element;
//	}

//	@Override
//	public NFLTeam deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//
//		return null;
//	}
}
