
From a shell in the logback-examples directory, we can run our example server application as follows:

```shell
java -Dport=6000 chapters.receivers.socket.ReceiverExample \ 
      src/main/java/chapters/receivers/socket/receiver1.xml
```

We can connect to the running receiver using a client application that is configured with a SocketAppender. Our example client application simply loads a logback configuration that will connect a socket appender to our example receiver. It then awaits input from the user in the form of a message that will be relayed to the receiver. We can run the example client application as follows:

```shell
java -Dhost=localhost -Dport=6000 \
      chapters.receivers.socket.AppenderExample \
      src/main/java/chapters/receivers/socket/appender1.xml
```
