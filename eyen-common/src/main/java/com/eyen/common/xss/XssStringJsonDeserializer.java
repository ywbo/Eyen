package com.eyen.common.xss;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * 基于xss的JsonDeserializer
 *
 * @author yuwenbo
 * @date 2022/03/20 22:58
 */
public class XssStringJsonDeserializer extends JsonDeserializer<String> {


    @Override
    public Class<String> handledType() {
        return String.class;
    }

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return XssUtil.cleanXSS(jsonParser.getValueAsString());
    }
}