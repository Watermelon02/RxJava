package xigua.fit.lib_rxjava.observable

import xigua.fit.lib_rxjava.observer.Observer
import xigua.fit.lib_rxjava.observer.SubscribeOnObserver
import xigua.fit.lib_rxjava.scheduler.Scheduler

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/4/9 15:22
 */
class ObservableSubscribeOn<T>(val source: Observable<T>, private val scheduler: Scheduler) :
    Observable<T>() {
    override fun subscribeActual(observer: Observer<T>) {
        val subscribeOnObserver = SubscribeOnObserver(observer)
        scheduler.scheduleActual(SubscribeTask(observer))
    }

    inner class SubscribeTask(val observer: Observer<T>) : Runnable {
        override fun run() {
            source.subscribe(observer)
        }
    }
}