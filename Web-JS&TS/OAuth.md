# OAuth

OAuth is an open standard for access delegation, commonly used as a way for Internet users to grant websites or applications access to their information on other websites but without giving them the password

## OAuth for servers

* results in a 'token' that a server can use to make requests on behalf of the user
* usually used when we have an app that needs to access user data when they are not logged in
* difficult to setup because we need to store a lot of information about the user

## OAuth for JS Browser Apps

* results in a 'token' that a browser app can use to make requsts on behalf of the user
* usually used when we have an app that only needs to access user data whole they are logged in
* very easy to set up thanks to Google's js lib to automate flow