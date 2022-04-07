package xigua.fit.lib_rxjava

import xigua.fit.rxjava.disposable.Disposable

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/4/7 15:03
 */
interface Observer<T> {
    fun onSubscribe(disposable: Disposable)
    fun onNext(t:T)
    fun onComplete()
    fun onError(throwable: Throwable)
}