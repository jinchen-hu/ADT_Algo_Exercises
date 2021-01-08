# TypeScript

TypeScript is Object-Oriented JavaScript.

## Types

### Any

The any data type is the super type of all types in TypeScript. It denotes a dynamic type. Using the any type is equivalent to opting out of type checking for variable

### Built-in types

* number - 64-bit floating point values -- integers or fractions
* string - a sequence  of Unicode characters
* boolean - true or false
* void - faction return type
* null - an intentional absence of an object value
* undefined - value of uninitialized variables

### User-defined types

* enums
* class
* interface
* array
* tuple

### Union type

`var val: type1|type2|type3`

### typeof

`typeof varName` return the type of the variable

## Variables

`var name : type = value`

```typescript
// both are type of string
var name1 : string = 'luke';
var name2 = 'liam';

// both will display error, since there are strings
name1 = 10;
name2 = false;
```

## Function

`function fuc(arg1 : type):returnType{}`

## Array

`var arr:type[]=[val1, val2, ...]`

`var arr:[type1, type2]`

## Interface

Interfaces define properties, methods, and events, which are the members of the interface

Interfaces contain only the declaration of the members. It is the responsibility of the deriving class to define the members. It often helps in providing a standard structure that the deriving classes would follow

```typescript
interface Person{
    firstName: string,
    lastName: string,
    sayHi:()=>string
}

//Objects
var customer:Person={
    firstName: 'Tom',
    lastName: 'Jackson',
    sayHi: () :string =>{return 'hi'}
}
```

### Inheritance

An interface can inherit from multiple interfaces

```typescript
interface P1{
	v1:number
}

interface p2{
	v2:string
}

interface PChild extends P1, P2 {}

var child : PChild = {v1:22, v2:'hello'}
```

## Class

```typescript
class Car{
    // field
	engine: string;
	
    // constructor
	constructor(engine:string){
		this.engine = engine;
	}
	
    // function
	disp():void{
		console.log('menmen')
	}
}
```

### Inheritance

Each class can at most extend from one parent class

### Overridden

Use super keyword to refer to the immediate parent of a class

### Static

The static keyword can be applied to the data members of a class. A static variable retains its values till the program finished execution. `className.staticVar`

### instanceof

`obj instanceof className` return true if the object belongs to the specified type

