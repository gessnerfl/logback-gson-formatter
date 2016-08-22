package de.gessnerfl.logback.gson;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import com.google.common.collect.Lists;

import de.gessnerfl.logback.gson.GsonFormatter;

public class GsonFormatterTest {
	
	@Test
	public void shouldCreateJsonForMap() throws Exception{
		Map map = createTestData();
		
		GsonFormatter sut = new GsonFormatter();
		
		String json = sut.toJsonString(map);
		
		assertEquals("{\"array\":[\"foo\",\"bar\"],\"list\":[\"foo\",\"bar\"],\"number\":1,\"string\":\"foo\"}", json);
	}
	
	@Test
	public void shouldCreatePrettyJsonForMap() throws Exception{
		Map map = createTestData();
		
		GsonFormatter sut = new GsonFormatter();
		sut.setPrettyPrint(true);
		
		String json = sut.toJsonString(map);
		
		assertEquals("{\n  \"array\": [\n    \"foo\",\n    \"bar\"\n  ],\n  \"list\": [\n    \"foo\",\n    \"bar\"\n  ],\n  \"number\": 1,\n  \"string\": \"foo\"\n}", json);
	}

	private Map createTestData() {
		Map<String,Object> data = new TreeMap<>();
		data.put("array", new String[]{"foo", "bar"});
		data.put("list", Lists.newArrayList("foo", "bar"));
		data.put("number", 1L);
		data.put("string", "foo");
		return data;
	}
	
}
