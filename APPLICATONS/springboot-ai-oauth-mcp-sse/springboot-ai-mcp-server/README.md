# springboot-ai-mcp-server-basic-sse

---


* To build 
```
$ mvn clean package 
```     
* to Run 
```
$ mvn spring-boot:run
```
* Get Token 
```
curl --location 'localhost:9090/oauth2/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Authorization: ••••••' \
--header 'Cookie: JSESSIONID=E94F09DADE674391F421F9002DF4195B' \
--data-urlencode 'grant_type=client_credentials' \
--data-urlencode 'scope=mcp'
```
* OAuth Token Generation
![img](./img/oauth-token-generation.png)
* adding Bearer Token to Header
![img](./img/bearer-token.png)
  * Requesting SSE Endpoint
![img](./img/sse-request.png)

