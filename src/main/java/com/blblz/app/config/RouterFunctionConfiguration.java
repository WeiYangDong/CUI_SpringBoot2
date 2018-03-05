package com.blblz.app.config;

import com.blblz.app.domain.User;
import com.blblz.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * @author WeiYangDong
 * @date 2018/3/5 16:27
 * @deprecated 路由器函数配置(类似Java版的XML文件)
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * Servlet
     *  请求接口:ServletRequest 或 HttpServletRequest
     *  响应接口:ServletResponse 或 HttpServletResponse
     *
     * Spring 5.0 重新定义了服务端的请求和响应接口
     *  请求接口:ServerRequest
     *  响应接口:ServerResponse
     *  既可以支持Servlet规范,也可以支持自定义,如:Netty(Web Server)
     *  Flux 是 0 ~ N 个对象集合
     *  Mono 是 0 ~ 1 个对象集合
     *  Reactive 中的 Flux 或 Mono 是异步处理(非阻塞)
     *  集合对象基本上是同步处理(阻塞)
     *  Flux 或 Mono 都是 Publisher(发布者)
     *
     *  使用Reactive方式编写的接口可以提高吞吐量,可以使程序以24*7方式运行
     */

    /**
     * 定义GET请求,返回所有用户对象;URI:/user/get/allUser
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> getAllUser(UserRepository userRepository){
        //数据查询操作可以放入到 request 中
//        Collection<User> users = userRepository.getAllUser();
        return RouterFunctions.route(RequestPredicates.GET("/user/get/allUser"),
                request -> {
                    Collection<User> users = userRepository.getAllUser();
//                    Mono<ServerResponse> response = null;
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux,User.class);
                });
    }
}
