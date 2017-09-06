

## Some demo for learning java.

##  [注解学习](annotation)

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

### Pointcut express

- designators(指示器)

  - execution()：匹配方法（标注问号的可以省略）

    - modifer ?
    - ret-type
    - declaring-type
    - name
    - throws

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

    ​

    ​

    - ​

  - within()：匹配包和类

    ```java
    @Pointcut("within(site.xiaodong.service..*Service)")
    public void matchType(){}

    @Pointcut("within(site.xiaodong.service..*)")
    public void matchPackage(){}
    ```

  - this(), bean(), target()：匹配对象

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

    ​

  - args()：匹配参数

    ```java
    //匹配只有一个Long参数类型的方法
    @Pointcut("args(Long) && within(site.xiaodong.service..*)")
    public void matchArgs(){}

    //匹配第一个参数为Long的方法
    @Pointcut("args(Long, ..)")
    public void matchArgs(){}
    ```

  - @target(), @args(), @within(), @annoation()：匹配注解
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

- wildcards

  - *：任意类型
  - +：指定类及其子类
  - ..：任意数的子包或参数

- operators

  - &&
  - ||
  - !


- advice



