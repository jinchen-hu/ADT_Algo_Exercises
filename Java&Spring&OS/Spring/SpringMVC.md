# [Spring MVC](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html)

## What is Spring MVC

* Framework for building web applications in Java
* Based on Model-View-Controller design pattern
* Leverages features of the Core Spring Framework

![SpringMVCRequestLifecycle](/Users/luke/github-workplace/ADT_Algo_Exercises/common/SpringMVCRequestLifecycle.png)

#### Front Controller

* Known as DispathcerServlet, responsible for managing the flow of Spring MVC application
* Part of the Spring framework
* Already developed by Spring Dev Team

#### Controller

* Code created by developer
* Contains the businees logic
  * Handle the request
  * Store/retrieve data (db, web service ...)
  * Place data in model
* Send to appreciate view template

#### Model

* Contains your data
* Store/retrieve data via backend system
  * database, web services 
  * use Sprign bean if you like
* Place your data in the model
  * Data can be any Java object/collection

#### View Template

* Most common is JSP+JSTL
* Developer creates a page to display data
* Other templates: Thymeleaf, Groovy, Velocity, Freemarker

## Benefits of Spring MVC

* The Spring way of building web app UIs in Java
* Leverage a set of reusable UI components
* Help manage application state for web requests
* Process form data: validation, conversion
* Flexible configuration for the view layer

## Components of Spring MVC

* A set of web pages to layout UI components
* A collection of Spring beans (controllers, services, etc...)
* Spring configuration (XML, Annotations or Java)

## Spring MVC Configuration Process

* Add configurations to file: WEB_INF/web.xml
  1. Configure Spring MVC Dispatcher Servlet
  2. Set up URL mappings to Spring MVC Dispatcher Sevlet
* Add configurations (entries) to file: WEB-INF/spring-mvc-demo-servlet.xml
  3. Add support for Spring component scanning
  4. Add support for conversion, formatting and validation
  5. Configure Spring MVC View Resolver

![Spring MVC Tutorial](https://static.javatpoint.com/sppages/images/flow-of-spring-web-mvc.png)

- As displayed in the figure, all the incoming request is intercepted by the DispatcherServlet that works as the front controller.
- The DispatcherServlet gets an entry of handler mapping from the XML file and forwards the request to the controller.
- The controller returns an object of ModelAndView.
- The DispatcherServlet checks the entry of view resolver in the XML file and invokes the specified view component.

#### Development Process

1. Create Controller class
   1. Annotate class with @Controller
2. Define Controller methods
3. Add Request mapping to controller method
   1. Annotate method with @RequestMapping("/")
4. Return View name
5. Display View page

## Spring Validation

#### Development Process

1. Add validation rule to Customer class
2. Display error message on HTML form
3. Perform validation in the Controller class
4. Update confirmation page