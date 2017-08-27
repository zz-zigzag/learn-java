

# java 注解
``` java
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
	String value();
}
```
## 元注解

1. @Target: 注解的作用域，包含METHOD（方法）, TYPE（类，接口）等。
1. @Retention: 生命周期，包含RUNTIME，SOURCE，CLASS
1. @Inherited： 允许子类集成
1. @Document: 生成java-doc时包含

## 注意
- 只有一个变量时，必须命名为value