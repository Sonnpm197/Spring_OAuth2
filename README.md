# Spring Microservices 

This is my sample of creating an app based on microservices architecture in Spring. Here are my repos

1. ConfigServer: https://github.com/Sonnpm197/Spring_ConfigServer
2. ZuulGateway: https://github.com/Sonnpm197/Spring_Zuul
3. OAuth2Server: https://github.com/Sonnpm197/Spring_OAuth2
4. SampleService: https://github.com/Sonnpm197/Spring_SampleService
5. QuizletService: https://github.com/Sonnpm197/Spring_QuizletService
6. ConfigurationRepo: https://github.com/Sonnpm197/LearningEnglishWebConfiguration
7. EurekaServer: https://github.com/Sonnpm197/Spring_EurekaServer
8. JWT only (not with OAuth2): https://github.com/Sonnpm197/Spring_JwtSwaggerAuditing
9. ZippkinServer: https://github.com/Sonnpm197/Spring_ZipkinServer
10. SampleSleuth: https://github.com/Sonnpm197/Spring_Sleuth

**Setting up**

1. IntelliJ 2019
2. JDK8 + Maven + Kafka/Zookepper tutorial: https://dzone.com/articles/kafka-with-spring-cloud-stream
3. Set env variable: ENCRYPT_KEY = IMSYMMETRIC (for decrypt properties from ConfigServer in each service)

**Kafka & Zookeeper**

https://www.cloudkarafka.com/blog/2018-07-04-cloudkarafka_what_is_zookeeper.html

**Download (Do not download Zookeper/Kafka src files)**

Zookeeper: https://www.apache.org/dyn/closer.lua/zookeeper/zookeeper-3.6.1/apache-zookeeper-3.6.1-bin.tar.gz

Kafka: https://www.apache.org/dyn/closer.cgi?path=/kafka/2.5.0/kafka_2.12-2.5.0.tgz

Redis for Window: https://github.com/microsoftarchive/redis/releases

**Run zookeeper & kafka**

zookepper: <pre>zkserver</pre>

kafka: <pre>.\bin\windows\kafka-server-start.bat .\config\server.properties</pre>

**Handling kafka errors**

1. The input line is too long. The syntax of the command is incorrect = change folder to short name (kafka_2.15 -> kafka)
2. classpath is empty. please build the project first e.g. by running 'gradlew jarall' = you download src file

**Run redis**

Unzip downloaded file and run redis-server.exe

**Architecture**

Notes: JWTSwaggerAuditing and SampleSleuth are not included in this architecture
https://app.diagrams.net/?lightbox=1&highlight=0000ff&edit=_blank&layers=1&nav=1&title=Untitled%20Diagram.drawio#R1VpNc6M4EP01PiaFkAXkmA9vdlMztdnyVnmSmwIKaIPBJURs59evZAQGCU8cygF8sVGDBHr9up%2FUMIG3y809w6voZxqQeGJbwWYC7ya2DYDliT9p2SoLskBhCRkNlG1vmNMPooyWsuY0IFnjQp6mMaerptFPk4T4vGHDjKXr5mWvady86wqHxDDMfRyb1gUNeFRYPWTt7X8SGka8mrE6s8TlxcqQRThI1zUTnE3gLUtTXhwtN7ckluiVuBT9%2FjhwtnowRhJ%2BTIf5%2FSKB2H5%2Bvfvx8J%2B%2FmP18ePrrAhajvOM4VxO%2BTZNXGs4JeydMPTjflmiwNE8CIge0JvBmHVFO5ivsy7NrQQBhi%2FgyFi0gDtXQhHGyOfjMoEJCcIikS8LZVlyiOpTYKfZA1VzvPQHKS6KaFxxlw8r5YTXwHh9xoCD6AlxTA64fBLOEJuEsCWOaRQvyUgCYM8xpmgyHoILs4srEzO4VM2RgZoBCkuBaxqpo%2BTHOMuqLyWccM26aa%2FAICNj2l4TyErqwNDzJs5cWrAx3G4V20drWW4%2BEUTFNQfXCWDwaCYykoOEtHj%2FNmU8%2BDy0xi5Dwzzhl%2Bq%2FmL9TirtLGSCyI9t583DYfqjs8plRMpAow4DQj7EpjQTFL1ameXLRxqnytxplq4xQoGOPsCFVNujvHHINjc7xcxUSmMSq8NHQeg010bGvoROYagP2T04%2BY8LEg5mipH7TksX4h8zrmsfaEhRrp6rNUtaG81k20nnYtleREe99RNur9vjHDOUdmODhkhvMO8OirGQ5oMQx6TnFXo6Pfb6l3Qpq550AzXQCB11VJNUWueNcTz8p51Ij293XOI3ssygB1MR1cGYDdMTa%2FssStB2wtfr8UsqCvkD1WGYDV7uqeFr9azEI9pR%2BtDc4BSvYVs%2BY2%2FvQE7KYZoK4YFRm%2FnYClZz9loDskAZF1IgIiNDABzcLIc57H95iTNd6OTjKmg%2B%2B%2FgLljHUvEWgNF7PTIiHUGlQydSairZHgHKNlXxJoVgLEQcCjJOJaAg0rG9ErjTWfJmGra07dkmBvaWc7IGx7Jq4epJqkX3tCaUd7sJCWAC%2BvSsrzmpsIRSaFDzby21%2FBgPXbPoTZV0HAsVQOdO52LBv3GcjnxIYpTx3Nm5FxwTlWpRNoapecCUun7GhleCfcjmoST3Xv637wdFemaN2mBYxomkjPCmzJP3MikTn0cX6sTSxoEsvsNIxn9wC%2B7oSQxVnKCuymjmwm6k2PlPM2KLwxOtbHQRKIShLpIwBbO2N8mEmYpgJGQZgK8nQOcWAL8IvTVCXkFwhm7AOkLadfwgNurA8ytsCyfkkTeLAl2eYIzSkSesK2Hxb8yMaVv5PxjAeg1CKclFrxeXWF%2BevAolWeXiBTo4l%2F8hAcKFWfnA%2F2DmbbaeJuGfZ8PzELHM12t3mgyknW%2BXhtCYPB1fi9bc%2FucikP2scv5YYtDWvShru8AgasN1PcSruu3Dn0Xh9zxMXDY6pC2D0Ru1z2EtjFFukB0ZqBo7r95LS7ffzoMZ%2F8D

**Build and run**

**Note: Any services register with Eureka need 30s, it may cause 500 error when you start services and instantly run them**

Run <pre>mvn spring-boot:run</pre> on ConfigServer, Eureka, Zuul, OAuth2 and Zipkin projects first

Then <pre>mvn spring-boot:run</pre> on SampleService and QuizletService

Run: curl --location --request POST 'http://localhost:8901/oauth/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Authorization: Basic bGVhcm5pbmdlbmdsaXNoOnRoaXNpc3NlY3JldA==' \
--form 'grant_type=password' \
--form 'scope=webclient' \
--form 'username=son2' \
--form 'password=password2'

OR run on PostMan:

POST http://localhost:8901/oauth/token

Authorization Tab: Basic Auth

Username: learningenglish & Password: thisissecret

Body Tab: form-data:
1. grant_type: password
2. scope: webclient
3. username: son2
4. password: password2

Then get the access JWT token and add to Authorization Header with value: Bearer <JWT_TOKEN> 

**Note: If you want to test token generated by OAuth2 default (not JWT type), comment out this class JWTOAuth2Config in OAuth2Service. This class is used for hooking JWT to OAuth2

**Sample request**: curl --location --request GET 'http://localhost:8081/saveQuizlet' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ3aWxsaWFtLndvb2R3YXJkIiwic2NvcGUiOlsid2ViY2xpZW50Il0sInNwZWNpYWxQcm9wZXJ0eSI6IlZlcnlJbXBvcnRhbnRQcm9wZXJ0eSIsImV4cCI6MTU4ODk5OTQ2NiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiIsIlJPTEVfVVNFUiJdLCJqdGkiOiJiOTk5ODMxYS03ZWZkLTQ3NTEtOTk1YS03NTZlMjAyN2Q0ZTUiLCJjbGllbnRfaWQiOiJsZWFybmluZ2VuZ2xpc2gifQ.c7AbqTIw_Ux9moexAuTVPlXIpXanfjAWDo5SxPDB51U'



