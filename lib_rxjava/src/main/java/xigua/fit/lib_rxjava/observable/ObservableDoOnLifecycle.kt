package xigua.fit.lib_rxjava.observable

import xigua.fit.lib_rxjava.observer.DoOnLifecycleObserver
import xigua.fit.lib_rxjava.observer.Observer

/**
 * description ： TODO:类的作用
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/5/17 09:26
 */
class ObservableDoOnLifecycle<T>(private val source:Observable<T>,private val onSubscribe:()->Unit) : Observable<T>() {
    override fun subscribeActual(observer: Observer<T>) {
        val doOnLifecycleObserver = DoOnLifecycleObserver(observer,onSubscribe)
        observer.onSubscribe(doOnLifecycleObserver)
       source.subscribe(doOnLifecycleObserver)
    }
}