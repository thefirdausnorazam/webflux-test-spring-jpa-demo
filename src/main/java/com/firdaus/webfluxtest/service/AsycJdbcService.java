package com.firdaus.webfluxtest.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.util.concurrent.Callable;

public abstract class AsycJdbcService {

    private Scheduler scheduler;

    protected <T> Mono<T> asyncMono(Callable<T> callable) {
        return Mono.fromCallable(callable).publishOn(scheduler);
    }

    protected <T> Flux<T> asyncFlux(Callable<T> callable) {
        return Flux.from(asyncMono(callable));
    }

    protected void setScheduler(Scheduler scheduler){
        this.scheduler = scheduler;
    }

    protected Scheduler getScheduler(){
        return this.scheduler;
    }
}
