package com.week03.tm3.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("kk", "java-1-nio");
        response.headers().set("kk2", "java-2-nio");
        response.headers().set("kk3", "java-3-nio");
    }
}
