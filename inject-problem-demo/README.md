## @Inject problem demo

Looks like the presence of @Inject annotation on any field of the class causes micronaut annotation
processor to create BeanDefinition (with @Prototype scope) even if no annotation is specified on the class.

Moreover, if this bean is created by @Factory then 2 separate bean definitions are generated and the app
fails with *"Multiple possible bean candidates found"* error

