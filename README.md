# multiple-module-dagger-2

Created with purpose to separate all Modules into independent module, easy to maintain, testing and develop.

### Easy Test
For some reason, there are several issue for testing separate modules while using dependency injection(Dagger). Each module has to create mocking dagger modules and component/s.

But, with Dagger 2 Android all the pain setup could be gone by simpy intercept the injection process.

##### Easy mock
activity test easy as it looks : 
```kotlin
@get:Rule
val rule = InjectedActivityTestRule(YourActivity::class.java,
            dispatchingActivity<YourActivity> {
                it.presenter = mock()
            })
```



## Build with :  
- [Dagger 2](https://github.com/google/dagger) for dependency injection (DI)
- [Retrofit](https://square.github.io/retrofit/) for network calls
- [OkHttp](http://square.github.io/okhttp/) for network interceptor(Debugging and so on)
- [RxJava 2](https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0) for reactive programming


## this project original source : [Here](https://github.com/kidnapsteal/multiple-module-dagger-2)
as i lost the credential and cant recover, i've decided to move the project here to my current github account
