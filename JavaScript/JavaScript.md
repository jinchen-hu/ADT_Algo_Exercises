# JavaScript

## Primitive Types

* Number: 
  * integer or float
* String:
  * written within double or single quotes
  * when using non-string operator with strings, will try to convert string to number, or return NaN
  * when using comparison operators
    * if one side is a number, the other can be converted to a number, then number comparison; otherwise, always return false
    * if two strings, then string comparison based on the ASCII of the frist different character
* Boolean
  * true or false
  * false, 0, "", null, undefined, NaN are falsy, everything else is truthy
* null
  * a variable in null when not declared or not explicitly assigned a value, has only one value - null, cannot be used as the name of a function or variable, can erase the variables by assigning it to null
* Undefined
  * when declared but not assigned a value, has only one value -- undefined

## Arithmetic Operators

+, -, *, **, /, %, ++, --, -=, *=, /=, %=



## Logic Operators

==, ===, !=, !==, >, <, >=, <=, ?, &&, ||, !



#### Type Operators

* typeof -- returns the type of a variable
* instanced -- returns true if an object is an instance of an object type



## String Methods

|      METHODS       |                         DESCRIPTION                          |
| :----------------: | :----------------------------------------------------------: |
|      .length       |                 returns the length a string                  |
|     indexOf()      | returns the index of the first occurrence of a specified text in a string |
|   lastIndexOf()    | returns the index of the last occurrence of a specified text in a string |
|      search()      | searches a string for a specified value and returns the position of the match |
|     endsWith()     |    checks whether a String contains the specified string     |
| slice(start, end)  | extracts a part of a string and returns the extracted part in the new string, exclude end<br>if a parameter is negative, the position is counted from the end of the string |
| substr(start, len) | extracts the substring from the index of start with length of len |
|     replace()      |  replaces a specified value with another value in a string   |
|   tuUppercase()    |                 convert string to uppercase                  |
|   toLowerCase()    |                 convert string to lowercase                  |
|      charAt()      |    returns the character at a specified index in a string    |
|      split()       | coverts string to an array with delimeter<br>if separator is "", returns an array of single characters |
|      repeat()      |    returns a new stirng with a specified number of copies    |
|       sort()       |                sorts an array alphabetically                 |
|     reverse()      |               reverse the elements in an array               |

#### forEach(func)

calls a function once for each array element

```javascript
var txt = "";
var numbers = [45, 4, 9, 16, 25];
numbers.forEach(myFunction);

function myFunction(value) {
  txt = txt + value + "<br>";
}
```

#### map(func)

creates a new array by performing a function on each array element, and will not change the original array

```javascript
var numbers1 = [45, 4, 9, 16, 25];
var numbers2 = numbers1.map(myFunction);//90, 8, 18, 32, 50

function myFunction(value) {
  return value * 2;
}
```

#### filer(func)

creates a new array with array elements that paste the test

```javascript
var numbers = [45, 4, 9, 16, 25];
var over18 = numbers.filter(myFunction); // 45, 25

function myFunction(value) {
  return value > 18;
}
```

#### reduce(func)

runs a function on each element to produce a single value

```javascript
var numbers1 = [45, 4, 9, 16, 25];
var sum = numbers1.reduce(myFunction); // 99

function myFunction(total, value) {
  return total + value;
}

var numbers1 = [45, 4, 9, 16, 25];
var sum = numbers1.reduce(myFunction, 100);// 199

function myFunction(total, value) {
  return total + value;
}
```

#### every(func)

check if all array elements pass the test

```javascript
var numbers = [45, 4, 9, 16, 25];
var allOver18 = numbers.every(myFunction);//false

function myFunction(value) {
  return value > 18;
}
```

#### some(func)

check if existing an element that passes the test

```javascript
var numbers = [45, 4, 9, 16, 25];
var someOver18 = numbers.some(myFunction); // true

function myFunction(value, index, array) {
  return value > 18;
}
```

#### find(func)

returns the value of the first array element that passes a test function

```javascript
var numbers = [4, 9, 16, 25, 29];
var first = numbers.find(myFunction); // 25

function myFunction(value) {
  return value > 18;
}
```

#### findIndex()

returns the index of the first element passing the test

```javascript
var numbers = [4, 9, 16, 25, 29];
var first = numbers.findIndex(myFunction);//3

function myFunction(value, index, array) {
  return value > 18;
}
```



## Conditions

```javascript
if (condition 1){
  //
} else if (condition 1) {
  //
} else{
  //
}


switch(expression){
  case x:
    //
    break;
  case y:
    //
    break;
  default:
}


for(let i = 0; i<a; i++){
  //
}

for (var x in obj){ // iterate keys
  //
}

for (var x of array){ // iterate values
  //
}


while(condition){
  //
}

do{
  //
}while(condition)
```



## Arrays

```
var a = [1,2,3,4]
```

* Accessing an undefined array entry gives the value undefined
* Asigning to an element beyond the end of array increases its length
* elements can be numbers, strings, booleans, objects, arrays, functions or combination of above

|         METHODS         |                         DESCRIPTION                          |
| :---------------------: | :----------------------------------------------------------: |
|         .length         |               returns the length of the array                |
|       toString()        |        converts an array to a string of array values         |
|     join(delimiter)     |   joins elements with the specified delimiter as an array    |
|          pop()          |      removes and returns the last element from an array      |
|         shift()         |            removes and returns the frist element             |
|   unshift(x1,x2,...)    |       adds new elements to the beginning of the array        |
|     push(x1,x2,...)     |         appends new elements to the array at the end         |
| splice(i, j, x1,x2,...) |    insert new elements at index i, and delete j elements     |
|        concat()         |        createa a new array by merging existing arrays        |
|       slice(i ,j)       | slices out a piece of array into a new array from i to j, exclusive |



## Object

```javascript
const fitBitData = {
  totalSteps: 308727,
  totalMiles: 211.7,
  workoutsThisWeek: '5 0f 7',
  firstName: 'Jimmy',
  lastName: 'Will',
  
  get full(){
    return return this.firstName + ' ' + this.lastName;
  }
};
// get
fitBitData.totalSteps // 308727
fitBitData['totalSteps'] // 308727

// update
fitBitData.totalMiles += 7 // 218.7

// add
fitBitData.fullName = function(){return this.firstName + ' ' + this.lastName;}

/*
fitBitData.fullName; =====> the function definition
fitBitData.fullName(); ===> Jimmy Will
fitBitData.full; =========> Jimmy Will
*/
```



## Arrow Functions

```javascript
var hi = function(val){
  return 'hello' + val;
}

var hi = (val)=>{return 'hello' + val}

var hi = (val) = 'hello' + val // only applicable when the function has one statement
```

* The 'this' is not binding with arrow function, it always return window object



## Class

```javascript
class Car{
  #year
  
  get #decoratedYear(){
  	return '${this.#year}'
	}
  
  set #decoratedYear(msg){
  	this.#message = msg
	}
  
  constructor(name, year){
    this.name = name;
    this.#year = year;
  }
}

let myCar = new Car('Ford', 2020)

class Model extends Car{
  constructor(name, year, mod){
    super(name, year);
    this.model = mod;
  }
}
```



## Build-in Objects

#### Math Object

|      METHOD      |                      DESCRIPTION                       |
| :--------------: | :----------------------------------------------------: |
|     Math.PI      |                       3.14159...                       |
|  Match.round(x)  | returns the value of x rounded to its nearest integer  |
|  Math.pow(x, y)  |        return the value of x to the power of y         |
|   Math.sqrt(x)   |              returns the square root of x              |
|   Math.abs(x)    |            returns the absolute value of x             |
|   Math.ceil(x)   |            return the rounded up value of x            |
|  Math.floor(x)   |          returns the rounded-down value of x           |
| Math.min()/max() | return the lowest or highest value of the list of args |
|  Math.random()   |               returns a number 0<= x < 1               |

#### Date Object

|                            METHOD                            |                       DESCRIPTION                        |
| :----------------------------------------------------------: | :------------------------------------------------------: |
|                      var d = new Date()                      | creates a new date object with the current date and time |
| var d = Data(year, month, day, hour, minute, seconds, millisecond) |                                                          |
|                   var d = Date(dateString)                   |                                                          |
|                       toLocalString()                        |               returns a string of the date               |
|                        getFullYear()                         |         returns the year as a four digit number          |
|                          getMonth()                          |           returns the month as a number (0-11)           |
|                          getDate()                           |           returns the date as a number (1-31)            |
|                          getHours()                          |                 returns the hour (0-23)                  |
|                         getMinutes()                         |                           0-59                           |
|                        getSecondes()                         |                           0-59                           |
|                      getMillisecondes()                      |                          0-999                           |
|                          getTime()                           |               get the time since 1-1-1970                |
|                           getDay()                           |            get the weekday as a number (0-6)             |

#### Set

Set objects are collections of unique values based on operator `===`

```javascript
let mySet = new Set();

mySet.add(1);
mySet.add(5);
mySet.add(5);
mySet.add('txt'); // 1, 5, 'txt'

let o = {a:1, b:2};
mySet.add(o); // 1, 5, 'txt', {a:1, b:2}
mySet.add({a:1, b:2}) // 1, 5, 'txt', {a:1, b:2}, {a:1, b:2}

mySet.has(1) //true

mySet.size // 5

mySet.delete(5)// 1, 'txt', {a:1, b:2}, {a:1, b:2}
mySet.has(5) // false
```

#### Map

* Map is very similar to objects
* map's key can be any value (functions, objects, primitive types), while only String or symbol allowed in object
* it's easy to retrieved the number of items in map using `size`

```javascript
let contacts = new Map()
contacts.set('Jessie', {phone: "213-555-1234", address: "123 N 1st Ave"})
contacts.has('Jessie') // true
contacts.get('Hilary') // undefined
contacts.set('Hilary', {phone: "617-555-4321", address: "321 S 2nd St"})
contacts.get('Jessie') // {phone: "213-555-1234", address: "123 N 1st Ave"}
contacts.delete('Raymond') // false
contacts.delete('Jessie') // true
console.log(contacts.size) // 1

for(let[k, v] of map){}
for(let[k, v] of map.entries()){}
for(let k of map.keys()){}
for(let v of map.values()){}
```



## Async/Await

#### Callback

A call back function passed as an argument to another function. This technique allows a function to call another function

#### Asynchronous vs. Synchronous

* Synchronous code is executed in sequence - each statement waits for the previous statement to finish before executing.
* Asynchronous code doesn't have to wait - keep the site or app responsive, reducing waiting time for the user

#### Promise

A `promise` is an object representing the eventual completion or failure of an asynchronous operation.

* pending: initial state
* fulfilled: the result is a value
* rejected: the result is an error object

![img](https://mdn.mozillademos.org/files/15911/promises.png)

* then()

  * returns a `Promise`

    ```javascript
    p.then(value=>{
    		// fulfillment
    	}
    	, error =>{
    		// rejection
    	}
    );
    ```

    

* catch()

  * returns a `Promise` and deal with rejected cases only

    ```javascript
    p.catch(reason=>{
    	// rejection
    });
    ```

    

* finally()

  * returns a `Promise`, executed no matter fulfilled or rejected

```javascript
const p = 
	(new Promise(myExecutorFunc))
	.then(handleFullfilledA)
	.then(handleFullfilledB)
	.catch(handleRejectedAny);
```

#### Async/Await

Async makes a function return a Promise

Await makes a function wait for a Promise - can only be used inside an `async` function

```javascript
async function showAvatar() {

  // read our JSON
  let response = await fetch('/article/promise-chaining/user.json');
  let user = await response.json();

  // read github user
  let githubResponse = await fetch(`https://api.github.com/users/${user.name}`);
  let githubUser = await githubResponse.json();

  // show the avatar
  let img = document.createElement('img');
  img.src = githubUser.avatar_url;
  img.className = "promise-avatar-example";
  document.body.append(img);

  // wait 3 seconds
  await new Promise((resolve, reject) => setTimeout(resolve, 3000));

  img.remove();

  return githubUser;
}

showAvatar();
```


