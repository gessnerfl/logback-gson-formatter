package org.gessnerfl.logback.gson;

import java.io.IOException;
import java.util.Map;

import ch.qos.logback.contrib.json.JsonFormatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonFormatter implements JsonFormatter {

    public static final int BUFFER_SIZE = 512;

    private Gson gson;
    private boolean prettyPrint;

    public GsonFormatter() {
        this.gson = new Gson();
        this.prettyPrint = false;
    }

    @Override
    public String toJsonString(Map logData) throws IOException {
        return gson.toJson(logData);
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public boolean isPrettyPrint() {
        return prettyPrint;
    }

    public void setPrettyPrint(boolean prettyPrint) {
        this.prettyPrint = prettyPrint;
        if(prettyPrint){
        	gson = new GsonBuilder().setPrettyPrinting().create();
        }
    }
}

