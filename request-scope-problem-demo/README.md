## RequestScope beans problem demo

RequestScope beans should be disposed automatically at the end of HTTP Request processing, 
and their preDestroy methods should be invoked.

It works fine if the bean's class itself is annotated with @RequestScope and contains method annotated with @PreDestroy.

However, if the bean is created by a factory, even if factory method has **@Bean(preDestroy="method_name")**,
then this method is never called.

In my example here CalcService works fine:
```java
@RequestScope
public class CalcService implements RequestAware {
//...
    @PreDestroy
    void cleanup() {
       //...
    }
//...
}
```

but cleanup method is not called in the ReportService created by MyFactory
```java
@Factory
public class MyFactory {
    @RequestScope
    @Bean(preDestroy = "cleanup")
    public ReportService reportService(ResourceCleaner resourceCleaner) {
        return new ReportService(resourceCleaner);
    }
}
```

*Execute RequestScopeProblemDemoTest to reproduce the problem*

Looks like the root cause is that bean definitions created by factories do not implement 
DisposableBeanDefinition interface. So RequestCustomScope never calls "dispose" method (see 
io.micronaut.runtime.http.scope.RequestCustomScope.java:113)