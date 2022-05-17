package xigua.fit.lib_rxjava.observer

import xigua.fit.rxjava.disposable.Disposable

/**
 * description ： TODO:类的作用
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/5/17 09:40
 */
class DoOnEachObserver<T>(val observer: Observer<T>,
    private val onNext: ((T) -> Unit)? = null,
    private val onComplete: (() -> Unit)? = null,
    private val onError: (() -> Unit)? = null
):Observer<T>,Disposable {
    override fun onSubscribe(disposable: Disposable) {
    }

    override fun onNext(t: T) {
        onNext?.invoke(t)
        observer.onNext(t)
    }

    override fun onComplete() {
        onComplete?.invoke()
    }

    override fun onError(throwable: Throwable) {
        onError?.invoke()
    }

    override fun dispose() {
    }

    override fun isDispose(): Boolean {
        TODO("Not yet implemented")
    }

}