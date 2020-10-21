package com.ecom.transportservice.service;


import com.ecom.transportservice.domain.ClosureDateDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class RestService {


    public void getRestJson() throws Exception {

       RestTemplate restTemplate = new RestTemplateBuilder().build();


        ClosureDateDTO cdDTO = restTemplate.getForObject("", ClosureDateDTO.class);

        JsonNode jsonTree = new ObjectMapper().readTree(cdDTO.getAccountPreferenceDataLists().get(0).getPreference());

        System.out.println(cdDTO.getAccountPreferenceDataLists().get(0));
    }

}
