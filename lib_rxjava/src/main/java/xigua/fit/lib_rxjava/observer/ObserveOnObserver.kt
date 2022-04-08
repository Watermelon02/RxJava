package xigua.fit.lib_rxjava.observer

import android.util.Log
import xigua.fit.lib_rxjava.scheduler.Scheduler
import xigua.fit.rxjava.disposable.Disposable
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.LinkedBlockingQueue

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/4/8 22:15
 */
class ObserveOnObserver<T>(val worker: Scheduler.Worker, val actual: Observer<T>) : Observer<T>,
    Runnable {
    val queue = LinkedBlockingQueue<T>()
    override fun onSubscribe(disposable: Disposable) {
        actual.onSubscribe(disposable)
    }

    override fun onNext(t: T) {
        queue.add(t)
        worker.schedule(this)
    }

    override fun onComplete() {
        TODO("Not yet implemented")
    }

    override fun onError(throwable: Throwable) {
        TODO("Not yet implemented")
    }

    override fun run() {
        while (true) {
            val data = queue.poll() ?: break
            actual.onNext(data)
        }
    }
}