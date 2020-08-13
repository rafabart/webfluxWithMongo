package com.webfluxWithMongo.service;

import com.webfluxWithMongo.document.PlaylistDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaylistService {

    Flux<PlaylistDocument> findAll();

    Mono<PlaylistDocument> findById(final String id);

    Mono<PlaylistDocument> save(final PlaylistDocument playlistDocument);
}
