# Java

#### Why java is platform independent

Because of JVM, Java Virtual Machine is an intepreter that is able to read and execute java class files



#### What are 4 features is Java

1. Encapsulation: The impelementation and state of each object are privately hidden in a class. Other objects cannot access them. It makes the program self-contained and increases the security
2. Abstraction: Abstract the common characteristics from something, not focus on details
3. Inheritance: Relationships and subclasses between objects. Allow us to reuse common logic and functions
4. Polymorphism: Perform a signle action in different ways. Same type of two objects call the different output. Complile type->supper class, Running type->subclass



#### What are access modifiers? What the differences

Access modifiers help to restrict the scope of class, constructor, and attributes

public: Everywhere

protected: same package or subclasses in different package

default: same package

private: same class



#### What is static variables and static method

1. Static variables: a copy of variables shared by all objects of this class
2. Static methods: special method that belongs to the class not the object called by class name. Only can access static methods and variables.



#### What are wrapper classes

Containers of primitive types: Integer, Character, Double, Float, Short, Byte, Boolean

Boxing: convert a primitive value to warpper object

Unboxing: convert a wrapper object to primitive value



#### What does 'super' and 'this' keyword do

'this' is used to refer current class's instance and static members

'super' is used to refer superclass's instance and static members



#### Can you override a private or static method in Java

No, because the private method can only be accessed by its own class, and static method is part of class itself



#### What are the difference between Heap and Stack

Stack is used to store local variables and function call, while heap is used to store objects in Java.

Stack memory is kind of memory of Java thread, and heap memory is shared among all threads



#### What is difference between abstract classes and interfaces

Abstract class is inborn properties in one thing, while interface is an extra function of a thing.

Abstract class can have both abstract method and defined methods

Abstract class is inherited by subclasses, while interface is implemented

Interface can only have static variables

A class can only extend one abstract class but implement mutiple interfaces



#### What is the difference between exception and error

Error indicated serious problems that the program disables to handle, while exception indicates conditions that program want to catch. Error and runtime exception are unchecked, but for runtime exception, we can handle by modifiying the code



#### What is the difference between equals() and == (equality operator)

equals() method can be overridden so that we can compare values of objects. 

equality sign is to compared the memory addreess



#### What is immutable object in Java

Once an immutable object is created, we cannot change it. This provides security

Wrapper classes and String are immutable classes



#### What is the difference between ArrayList, and LinkedList

ArrayList is stored data by an array, insertion is slow, accessing elements is fast

LinkedList uses linked list to store elements, accessing is slower but insertion is fast



#### What is the difference between comparator and comparable

Comparable: compareTo() method is internal, natural sorting

Comparator: compare() method. Flexible and scalable, can define many compare methods



#### What is HashMap? HashTable? HashSet?

| NAME      | DESCRIPTION                                                  |
| --------- | ------------------------------------------------------------ |
| HashSet   | Only store unique value. Unordered                           |
| HashTable | Store k/v pairs, doesn't allow null key/value. Synchronized. Unordered |
| HashMap   | Store k/v pairs, allow one null key, and many null values, non-synchronized. Unordered |



#### Why do we always use String, Integer as keys in Map

Since they are immutable. They override the hashcode and equals method

If you want to use user-defined object as key, you should rewirte hashcode() and equals()



#### What is generics

When defining class, interface, or method, we use undefined data type as parameter. It makes code resuable



#### What is grabege collections

Grabege collection is the process that Java programs perform automatic memory management. Specially, the garbege collector finds those unused objects and remove them to free up memory



#### What are the new features regarding Java 8, Java 11, Java 14



#### How do entries store in the HashMap



#### TCP/IP and Class A, B, C







