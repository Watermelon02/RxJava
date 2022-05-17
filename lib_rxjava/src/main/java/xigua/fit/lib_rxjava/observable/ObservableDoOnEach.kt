package xigua.fit.lib_rxjava.observable

import xigua.fit.lib_rxjava.observer.DoOnEachObserver
import xigua.fit.lib_rxjava.observer.Observer

/**
 * description ： TODO:类的作用
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/5/17 09:44
 */
class ObservableDoOnEach<T>(
    private val source: Observable<T>, private val onNext: ((T) -> Unit)? = null,
    private val onComplete: (() -> Unit)? = null,
    private val onError: (() -> Unit)? = null
) : Observable<T>() {
    override fun subscribeActual(observer: Observer<T>) {
        val doOnEachObserver = DoOnEachObserver(observer,onNext, onComplete, onError)
        observer.onSubscribe(doOnEachObserver)
        source.subscribe(doOnEachObserver)
    }
}