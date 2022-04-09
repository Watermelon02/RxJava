package xigua.fit.lib_rxjava.observable

import xigua.fit.lib_rxjava.ObservableOnSubscribe
import xigua.fit.lib_rxjava.observer.Observer
import xigua.fit.lib_rxjava.scheduler.Scheduler

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/4/7 14:54
 */
abstract class Observable<T> {
    companion object{
        fun <T>create(source: ObservableOnSubscribe<T>): Observable<T> {
            return ObservableCreate(source)
        }
    }

    fun subscribe(observer: Observer<T>){
        subscribeActual(observer)
    }

    abstract fun subscribeActual(observer: Observer<T>)

    fun observeOn(scheduler: Scheduler):Observable<T>{
        return ObservableObserveOn(this,scheduler)
    }

    fun subscribeOn(scheduler: Scheduler):Observable<T>{
        return ObservableSubscribeOn(this,scheduler)
    }
}