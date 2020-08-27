package com.webfluxWithMongo.controller;

import com.webfluxWithMongo.document.PlaylistDocument;
import com.webfluxWithMongo.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
@RequestMapping("/playlist")
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

    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, PlaylistDocument>> getPlaylistByEvents() {

        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));

        Flux<PlaylistDocument> events = playlistService.findAll();

        return Flux.zip(interval, events);
    }
}
