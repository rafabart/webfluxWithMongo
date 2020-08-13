package com.webfluxWithMongo;

import com.webfluxWithMongo.document.PlaylistDocument;
import com.webfluxWithMongo.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DummyData implements CommandLineRunner {

    final private PlaylistRepository playlistRepository;

    @Override
    public void run(String... args) throws Exception {


        playlistRepository.deleteAll()
                .thenMany(
                        Flux.just("Spring", "React", "CSS", "HTML", "Node")
                                .map(name -> new PlaylistDocument(UUID.randomUUID().toString(), name))
                                .flatMap(playlistRepository::save)
                ).subscribe(System.out::println);
    }
}
