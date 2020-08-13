package com.webfluxWithMongo.repository;

import com.webfluxWithMongo.document.PlaylistDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlaylistRepository extends ReactiveMongoRepository<PlaylistDocument, String> {
}
