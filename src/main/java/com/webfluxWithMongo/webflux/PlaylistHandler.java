package com.webfluxWithMongo.webflux;

import com.webfluxWithMongo.document.PlaylistDocument;
import com.webfluxWithMongo.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


//@Component
@RequiredArgsConstructor
public class PlaylistHandler {

    private final PlaylistService playlistService;


    public Mono<ServerResponse> findAll(final ServerRequest serverRequest) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playlistService.findAll(), PlaylistDocument.class);
    }


    public Mono<ServerResponse> findById(final ServerRequest serverRequest) {

        final String id = serverRequest.pathVariable("id");

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playlistService.findById(id), PlaylistDocument.class);
    }


    public Mono<ServerResponse> save(final ServerRequest serverRequest) {

        final Mono<PlaylistDocument> playlistDocumentMono = serverRequest.bodyToMono(PlaylistDocument.class);

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(playlistDocumentMono.flatMap(playlistService::save), PlaylistDocument.class));
    }
}
