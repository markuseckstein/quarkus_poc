package org.acme.microprofile.graphql;

import java.time.Duration;

import javax.enterprise.context.RequestScoped;

import io.smallrye.mutiny.Multi;

@RequestScoped
public class GreetingsService {
    public Multi<String> greetings(int count, String name) {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
              .onItem().transform(n -> String.format("hello %s - %d", name, n))
              .transform().byTakingFirstItems(count);
      }
}
