package com.kokochi.game.web.config;

import com.kokochi.game.web.socket.NettyChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

@Configuration
@RequiredArgsConstructor
public class NettyConfiguration {

    @Value("${server.host}")
    private String host;
    @Value("${server.netty.port}")
    private int port;
    @Value("${server.netty.boss-count}")
    private int bossCount;
    @Value("${server.netty.worker-count}")
    private int workerCount;
    @Value("${server.netty.keep-alive}")
    private boolean keepAlive;
    @Value("${server.netty.backlog}")
    private int backlog;

    @Bean
    public ServerBootstrap serverBootstrap(NettyChannelInitializer nettyChannelInitializer) {
        // ServerBootSTrap : 서버 설정을 도와줌
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup(), workerGroup())
                // NioServerSocketChannel : incoming connection을 수락하기 위해 새로운 Channel을 객체화 할 때 사용
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                // ChanneInitializer : 새로운 Channel을 구성할 떄 사용되는 Hanlder, 주로 ChannelPipeline으로 구성됨
                .childHandler(nettyChannelInitializer);

        // ServerBootstrap에 다양한 Option 추가 기능
        // SO_BACKLOG: 동시에 수용이 가능한 최대 incoming connections의 개수
        // 이외에도 SO_KEEPALIVE, TCP_NODELAY 등의 옵션을 제공함\
        b.option(ChannelOption.SO_BACKLOG, backlog);
        return b;

    }

    // boss : incoming connection을 수락하고, 수락한 connection을 worker에게 등록
    @Bean(destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup bossGroup() {
        return new NioEventLoopGroup(bossCount);
    }

    @Bean(destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup workerGroup() {
        return new NioEventLoopGroup(workerCount);
    }

    // IP 소켓 주소를 구현
    // 도메인 이름으로 객체 생성이 가능함
    @Bean
    public InetSocketAddress inetSocketAddress() {
        return new InetSocketAddress(host, port);
    }


}
