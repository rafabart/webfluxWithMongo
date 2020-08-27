package com.webfluxWithMongo.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;


//@Configuration
public class PlaylistRouter {


    //    @Bean
    public RouterFunction<ServerResponse> route(final PlaylistHandler playlistHandler) {
        return RouterFunctions
                .route(GET("/playlist").and(accept(MediaType.APPLICATION_JSON)), playlistHandler::findAll)
                .andRoute(GET("/playlist/{id}").and(accept(MediaType.APPLICATION_JSON)), playlistHandler::findById)
                .andRoute(POST("/playlist").and(accept(MediaType.APPLICATION_JSON)), playlistHandler::save);
    }
}
