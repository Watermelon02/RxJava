package xigua.fit.lib_rxjava.emitter

import xigua.fit.lib_rxjava.Observer
import xigua.fit.rxjava.disposable.Disposable
import xigua.fit.lib_rxjava.disposable.DisposableHelper
import java.util.concurrent.atomic.AtomicReference

/**
 * description ： TODO:类的作用
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/4/7 14:57
 */
class CreateEmitter<T>(private val observer: Observer<T>): Disposable, ObservableEmitter<T> {
    private var disposable = AtomicReference<Disposable>(this)
    private val disposed = DisposableHelper()
    override fun dispose() {
        disposable.set(disposed)
    }

    override fun isDispose(): Boolean {
        return disposable.get() == disposed
    }

    override fun onNext(t:T) {
        if (!isDispose()){
            observer.onNext(t)
        }
    }

    override fun onComplete() {
        if (!isDispose()){
            observer.onComplete()
        }
    }

    override fun onError(throwable: Throwable) {
        if (!isDispose()){
            observer.onError(throwable)
        }
    }

}