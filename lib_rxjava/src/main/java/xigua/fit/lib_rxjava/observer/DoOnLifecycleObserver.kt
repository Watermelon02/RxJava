package xigua.fit.lib_rxjava.observer

import android.util.Log
import xigua.fit.rxjava.disposable.Disposable

/**
 * description ： TODO:类的作用
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/5/17 09:26
 */
class DoOnLifecycleObserver<T>(val observer: Observer<T>,
    private val onSubscribe: (() -> Unit)
) : Observer<T>, Disposable {
    override fun onSubscribe(disposable: Disposable) {
        onSubscribe.invoke()
    }

    override fun onNext(t: T) {
            observer.onNext(t)
    }

    override fun onComplete() {
    }

    override fun onError(throwable: Throwable) {
    }

    override fun dispose() {
        TODO("Not yet implemented")
    }

    override fun isDispose(): Boolean {
        TODO("Not yet implemented")
    }

}