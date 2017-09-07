

# Some demo for learning java.

## Content

1. [注解](注解)
2. [AOP](#AOP)



##  [注解](annotation)

> http://www.imooc.com/learn/456


#### 元注解
``` java
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
	String value();
}
```

1. @Target: 注解的作用域，包含METHOD（方法）, TYPE（类，接口）等。
2. @Retention: 生命周期，包含RUNTIME，SOURCE，CLASS
3. @Inherited： 允许子类集成
4. @Document: 生成java-doc时包含

#### 注意
- 只有一个变量时，必须命名为value


## [AOP](aop)

> http://www.imooc.com/video/15677
>
> https://my.oschina.net/itblog/blog/211693

### Pointcut express

#### designators(指示器)

##### execution()：匹配方法

- modifer ? （标注问号的可以省略）
- ret-type
- declaring-type
- name
- throws ?

```java
// *: 任意类型、任意字符串
@Pointcut("execution(public String site.xiaodong.service..*Service.*(Long))")
public void matchCondition() {}

@Pointcut("execution(* site.xiaodong.service.*Service.*())")
public void matchCondition() {}

@Pointcut("execution(* site.xiaodong.service..*Service.*(*) throws java.lang.IllegalAccessException)")
public void matchCondition() {}

@Pointcut("execution(* site.xiaodong.service..*.*(..) throws * )")
public void matchCondition() {}
```
execution功能最全面，可以覆盖下面大多数的功能。

##### within()：匹配包和类

```java
@Pointcut("within(site.xiaodong.service..*Service)")
public void matchType(){}

@Pointcut("within(site.xiaodong.service..*)")
public void matchPackage(){}
```
##### this(), bean(), target()：匹配对象

```java
//匹配实现DemoDao类的方法，若DemoDao为接口，匹配实现此接口的类的方法
@Pointcut("this(site.xiaodong.DemoDao*)")
public void matchCondition(){}

//和this不同的是，target不能拦截DeclareParents(Introduction)
@Pointcut("target(site.xiaodong.DemoDao*)")
public void matchCondition(){}

//匹配以Service结尾的bean的方法
@Pointcut("bean(*Service)")
public void matchCondition(){}
```

##### args()：匹配参数

```java
//匹配只有一个Long参数类型的方法
@Pointcut("args(Long) && within(site.xiaodong.service..*)")
public void matchArgs(){}

//匹配第一个参数为Long的方法
@Pointcut("args(Long, ..)")
public void matchArgs(){}
```
##### @target(), @args(), @within(), @annoation()：匹配注解

```java
//匹配此含有此注解的方法
@Pointcut("@annotation(site.xiaodong.anno.TestAnno)")
public void matchAnno() {}

//匹配此含有此注解的类的方法（class级别）
@Pointcut("@within(site.xiaodong.anno.ClassAnno)")
public void matchAnno() {}

//匹配此含有此注解的类及子类的方法（runtime级别）
@Pointcut("@target(site.xiaodong.anno.ClassAnno) && within(site.xiaodong..*)")
public void matchAnno() {}

//匹配传入的参数类标注有Repository注解的方法
@Pointcut("@args(site.xiaodong.anno.TypeAnno)")
public void matchAnno() {}
```
#### wildcards

- *：任意类型
- +：指定类及其子类
- ..：任意数的子包或参数


#### operators

  - &&
  - ||
  - !


### Advice

#### @Before

```java
// 匹配此execution，同时只含有一个参数的方法
@Before("execution(* site.xiaodong...(..)) && args(a)")
public void log(Object a) {}
```
#### @After

#### @AfterReturning

````java
@AfterReturning(value="matchException()", returing="result")
public void afterReturn(Object result) {}
````
#### @AfterThrowing

```java
@AfterThrowing(value="matchException()", throwing="exception")
public void afterThrowing(Exception exception) {}
```
#### @Around

```java
@Around("match()")
public  Object Around(ProceedingJoinPoint joinPoint) {	
	Object result = null;
	try {
		result = joinPoint.proceed(joinPoint.getArgs());
		System.out.println("#### return ");
	} catch (Throwable e) {
		System.out.println("#### exception");
		e.printStackTrace();
	} finally {
		System.out.println("#### finally");
	}
	return result;
}
```
#### Notes

- @Advice上可以直接使用切点表达式，从而省略@Pointcut
- @Advice上的`args()`和`@Pointcut`的意思有所不同，见[Advice](#@Before)

