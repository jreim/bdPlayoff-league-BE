package com.playoff.league.config;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.googlecode.objectify.Ref;
import com.playoff.league.data.NFLTeam;
import com.playoff.league.data.Player;
import com.playoff.league.data.serialize.NFLTeamSerialzer;
import com.playoff.league.data.serialize.PlayerDeserialzer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
public class GsonHttpMessageConfig implements WebMvcConfigurer {

    @Bean
    public Gson getGson(){
        GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapter(NFLTeam.class, new NFLTeamSerialzer());
//        gb.registerTypeAdapter(Player.class, new PlayerDeserialzer());
        return gb.create();
    }

    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(this.getGson());
        return converter;
    }

    @Bean
    public HttpMessageConverters customConverters() {

        Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();

//        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
//        messageConverters.add(gsonHttpMessageConverter);
        messageConverters.add(this.gsonHttpMessageConverter());

        return new HttpMessageConverters(true, messageConverters);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter <?>> converters){
        converters.add(this.gsonHttpMessageConverter());
    }


}