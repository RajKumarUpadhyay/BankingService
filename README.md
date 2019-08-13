**Banking Money Transfer Rest API**
A Java RESTful API for money transfers between users accounts

**Technologies**<br />
JAX-RS API<br />
H2 in memory database<br />
Log4j<br />
Jetty Container (for Test and Demo app)<br />
Apache HTTP Client<br />
**How to run**<br />
mvn exec:java<br />
Application starts a jetty server on localhost port 8080 An H2 in memory database initialized with some sample user and account data To view<br />

> http://localhost:8080/user/test1 <br />
> http://localhost:8080/user/test2 <br />
> http://localhost:8080/account/1 <br />
> http://localhost:8080/account/2 <br />

**Available Services** <br />
HTTP METHOD	PATH	USAGE <br />
GET	/user/{userName}	get user by user name<br />
GET	/user/all	get all users<br />
PUT	/user/create	create a new user<br />
POST	/user/{userId}	update user<br />
DELETE	/user/{userId}	remove user<br />
GET	/account/{accountId}	get account by accountId<br />
GET	/account/all	get all accounts<br />
GET	/account/{accountId}/balance	get account balance by accountId<br />
PUT	/account/create	create a new account<br />
DELETE	/account/{accountId}	remove account by accountId<br />
PUT	/account/{accountId}/withdraw/{amount}	withdraw money from account<br />
PUT	/account/{accountId}/deposit/{amount}	deposit money to account<br />
POST	/transaction	perform transaction between 2 user accounts<br />
**Http Status**<br />
200 OK: The request has succeeded<br />
400 Bad Request: The request could not be understood by the server<br />
404 Not Found: The requested resource cannot be found<br />
500 Internal Server Error: The server encountered an unexpected condition<br />
Sample JSON for User and Account<br />
User :
{  
  "userName":"test1",
  "emailAddress":"test1@gmail.com"
} <br />
User Account: :
{  
   "userName":"test1",
   "balance":10.0000,
   "currencyCode":"USD"
} <br />
User Transaction:
{  
   "currencyCode":"EUR",
   "amount":100000.0000,
   "fromAccountId":1,
   "toAccountId":2
}
