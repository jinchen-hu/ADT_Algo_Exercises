# Aspect-Oriented Programming

* Programming technique based on concept of an Aspect
* Aspect encapsulates cross-cutting logic

## Aspect

* Aspect can be reused at multiple locations
* Same aspect/class applied based on configuration

## AOP Solution

* Apply the Proxy design pattern

## Benefits of AOP

* Code for Aspect is defined in a single class
  * Much better than being scattered everywhere
  * Promotes code reuse and easier to change
* Businees code in your application is cleaner
  * Reduce code complexity
* Configurable
  * Based on configuration, apply Aspects selectively to different parts if aoo
  * No need to make changes to main app

##  AOP Use Cases

* Most common
  * logging. security, transactions
* Audit logging
  * who, what, when, where
* Exception handling
  * log exception and notify DevOps team vis SMS/email
* API Management
  * how many times has a method been called used
  * analytics: what are peak times? what is average load? who is top user?
* Post-Process or Modify Data -- After returning

## AOP Terminology

* Aspect: module of code for a cross-cutting concern
* Advice: what action is taken and when it shoud be applied
  * before advice: run before the mothod
  * after finally advice: run after the method (finally)
  * after returning advice: run after the mothod (sucess execution)
  * after throwing advice: run after method (if exception thrown)
  * around advice: run before and after method
* Join Point: When to apply code during program execution
* Pointcut: a predicate expression for where advice should be applied
* Weaving: conneting aspect to target objects to create an advised object
  * compile-time, load-time, run-time
  * run-time weaving is the slowest

## Spring AOP vs. AspectJ

* Spring AOP only supports
  * method-level join points
  * run-time weaving
* AspectJ supports
  * join points: method-level, construtor, field
  * weaving: compile-time, post compile-time and load-time

## Pointcut

```java
// ? stands for optional
// * matches everything
execution(modifier_type? return_type declaring_name? method_name(param_pattern) throw_type?)
```

* modifier type: optional
* return type: mandatory, * for any type
* declaring name: fully-qualified name (packagename.classname.methodname)
* method name: mandatory, \*abc for ending with `abc`, abc\* for starting with `abc`
* param patthen: () no args, (*) on arg of any type, (..) 0 or more args for any type
* any mthod in a package (* fully_qualified_package_name.\*.\*(..))

#### Combination

Can use logic operators to combine two or more point cuts

#### Control Order

* Refactor: Place advices in separate Aspects
* Control order on Aspects usign the @order annotation
  * range: Integer.MIN_VALUE to Integer.MAX_VALUE
  * negative numbers are allowed
  * the orider numbers are not necessarily consecutive
  * if two numbers are same, randomly run one of them first