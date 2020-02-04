package cn.catbar.easycloud.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class MyFilter implements GatewayFilter, Ordered {

    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";

    //过滤器逻辑
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    logger.info("这里是post类型过滤器");
                })
        );

    }


    //给过滤器设定优先级别
    @Override
    public int getOrder() {
        return 0;
    }
}
