package xigua.fit.lib_rxjava.observable

import xigua.fit.lib_rxjava.observer.ObserveOnObserver
import xigua.fit.lib_rxjava.observer.Observer
import xigua.fit.lib_rxjava.scheduler.Scheduler

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/4/8 22:02
 * @param source 源码里应该是ObserveSource类，此处从简
 */
class ObservableObserveOn<T>(private val source:Observable<T>, private val scheduler: Scheduler): Observable<T>() {
    override fun subscribeActual(observer: Observer<T>) {
        val worker = scheduler.createWorker()
        source.subscribe(ObserveOnObserver(worker,observer))
    }
}