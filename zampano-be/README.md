
nginx Error during WebSocket handshake: Unexpected


https://stackoverflow.com/questions/12102110/nginx-to-reverse-proxy-websockets-and-enable-ssl-wss

nginx.conf
...
location /websocket/ {
    proxy_pass http://backend_host;
    proxy_http_version 1.1;
    proxy_set_header Upgrade $http_upgrade;
    proxy_set_header Connection "upgrade";

    proxy_read_timeout 86400;
}


## start in combined mode (ui / ws server)

pass optional program arguments: --server.address=127.0.0.1  (on hosting server)
                                 --server.port=8080
java -jar /Users/mue/work/git/github_m1markus/zampino/zampano-be/target/zampano-be-0.0.1-SNAPSHOT.jar --server.port=8080


## documentation

spring boot update security after login: https://stackoverflow.com/questions/37608937/how-to-update-spring-security-userdetails-impls-after-successful-login

spring boot add usercred and group after login: https://dzone.com/articles/spring-security-with-spring-boot-20-userdetailsser

spring boot websocket without stomp: https://www.devglan.com/spring-boot/spring-websocket-integration-example-without-stomp

## backend

https://redis.io/clients

https://lettuce.io/

https://hazelcast.org/

https://jet.hazelcast.org/
