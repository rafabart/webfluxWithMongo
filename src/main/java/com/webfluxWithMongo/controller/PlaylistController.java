package com.webfluxWithMongo.controller;

import com.webfluxWithMongo.document.PlaylistDocument;
import com.webfluxWithMongo.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;


    @GetMapping
    public Flux<PlaylistDocument> findAll() {
        return playlistService.findAll();
    }


    @GetMapping("/{id}")
    public Mono<PlaylistDocument> findById(@PathVariable final String id) {
        return playlistService.findById(id);
    }


    @PostMapping
    public Mono<PlaylistDocument> save(@RequestBody final PlaylistDocument playlistDocument) {
        return playlistService.save(playlistDocument);
    }
}
