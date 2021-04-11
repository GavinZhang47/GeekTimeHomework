package com.week03.tm3.router;

import java.util.List;
import java.util.Random;

public class RandomHttpEndpointRouterSelf implements HttpEndpointRouter {
    @Override
    public String route(List<String> urls) {
        int size = urls.size();
        return urls.get((int) (System.currentTimeMillis()%size));
    }
}
