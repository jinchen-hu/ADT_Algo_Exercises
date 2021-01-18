# NestJs

Nest is a framework for building efficient, scalabel Node.js server-side aplications

## Controllers

Controllers are responsible for handling incoming requests and returning responses to the client

### Routing

The routing mechanism controls which controller receives which requests. Frequently, each controller has more than one route, and different routes can perform different actions.

|  DECORATORS   |                         DESCRIPTION                          |
| :-----------: | :----------------------------------------------------------: |
| @Controller() |                group a set of related routes                 |
|    @Get()     | create a handler for a specific endpoint for HTTP GET requests |
|    @Post()    |                         POST action                          |
|    @Put()     |                          PUT action                          |
|   @Delete()   |                        DELETE action                         |
|   @Patch()    |                         PATCH action                         |
|     @All      |           Define an endpoint handler all requests            |
|  @Options()   |                                                              |
|   @Header()   |               Define a custom response header                |
|  @Redirect()  |                                                              |
|   @Params()   |                                                              |



```typescript
import { Controller, Get } from '@nestjs/common';
import { AppService } from './app.service';

// decorator to define a controller
@Controller('cat') // define prefix of the route: /cat 
export class AppController {
  constructor(private readonly appService: AppService) {}

  // If not defined this is current root path /cat
  // otherwise, say, @Get('mew'), the route  /cat/mew
  @Get() //postfix
  getHello(): string {
    return this.appService.getHello();
  }
  
  @Post()
  create(): string {
    return 'This action adds a new cat';
  }

  @Delete()
  delete(): string {
    return 'This action deletes a new cat';
  }
}
```

### Request Object

|       DECORATORS        |          PROPERTIES           |
| :---------------------: | :---------------------------: |
|   @Request(), @Req()    |              req              |
|  @Response(), @Res()`   |              res              |
|         @Next()         |             next              |
|       @Session()        |          req.session          |
|  @Param(key?: string)   |  req.params/req.params[key]   |
|   @Body(key?: string)   |    req.body/req.body[key]     |
|  @Query(key?: string)   |   req.query/req.query[key]    |
| @Headers(name?: string) | req.headers/req.headers[name] |
|          @Ip()          |            req.ip             |
|      @HostParam()       |           req.hosts           |

### Route Wildcard

Using asterisk `*` will match any combination of characters

```typescript
@Get('ab*cd')
findAll() {
  return 'This route uses a wildcard';
}
```

### Status Code

As mentioned, the response **status code** is always **200** by default, except for POST requests which are **201**. We can easily change this behavior by adding the `@HttpCode(...)` decorator at a handler level.

```typescript
@Post()
@HttpCode(204)
create() {
  return 'This action adds a new cat';
}
```

### Headers

Customize our own response headers

```typescript
@Post()
@Header('Cache-Control', 'none')
create() {
  return 'This action adds a new cat';
}
```

### Redirection

`Redirect(url, statusCode)` where status code is optinal with default value set to 302

```typescript
@Get('docs')
@Redirect('https://docs.nestjs.com', 301)
getDocs(@Query('version') version) {
  if (version && version === '5') {
    return { url: 'https://docs.nestjs.com/v5/', statusCode: 302 }; //this will override the redirection
  }
}
```

### Route Parameters

Capture the dynamic value at the position in the request URL

```typescript
@Get(':id')
findOne(@Param() params): string {
  console.log(params.id);
  return `This action returns a #${params.id} cat`;
}

//or
@Get(':id')
findOne(@Param('id') id: string): string {
  return `This action returns a #${id} cat`;
}
```

### Sub-domain Routing

The `@Controller` decorator can take a `host` option to require that the HTTP host of the incoming requests matches some specific value.

```typescript
@Controller({ host: 'admin.example.com' })
export class AdminController {
  @Get()
  index(): string {
    return 'Admin page';
  }
}
```

### Example

```typescript
import { Controller, Get, Query, Post, Body, Put, Param, Delete } from '@nestjs/common';
import { CreateCatDto, UpdateCatDto, ListAllEntities } from './dto';

@Controller('cats')
export class CatsController {
  @Post()
  create(@Body() createCatDto: CreateCatDto) {
    return 'This action adds a new cat';
  }

  @Get()
  findAll(@Query() query: ListAllEntities) {
    return `This action returns all cats (limit: ${query.limit} items)`;
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return `This action returns a #${id} cat`;
  }

  @Put(':id')
  update(@Param('id') id: string, @Body() updateCatDto: UpdateCatDto) {
    return `This action updates a #${id} cat`;
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return `This action removes a #${id} cat`;
  }
}
```

## Providers

Many of the base Nest classes may be treated as a provider - services, repositories, factories, helpers, and so on. The main idea of a provider is that it can inject dependencies; this means objects can create various relationships with each other, and the function of "wiring up" instances of objects can largely be delegated to the Nest runtime system. A provider is simply a class annotated with an `@Injectable()` decorator

### Services

```typescript
// a basic service with a single method
import { Injectable } from '@nestjs/common';
import { Cat } from './interfaces/cat.interface';

@Injectable()
export class CatService {
  private readonly cats: Cat[] = [];

  create(cat: Cat) {
    this.cats.push(cat);
  }

  findAll(): Cat[] {
    return this.cats;
  }

  getHello(): string {
    return 'Hello, I am a cat! Mew';
  }
}

```

```typescript
export interface Cat {
  name: string;
  age: number;
  breed: string;
}
```

### Dependency Injection

Nest will resolve the service by creating and returning an instance of service (in the normal case of a singleton). This dependency is resolved and passed to your controller's constructor (or assgined to the indicated property)

### Scope/Lifetime

* When the application is bootstrapped, every dependency must be resloved, and therefore every provider has to be instantiated.

* When the application shuts down, each provider will be destroyed.

### Optional Providers

The dependencies are not necessarily resolved.

`@Optional` indicates an optional provider

`@Inject` defualt value

```typescript
import { Injectable, Optional, Inject } from '@nestjs/common';

@Injectable()
export class CatService<T> {
  constrictor(@Optional() @Inject('HTTP_OPTIONS') private httpClient: T){};
};
```

### Property-based Inject

Very useful in the **inheritance**

```typescript
import { Injectable, Optional, Inject } from '@nestjs/common';

@Injectable()
export class CatService<T> {
  @Inject('HTTP_OPTIONS')
  private readonly httpClient: T;
};
```

### Provider Registration

```typescript
import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { CatService } from './app.service';

@Module({
  imports: [],
  controllers: [AppController],
  providers: [CatService],
})
export class AppModule {}
```

### Class Provider

The `userClass` syntax allows you to dynamically determin a class that a token should resolve to.

Suppose we have an abstract `ConfigService` class, and two implementations of the configuration services

```typescript
const configServiceProvider = {
  provide: ConfigService,
  useClass: process.env.NODE_ENV === 'development'
  	? DevelopmentConfigService : ProductionConfigService,
};

@Module({
  provider: [configuServiceProvider]
})
```

### Asynchronous Providers

Use `async/await` with `useFactory`

## Modules

The `@Module` decorator provides metadata that Nest makes use of organize the application structure.

`nest g module moduleName` will automatically create a module for us

Each application has at least one module - **root module**, which is the starting point Nest uses to build the **application graph** - the internal data structure Nest uses to resolve module and provider relationships and dependencies. 

Properties of a Module

* providers:

  the provides that will be instantiated by the Nest injector and that may be shared at least across this module

* controllers:

  the set of controllers defined in this module which have to be instantiated

* imports:

  the list of imported modules that export the provides which are required in this module

* exports:

  the subset of providers that are provided by this module and should be available in other modules which import this module

```typescript
@Module({
  controllers:
  providers:
  imports: 
  exports:
})
```

### Feature Modules

A feature module simply organizes code relevant for a specific feature, keeping code organized and establishing clear boundaries.

```typescript
import { Module } from '@nestjs/common';
import { CatController } from './cat.controller';
import { CatService } from './cat.service';

@Module({
  imports: [],
  controllers: [CatController],
  providers: [CatService],
})
export class CatsModule {}
```

```typescript
import { Module } from '@nestjs/common';
import { CatsModule } from './cats/cat.module';

@Module({
  imports: [CatsModule],
})
export class AppModule {}
```

### Shared Modules

In Nest, modules are **singletons** by default, and thus you can share the same instance of any provider between multiple modules effortlessly

Every module is automatically a shared module. Once created it can reused by any module.

* Add the providers that needs to be shared in the set of exports
* The provides in the module now can be accessed by any other modules that imports this module

```typescript
import { Module } from '@nestjs/common';
import { CatController } from './cat.controller';
import { CatService } from './cat.service';

@Module({
  imports: [],
  controllers: [CatController],
  providers: [CatService],
  exports: [CatService],
})
export class CatsModule {}
```

### Module Re-exporting

Modules can export their internal providers. In addition, they can re-export modules that they imported

### Dependency Injection

A module class can inject providers as well (e.g., for configuration purpose)

### Global Modules

Use `@Global` decorator to make providers available everywhere out-of-box

```typescript
import { Module } from '@nestjs/common';
import { CatController } from './cat.controller';
import { CatService } from './cat.service';

@Global()
@Module({
  imports: [],
  controllers: [CatController],
  providers: [CatService],
  exports: [CatService],
})
export class CatsModule {}
```

### Dynamic Modules

The feature of dynamic modules enables you to easily create customizable modules that can register and configure providers dynamically

```typescript
@Module({
  providers: [UserService],
  exports: [UserService],
})

export class UserModule {};
```

We are able to inject the services in the imported modules without listing them in the current module's providers list

```typescript
@Module({
  imports: [UserModule],
  providers: [AuthService],
  exports: [AuthService]
})

export class AuthModule {};
```

#### Configuration Module

Dynamic modules provide an API for importing one module into another, and customizing the properties and behaviour of that module when it is imported, as opposed to using the static bindings

1. `ConfigModule` is a normal class that must have a **static method** called `register()` or `forRoot()` by convention .

```typescript
@Module({
	imports: [ConfigModule.register({folder: './config'})]
})
```



## Middleware

Middleware is a function which is called before the route handler. Middleware functions have access to the request and response objects, and the `next()` middleware function in the application's request-response cycle.

* execute any code
* Make changes to the request and response objects
* end request-response cycle
* call the next middleware function in the stack
* if the current middleware function does not end the request-response cycle, it must call `next()` to pass control to the next middleware function. Otherwise, the request will be left hanging

```typescript
import { Injectable, NestMiddleware } from '@nestjs/common';
import { Request, Response, NextFunction } from 'express';

@Injectable()
export class LoggerMiddleware implements NestMiddleware {
  use(req: Request, res: Response, next: NextFunction) {
    console.log('Request...');
    next();
  }
}

```

### Applying Middleware

* Use `configure()` to set up the module class
* Modules that including middleware  have to implement the `NestModule` interface
* Restrict a middleware to a particular request method by passing an object containing the route `path` and request `method` to the `forRoutes()` method, and import `RequestMethod` enum to reference the desired request method type

```typescript
@Module({
  imports: [CatsModule],
})
export class AppModule implements NestModule {
  configure(consumer: MiddlewareConsumer) {
    consumer
      .apply(LoggerMiddleware)
      .forRoutes({ path: 'cats', method: RequestMethod.GET });
  }
}
```

### Middleware Consumer

`MiddlewareConsumer` provides several built-in methods to manage middleware. All of them can be chained in the fluent style.

`forRoutes()` method can take a single string, multiple strings, a `RouteInfo` object, a controller class and even multiple controller classes. 

`apply()` method may either take a single middleware, or multiple arguments to specify multiple middlewares

### Excluding Routes

We can exclude certain routes with the `exclude` method. This method can tale a string, multiple strings, or a `RouteInfo` object identifying routes to be excluded

```typescript
@Module({
  imports: [CatsModule],
})

// middleware works for all paths in CatsController except post method
export class AppModule implements NestModule {
  configure(consumer: MiddlewareConsumer) {
    consumer
      .apply(LoggerMiddleware)
      .exclude({ path: 'cats', method: RequestMethod.POST })
      .forRoutes(CatsController);
  }
}
```

### Functional Middleware

No need dependencies compared to class middleware.

```typescript
export const Logger = (req: Request, res: Response, next: NextFunction) => {
  console.log('This is a functional middleware');
  next();
};
```

### Multiple Middleware

`apply()` can take a list of middlewares to bind them that are excuted sequentially.

```typescript
export class AppModule implements NestModule {
  configure(consumer: MiddlewareConsumer) {
    consumer
      .apply(Logger, LoggerMiddleware)
      .forRoutes(CatsController);
  }
}
```

### Global Middleware

Use `use()` method supplied by `INextApplication` instance to bind middleware to every registered route at once

```typescript
const bootstrap = async () => {
  const app = await NestFactory.create(AppModule);
  app.use(Logger);
  await app.listen(3000);
};
bootstrap();
```

## Exception Filters

Nest built-in exceptions layer is responsible for proccesing all unhandled exceptions across an application.

The default JSON response is

```javascript
{
"statusCode": 500,
"message": "Internal server error"
}
```

### Throwing Standard Exceptions

```javascript
throw new HttpException(
  //response, can be a string or an object
  {
    status: HttpStaus.FORBIDDENT,
    error: 'This is a custom message'
  }, 
  //status
	HttpStatus.FORBIDDEN
);

// response
{
  "status": 403,
  "eroor": "This is a custom message"
}
```

### Custom Exceotions

Custome exceptions inherit from the base `HttpException` class.

```typescript
export class ForbiddenException extends HttpException {
  constructor() {
    super('Forbidden', HttpStatus.FORBIDDEN);
  }
}
```

### Exception Filters

Exception filters let you control the exact flow of control and the content of the response sent back to the client.

All excpetion filters should implement the generic `ExceptionFitler<T>` interface. This requires you to provide the `catch(exception:T, host ArgumentsHost)` method with its indicated signature.

`@Catch(HttpException)` decorator binds the required metadata to the exception filter. It may take a single parameter, or a list for serveral types of exceptions at once

```typescript
@Catch(HttpException)
export class HttpExceptionFilter implements ExceptionFilter {
  catch(exception: HttpException, host: ArgumentsHost) {
    const ctx = host.switchToHttp();
    const response = ctx.getResponse<Response>();
    const request = ctx.getRequest<Request>();
    const status = exception.getStatus();

    response.status(status).json({
      statusCode: status,
      timestamp: new Date().toISOString(),
      path: request.url,
    });
  }
}
```

### Arguments Host

### Binding Filters

Use `@UseFilters()` to bind a single filter or a list of filters and methods in controller. Preferably use `new`

* Method-scoped

```typescript
@Post('exception')
@UseFilters(new HttpExceptionFilter())
async createException() {
  throw new ForbiddenException();
}
```

* Class-scoped

```typescript
@Controller('cats')
@UseFilters(new HttpExceptionFilter())
export class CatsController {}
```

* Global-scoped

```typescript
const bootstrap = async() =>{
  const app = await NestFactory.create(AppModule);
  app.useGlobalFilters(new HttpExceptionFilter());
  await app.listen(3000);
}

bootstrap();
```

### Catch Everything

Leave the parameter list empty to catch every unhandled exception

```typescript
@Catch()
export class AllExceptionFilter implements ExceptionFilter {
  catch(exception: unknown, host: ArgumentsHost) {
    const ctx = host.switchToHttp();
    const response = ctx.getResponse();
    const request = ctx.getRequest();

    const status =
      exception instanceof HttpException
        ? exception.getStatus()
        : HttpStatus.INTERNAL_SERVER_ERROR;

    response.status(status).json({
      statusCode: status,
      timestamp: new Date().toISOString(),
      path: request.url,
    });
  }
}
```

### Inheritance

Extend `BaseExceptionFilter` and call the inherited `catch()` to delegate exception processing to the base filter

```typescript
@Catch()
export class AllExceptionsFilter extends BaseExceptionFilter {
  catch(exception: unknown, host: ArgumentsHost) {
    super.catch(exception, host);
  }
}
```

## Pipes

A pipe is a class annotated with the `@Injectable` decorator. Pipes should impment `PipeTransform` interface.

* Transformation: transform input data to the desired form
* Validation: evaluate input data and if valid, simply pass it through unchanged; otherwise, throw an exception when the data is incorrect

### Built-in Pipes

* `ParseIntPipe`

  Convert the parameter to integer or throw an exception if the convention fails

* `ParseBoolPipe`

* `ParseArrayPipe`

* `ParseUUIDPipe`

All `Pipe*` actions works similarly. These pipes all work in the context of validating rout parameters, query string parameters, and request body values.

* `ValidationPipe`
* `DefaultValuePipe`

### Binding Pipes

Pass a the class

```typescript
@Get(':id')
async findOne(@Param('id', ParseIntPipe) id: number): Promise<string> {
  return this.catsService.findOne(id);
}
```

Pass an in-place instance to customize the build-in pipe's behaviour

```typescript
@Get(':id')
async findOne(
	@Param('id', 
	new ParseIntPipe({ errorHttpStatusCode: HttpStatus.NOT_ACCEPTABLE }),)id: number,
  ): Promise<string> {
   return this.catsService.findOne(id);
}
```

### Custom Pipes

`PipeTransform<T, R>` is a generic interface that must be implemented by any pipe. The generic interface uses `T` to indicate the type of. the input `value`, and `R` to indicate the return type of the `transform()` method.

```typescript
@Injectable()
export class ValidationPipe implements PipeTransform {
  transform(value: any, metadata: ArgumentMetadata) {
    return value;
  }
}
```

### Schema Based Validation

### Class Validator

```typescript
import { IsString, IsInt } from 'class-validator';

export class CreateCatDto {
  @IsString()
  name: string;

  @IsInt()
  age: number;

  @IsString()
  breed: string;
}
```



```typescript
import {
  PipeTransform,
  Injectable,
  ArgumentMetadata,
  BadRequestException,
  Type,
} from '@nestjs/common';
import { validate } from 'class-validator';
import { plainToClass } from 'class-transformer';

@Injectable()
export class ValidationPipe implements PipeTransform<any> {
  async transform(value: any, { metatype }: ArgumentMetadata) {
    if (!metatype || !this.toValidate(metatype)) return value;

    const object = plainToClass(metatype, value);
    const error = await validate(object);
    if (error.length > 0) {
      throw new BadRequestException('Validation Failed');
    }
    return value;
  }

  private toValidate(metatype: Type<any>): boolean {
    const types = [String, Boolean, Number, Array, Object];
    return !types.find((type) => metatype === type);
  }
}
```

### Transformation Use Case

Transformation pipes can perform functions 

1. Type conversion
2. Provide default value for missing fields

by interposing a processing function between the client request and the request handler

### Providing Defaults

Simply instantiate `DefaultValuePipe` in the decorators before the relevant `Pipe*`

```typescript
@Get()
async findAll(
  @Query('activeOnly', new DefaultValuePipe(false), ParseBoolPipe) activeOnly: boolean,
  @Query('page', new DefaultValuePipe(0), ParseIntPipe) page: number,
  ) {
  return `Default values will be provided for missing fields ${activeOnly} and ${page}`;
}
```

## Guards

* A guard is a class annotated with `@Injectable` decorator with the implementation of `CanActivate` interface
* Guards determin whether a given request will be handled by the route handler or not, depending on certain conditions present at run-time
* Guards are executed after each middleware, but before any interceptor or pipe
* Guards can be controller-scoped, method-scoped with `@UseGuards` decorator, or global-scoped with `useGlobalGuards()` method

### Authroization Guard

Every guard must implement a `canActivate()` function. If it returns true, the request will be processed

```typescript
@Injectable()
export class AuthGuard implements CanActivate {
  canActivate(
    context: ExecutionContext,
  ): boolean | Promise<boolean> | Observable<boolean> {
    const request = context.switchToHttp().getRequest();
    return validateRequest(request);
  }
}
```

### Role-based Authentication

Use `SetMetadata()` to attach custom metadata to route handlers

```typescript
import { SetMetadata } from '@nestjs/common';

export const Roles = (...roles: string[]) => SetMetadata('roles', roles);
```

```typescript
@Post()
// Attach the role metadata (role is a key, [] is the value) to this action
@Roles('admin')
async create(@Body() createCatDto: CreateCatDto) {
  this.catsService.create(createCatDto);
}
```

Use `Reflector` to access route's roles (custom metadata), `get()` will read the handler metadata

`getHandler()` will extract the metadata for the current processed route handler, if applying metadata at the controller level, we use `context.getClass()` instead

```typescript
@Injectable()
export class RolesGuard implements CanActivate {
  constructor(private reflector: Reflector) {}

  canActivate(
    context: ExecutionContext,
  ): boolean | Promise<boolean> | Observable<boolean> {
    const roles = this.reflector.get<string[]>('roles', context.getHandler());
    if (!roles) {
      return true;
    }

    // return the list of roles of current client
    const request = context.switchToHttp().getRequest();
    const user = request.user;
    return this.matchRoles(roles, user.roles);
  }

  private matchRoles(roles: string[], userRoles: string[]) {
    return roles.some((role) => userRoles.includes(role));
  }
}
```

## Interceptors

Interceptors inspired by the AOP are responsible for:

* Bind extra logix before/after method execution

* Transform the result returned from a function

* Transform the exception thrown from a function

* Extend the basc function behavior

* Completely override a function depending on specific conditions

  Each interceptor implements `intercept()`, which takes two arguments `ExectionContext` and `CallHandler` which implements `handle()` method that invokes the route handler mehtod at some point in the interceptor

### Aspect Intercetpion

```typescript
import {
  CallHandler,
  ExecutionContext,
  Injectable,
  NestInterceptor,
} from '@nestjs/common';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable()
export class LoggingInterceptor implements NestInterceptor {
  intercept(context: ExecutionContext, next: CallHandler): Observable<any> {
    console.log('Before ....');

    const now = Date.now();

    return next
      .handle()
      .pipe(tap(() => console.log(`After ... ${Date.now() - now}ms`)));
  }
}
```

### Binding Interceptions

Use `UseInterceptors()` on class and method levels, while using `useGlobalInterceptors()` for setting up globally

### Response Mapping

The response will be `{"data: []"}`now

```typescript
import {
  CallHandler,
  ExecutionContext,
  Injectable,
  NestInterceptor,
} from '@nestjs/common';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

export interface Response<T> {
  data: T;
}

@Injectable()
export class TransformInterceptor<T>
  implements NestInterceptor<T, Response<T>> {
  intercept(
    context: ExecutionContext,
    next: CallHandler,
  ): Observable<Response<T>> {
    return next.handle().pipe(map((data) => ({ data })));
  }
}
```

## Custom Decorators

```typescript
import {
  CallHandler,
  ExecutionContext,
  Injectable,
  NestInterceptor,
} from '@nestjs/common';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

export interface Response<T> {
  data: T;
}

@Injectable()
export class TransformInterceptor<T>
  implements NestInterceptor<T, Response<T>> {
  intercept(
    context: ExecutionContext,
    next: CallHandler,
  ): Observable<Response<T>> {
    return next.handle().pipe(map((data) => ({ data })));
  }
}

```

```typescript
@Get()
async findOne(@User('firstName') firstName:string){
	console.log();
}
```

### Decorator Composition

Use `applyDecorators()` to compose multiple decorators.s

## Injection Scopes

**Singleton** instances is highly recommended in most cases

|   SCOPE   |                         DESCRIPTION                          |
| :-------: | :----------------------------------------------------------: |
|  DEFAULT  | A single instance of the provider is shared across the entire application |
|  REQUEST  | A new instance of the provider is created exclusively for each incoming request. The instance is garbage-collected after the request completed |
| TRANSIENT | Each consumer that injects a transient provider will receive a new, dedicated instance |

### Provider Scope

```typescript
@Injectable({scope: Scope.REQUEST})
export calss CatsService{}
```

### Controller Scope

```typescript
@Controller({path: 'cats', scope: Scope.REQUEST})
export class CatsController{}
```

### Scope Hierarchy

Scope bubbles up the injection chain. A controller that depends on a request-scoped provider will, itself, be request-scoped

If `CatsController <- CatsService <- CatsRepo`, if the `CatsService` is request-scoped, the `CatsController` as well, but `CatsRepo` is unnecessary.

## Circular Dependency

A circular dependency occurs when two classes depend on each other

### Forward Reference

Use `forwardRef()` to resolve the circular dependencies

```typescript
@Injectable()
export class CatsService{
  constructor(@Inject(forwardRef()=> CommonService) private commonService: CommonService)
}

@Injectable()
export class CommonService{
  constructor(@Inject(forwardRef()=> CatsService) private catsService: CatsService)
}
```

## Module Reference

`ModuleRef` class is to navigate the internal list of providers and obtain reference to any provoder using its injection token as a lookup key.

## Excution Context

### ArgumentsHost

`ArgumentsHost` class provides methods for retrieving the arguments being passed to a handler.

When using `@nestjs/platform-express`, the host object encapsulate Express's `[request, response, next]` array.

For GraphQL applications, the host object contains the `[root, args, context, info]` array

* `getType()`

  return the type of application, e.g., http, rpc, graphql

* `getArgs()`

  retrieve the array of arguments being passed to the handler

  ```typescript
  const[req, res, next] = host.getArgs
  
  const request = host.getArgByIndex(0)
  ```

* `switchToRpc()`

*  `switchToWs()`

*  `switchToHttp()`

  ```typescript
  const ctx = host.switchToHttp(); // return an HttpArgumentsHost object
  const request = ctx.getRequest<Request>();
  const response = ctx.getResponse<Request>();
  ```

### ExecutionContext

`ExcecutionContext` extends `ArgumentsHost`

* `getClass<T>(): Type<T>`

  return the type of the controller class which the current handler blongs to

* `getHandler(): Function`

  return a reference to the handler that will be invoked next in the request pipeline

## Lifecycle Events

![img](https://docs.nestjs.com/assets/lifecycle-events.png)

|    Lifecycle hook method    |       Lifecycle event triggering the hook method call        |
| :-------------------------: | :----------------------------------------------------------: |
|       onModuleInit()        | called the once the host module's dependencis have been resolved |
|  onApplicationBootstrap()   | called once all modules have been initialized, but before listening for connction |
|      onModulDestrory()      |     called after a termination signal has been received      |
| beforeApplicationShutdown() | called after onModuleDestory() handlers completed<br>once complete, all exisiting connections will be closed |
|   onApplicationShutdown()   |           called after connections close resolves            |

## TypeORM

### Integration

```typescript
@Module({
	imports: [TypeOrmModule.forRoot({
    type:
    host:
    ...
  })]
})
```

Or, create an `ormconfig.json` file in the project root directory, and call `forRoot()` function directly

```typescript
@Module({
	imports: [TypeOrmModule.forRoot()]
})

export class AppModule{
  constructor(private connection: Connection)
}
```

### Repository Pattern

```typescript
@Entity()
export class CatEntity {
  @PrimaryGeneratedColumn()
  id: number;

  @Column()
  name: string;

  @Column({ default: true })
  isActive: boolean;
}
```

`forFeature()` method is to define which repositories are registered in the current scope.

```typescript
@Module({
  imports: [TypeOrmModule.forFeature([CatEntity])]
})
```

Use `InjectRepository()` decorator to inject repositories into services

```typescript
@Injectable()
export class CatsService {
  constructor(
  	@InjectRepository: Repository<CatEntity>,
  ){}
}
```

### Relations

`@OneToOne, @OneToMany, @ManyToOne, @ManyToOne`

### Auto-load Entities

Set `autoLoadEntities:true` in `forRoot()` function will automatically load every entity registered through `forFeature()`

### Separating Entity Definition

Define entities and their columns inside entity schemas

```typescript
export const UserSchema = new EntitySchema<User>({
  name: 'User',
  target: User,
  columns: {
    id: {
      type: Number,
      primary: true,
      generated: true,
    },
    firstName: {
      type: String,
    },
    lastName: {
      type: String,
    },
    isActive: {
      type: Boolean,
      default: true,
    },
  },
  relations: {
    photos: {
      type: 'one-to-many',
      target: 'Photo', // the name of the PhotoSchema
    },
  },
});
```