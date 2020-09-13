## Eager init problem demo

Update context setup to use eager initialization of singletons:
`eagerInitSingletons(true)`

The context will fail to start with the following exception:

```
io.micronaut.context.exceptions.BeanInstantiationException: Bean definition [org.apache.kafka.clients.producer.KafkaProducer] could not be loaded: Error instantiating bean of type  [org.apache.kafka.clients.producer.KafkaProducer]

Message: Missing bean argument [AbstractKafkaProducerConfiguration producerConfiguration] for type: org.apache.kafka.clients.producer.KafkaProducer. Required arguments: AbstractKafkaProducerConfiguration producerConfiguration

	at io.micronaut.context.DefaultBeanContext.initializeContext(DefaultBeanContext.java:1540)
	at io.micronaut.context.DefaultApplicationContext.initializeContext(DefaultApplicationContext.java:220)
	at io.micronaut.context.DefaultBeanContext.readAllBeanDefinitionClasses(DefaultBeanContext.java:2771)
	at io.micronaut.context.DefaultBeanContext.start(DefaultBeanContext.java:228)
	at io.micronaut.context.DefaultApplicationContext.start(DefaultApplicationContext.java:166)
	at io.micronaut.test.extensions.AbstractMicronautExtension.startApplicationContext(AbstractMicronautExtension.java:325)
	at io.micronaut.test.extensions.AbstractMicronautExtension.beforeClass(AbstractMicronautExtension.java:223)
	at io.micronaut.test.extensions.junit5.MicronautJunit5Extension.beforeAll(MicronautJunit5Extension.java:52)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeBeforeAllCallbacks$7(ClassBasedTestDescriptor.java:359)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.invokeBeforeAllCallbacks(ClassBasedTestDescriptor.java:359)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.before(ClassBasedTestDescriptor.java:189)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.before(ClassBasedTestDescriptor.java:78)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:132)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:32)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:51)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:248)
	at org.junit.platform.launcher.core.DefaultLauncher.lambda$execute$5(DefaultLauncher.java:211)
	at org.junit.platform.launcher.core.DefaultLauncher.withInterceptedStreams(DefaultLauncher.java:226)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:199)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:132)
	at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.processAllTestClasses(JUnitPlatformTestClassProcessor.java:99)
	at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.access$000(JUnitPlatformTestClassProcessor.java:79)
	at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor.stop(JUnitPlatformTestClassProcessor.java:75)
	at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.stop(SuiteTestClassProcessor.java:61)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:567)
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:36)
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
	at org.gradle.internal.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:33)
	at org.gradle.internal.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:94)
	at com.sun.proxy.$Proxy2.stop(Unknown Source)
	at org.gradle.api.internal.tasks.testing.worker.TestWorker.stop(TestWorker.java:133)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:567)
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:36)
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
	at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:182)
	at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:164)
	at org.gradle.internal.remote.internal.hub.MessageHub$Handler.run(MessageHub.java:414)
	at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
	at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:48)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:56)
	at java.base/java.lang.Thread.run(Thread.java:830)
Caused by: io.micronaut.context.exceptions.BeanInstantiationException: Error instantiating bean of type  [org.apache.kafka.clients.producer.KafkaProducer]

Message: Missing bean argument [AbstractKafkaProducerConfiguration producerConfiguration] for type: org.apache.kafka.clients.producer.KafkaProducer. Required arguments: AbstractKafkaProducerConfiguration producerConfiguration

	at io.micronaut.context.DefaultBeanContext.doCreateBean(DefaultBeanContext.java:1860)
	at io.micronaut.context.DefaultBeanContext.createAndRegisterSingletonInternal(DefaultBeanContext.java:2638)
	at io.micronaut.context.DefaultBeanContext.loadContextScopeBean(DefaultBeanContext.java:2174)
	at io.micronaut.context.DefaultBeanContext.initializeContext(DefaultBeanContext.java:1538)
	... 67 more
```