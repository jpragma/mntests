## MockBean is created twice in library projects  

In library projects without explicit micronaut-runtime dependency, method annotated with @MockBean is invoked twice.
Two different mock instances are injected into the test (Spock Specification) and into the actual bean-under-test.
As a result invocation validation fails.

#### Steps to reproduce:
- Run MyServiceImplTest. It fails with following message:
```
Too few invocations for:

1 * mockGreeter.greetInEnglish(_) >> "Hey there"   (0 invocations)

Unmatched invocations (ordered by similarity):

1 * <Greeter>.greetInEnglish('World')
instance == target
|        |  |
|        |  Mock for type 'Greeter'
|        false
|        0 differences (100% similarity)
|        Mock for type 'Greeter'
|        Mock for type 'Greeter'
Mock for type 'Greeter'
```
Also note that `*** creating mock` is printed twice in the console.

#### Workaround
- Uncomment the following line in `build.gradle`
```
//    testImplementation("io.micronaut:micronaut-runtime")
```
- Re-run the test - now it passes

#### Notes

This behaviour is very strange since micronaut-runtime is still included in the testRuntimeClasspath
as transitive dependency of `io.micronaut.test:micronaut-test-spock`



