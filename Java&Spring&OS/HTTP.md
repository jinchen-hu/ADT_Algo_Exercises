# HTTP

## HTTP Request Message

* Request line: the HTTP command
* Header variables: request metadata
* Message body: contents of message

## HTTP Response Message

* Response line: server protocol and status code
* Header variables: reponse metadata
* Message body: contents of message

#### Status Code

| Code Range | Description  |
| :--------: | :----------: |
| 100 - 199  | Information  |
|  200-299   |  Successful  |
|  300-399   | Redirection  |
|  400-499   | Cliend Error |
|  500-599   | Server Error |

* 401 Authentication Required
* 404 File Node Required
* 500 Internal Server Error

## MIME Content Type

* The message format is described by MIME content type
  * Multipurpose Internal Mail-Extension
* Basic Syntax: type/sub-type
* Example: text/html  text/plain application/json

## Client Tppl

Send HTTP requests to the REST API such as curl, Postman