package com.vertx.sample;


import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.core.http.HttpServer;

public class MyFirstVerticle extends AbstractVerticle {

    /** by default
    @Override
    public void start() throws Exception{
        vertx.createHttpServer()
                .requestHandler(req -> {
                    req.response().end("Hallo from "+Thread.currentThread().getName());
                }).listen(8080);
    }
    **/

    @Override
    public void start() {
        HttpServer server = vertx.createHttpServer();
        server.requestStream().toObservable()
                .subscribe(req -> {
                    req.response().end("Hello from rxJava Verxt "
                            +Thread.currentThread().getName());
                });

        server
                .rxListen(8080)
                .subscribe();
    }
}
