# JWT - Json Web Tokens

Jwt is an open-source industry standard that is used for 

* authorization or secure exchange of information between parties
* Verify that the sender is who it/his/her claims to be
* signed by the insurer, using a secret or keypair (HMAC algorithm, RSA or ECDSA)

## JWT Structure

![Encoded JWT](https://cdn.auth0.com/content/jwt/encoded-jwt3.png)

`XXXXXX.YYYYY.ZZZZZZ` ==> `header.payload.signature`

### Header

contains metadata about the token (type, hashing algorithm etc)

```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```

### Payload

contains claims (statements about an entity - e.g., a user) and additional data

```json
{
  "sub": "1234567890",
  "name": "John Doe",
  "admin": true
}
```

### Signature

the result of the encoded header, the encoded payload, signed against a secret

```
HMACSHA256(
  base64UrlEncode(header) + "." +
  base64UrlEncode(payload),
  secret)
```

