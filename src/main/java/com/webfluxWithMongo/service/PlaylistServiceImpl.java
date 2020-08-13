package com.webfluxWithMongo.service;

import com.webfluxWithMongo.document.PlaylistDocument;
import com.webfluxWithMongo.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    final private PlaylistRepository playlistRepository;


    @Override
    public Flux<PlaylistDocument> findAll() {
        return playlistRepository.findAll();
    }


    @Override
    public Mono<PlaylistDocument> findById(final String id) {
        return playlistRepository.findById(id);
    }


    @Override
    public Mono<PlaylistDocument> save(final PlaylistDocument playlistDocument) {
        return playlistRepository.save(playlistDocument);
    }
}
