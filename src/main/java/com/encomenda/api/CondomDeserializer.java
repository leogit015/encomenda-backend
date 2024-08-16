package com.encomenda.api;

import com.encomenda.infrastructure.entity.Condom;
import com.encomenda.infrastructure.repository.CondomRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class CondomDeserializer extends JsonDeserializer<Condom> {

    @Override
    public Condom deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        JsonNode condominioNode = node.get("condominio");

        if (condominioNode == null || condominioNode.isNull()) {
            return null;
        }

        String nomeCondominio = condominioNode.asText();
        Condom condominio = new Condom();
        condominio.setNomeCondominio(nomeCondominio);

        return condominio;
    }
}

