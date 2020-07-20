
```shell
# example 1
## below package name could be renamed
java ch.qos.logback.classic.net.SimpleSocketServer 6000 src/main/java/chapters/appenders/socket/server1.xml
java chapters.appenders.socket.SocketClient1 localhost 6000

# example 2
## below package name could be renamed
java -Dhost=localhost -Dport=6000 -DincludeCallerData=false chapters.appenders.socket.SocketClient2 src/main/java/chapters/appenders/socket/client1.xml
java ch.qos.logback.classic.net.SimpleSocketServer 6000 src/main/java/chapters/appenders/socket/server2.xml
java -Dhost=localhost -Dport=6000 -DincludeCallerData=true chapters.appenders.socket.SocketClient2 src/main/java/chapters/appenders/socket/client1.xml

# example 3
java -Djavax.net.ssl.keyStore=src/main/java/chapters/appenders/socket/ssl/keystore.jks \
    -Djavax.net.ssl.keyStorePassword=changeit \
    ch.qos.logback.classic.net.SimpleSSLSocketServer 6000 \
    src/main/java/chapters/appenders/socket/ssl/server.xml

java -Dhost=localhost -Dport=6000 \
    -Dtruststore=file:src/main/java/chapters/appenders/socket/ssl/truststore.jks \
    -Dpassword=changeit \
    chapters.appenders.socket.SocketClient2 src/main/java/chapters/appenders/socket/ssl/client.xml

```