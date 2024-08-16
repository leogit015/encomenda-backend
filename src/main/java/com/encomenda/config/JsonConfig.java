package com.encomenda.config;

import com.encomenda.api.CondomDeserializer;
import com.encomenda.infrastructure.entity.Condom;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;


public class JsonConfig {


    @Bean
    public ObjectMapper objectMapper( CondomDeserializer condomDeserializer) {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Condom.class, condomDeserializer);
        objectMapper.registerModule(module);
        return objectMapper;
    }

}
