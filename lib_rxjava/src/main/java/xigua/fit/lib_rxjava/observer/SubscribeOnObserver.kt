package xigua.fit.lib_rxjava.observer

import xigua.fit.rxjava.disposable.Disposable

/**
 * description ： TODO:类的作用
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/4/9 15:29
 */
class SubscribeOnObserver<T>(val observer: Observer<T>):Observer<T>,Disposable {
    override fun onSubscribe(disposable: Disposable) {
        observer.onSubscribe(disposable)
    }

    override fun onNext(t: T) {
        observer.onNext(t)
    }

    override fun onComplete() {
        TODO("Not yet implemented")
    }

    override fun onError(throwable: Throwable) {
        TODO("Not yet implemented")
    }

    override fun dispose() {
        TODO("Not yet implemented")
    }

    override fun isDispose(): Boolean {
        TODO("Not yet implemented")
    }
}