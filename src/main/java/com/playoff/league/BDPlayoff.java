package com.playoff.league;

import com.google.appengine.api.utils.SystemProperty;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.playoff.league.data.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.WebApplicationInitializer;


@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class BDPlayoff extends SpringBootServletInitializer implements WebApplicationInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BDPlayoff.class, args);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        Datastore ds = null;
        if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
            ds = DatastoreOptions.getDefaultInstance().getService();
        } else {
            ds = DatastoreOptions
                .newBuilder()
                .setNamespace("league-data")
                .setHost("localhost:8081")
                .setProjectId("my-project")
                .build().getService();
        }


        ObjectifyFactory of = new ObjectifyFactory(ds);

        ObjectifyService.init(of);
        ObjectifyService.register(Game.class);
        ObjectifyService.register(Player.class);
        ObjectifyService.register(PlayerStat.class);
        ObjectifyService.register(Team.class);
        ObjectifyService.register(DraftPick.class);
        ObjectifyService.register(PlayerStat.class);
    }
}



