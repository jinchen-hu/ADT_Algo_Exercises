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

Error indicated serious problems that the program disables to handle, while exception indicates conditions that program want to catch. Error and runtime exception are unchecked, but for the other exception, we can handle by modifiying the code



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

#### Java 8

* Lambda expression
* Stream API for collections

#### Java 11

* String methods: isBlank(), repeat(int i), lines().counts
* Strengthen stream

#### Java 14

* **instanceof** can operate casting if the type matches
* switch beconmes more standarized, multipe tags can be split using comma, and -> stands for only execute right statement
* Record class



#### How do entries store in the HashMap

* Internally HashMap contains an array of Node and a node is represented as a class which contains 4 fields: int hash, K key, V value, Node next
* It can be seen that node is containing a reference of its own object. So it's a linked list
* Therefore, it's a combination of array and linked list, where array is main structure, and linked list is to resolve hash collision



#### What is tight coupling

When a class, say, class A is dependent on another class's object, say B, then we say a is tightly coupled with B



#### What is loose couple

removes the dependency of an object on another class. It is approched by creating an interface and a setter&getter method, or by using a constructor which takes the interface object



#### What are Java Beans in Spring

When a class is annotated or decorated using @Component, such a class is called a Spring Bean, which is maintained by Application Context

A Java Object initialized by the Spring IoC container



#### Explain Bean creation process

1. The program finds the class A with @Component annotation
2. Check if it's dependent on another class B
3. If yes, create a Bean for B
4. Finally, a connection or autowiring will occur between two classes using @Autowired annotation



#### What is Dependency Injection

Dependency injection is where Spring searches for beans; once the approciate bean is found, it autowires the bean to the dependent class. Dependency injection is the process when Spring framework looks for the beans and identifies the dependencies, and create the instances of beans and autowires them.



#### Explain Inversion of Control

In tight coupling the dependent class takes the responsibility of creating its dependency. Whereas, in loose coupling, we use @Autowired annotation over the dependency class and Spring takes control of creating the instance and injects the dependency.



#### Roles of IoC

1. Find Beans
2. Identify their dependencies and wire the dependencies
3. Manage Lifecycle of the Bean



#### Process of Spring MVC

1. The browser sends a request to DispatcherServlt
2. DispatcherServlet know the HandlerMapping and can find the appropriate controllers
3. Controllers executes the request and put the data in the model and return back the view name to DispatcherServlet
4. DispatcherServlet uses the view name and ViewResolver to map to the view



#### What is Hibernate

Once the mapping is done, Hibernate will help us create query and interact with the database



#### What is POM.xml

Project Object Model is an XML formatted file in which all the configuration for a maven project is defined.



#### What is SpringSecurity

Spring security provides scurity services (authemtication and authority methods) to j2ee applications. Spring Security is implemented using Servlet Filter, which is used to pre-process or post-process web requests



#### What is CSRF

Cross-site-request-forgery is a security attach where a fraudulent websites tricks the user into perfroming an event on the web application that he is logged into.