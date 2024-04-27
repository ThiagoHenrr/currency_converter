package com.org.currencyConverter.business;

import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

public class Currency{
    private String baseCode;

    private String targetCode;
    private float conversionRate;
    public String getBaseCode(){
        return baseCode;
    }

    public String getTargetCode(){
        return targetCode;
    }
    public float convert(int valueToConvert){
        return valueToConvert * this.conversionRate;
    }

    public void clearJson(String raw){
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(raw);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        this.baseCode = jsonObject.get("base_code").getAsString();
        this.targetCode = jsonObject.get("target_code").getAsString();
        this.conversionRate = jsonObject.get("conversion_rate").getAsFloat();
    }
}
