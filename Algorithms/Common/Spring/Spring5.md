# Spring 5

## Goals of Spring

* Lightweight development with Java POJOs (Plain-Old-Java-Objects)
* Dependency injection to promote loose coupling
* Declarative programming with Aspect-Oriented-Programming (AOP)
* Minimize boilerplate Java code

## Spring Development Process

1. Configure the Spring beans (Spring objects)

   * XML configuration file

   * Java Annotations

   * Java Source Code

2. Create Spring container (known as ApplicationContext)

3. Retrieve beans from Spring container

## Inversion of Control (IoC)

* The approach of outsourcing the construction and management of objects
* Create and manage objects

## Dependency Injection

* Inject object's dependencies (like helper objects)
  * Constructor Injection
    1. Define the dependency interface and class
    2. Create a constructor in your class for injections
    3. Configure the dependency injection in Spring config file
  * Setter Injection
  * auto-wiring