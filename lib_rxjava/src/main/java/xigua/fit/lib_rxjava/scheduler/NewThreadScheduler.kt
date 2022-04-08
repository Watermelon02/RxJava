package xigua.fit.lib_rxjava.scheduler

import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/4/8 22:46
 */
class NewThreadScheduler: Scheduler() {
    private val threadPool = ThreadPoolExecutor(0, Int.MAX_VALUE,60,TimeUnit.SECONDS,SynchronousQueue())
    override fun createWorker(): Worker {
        return NewThreadWorker()
    }
    inner class NewThreadWorker: Worker() {
        override fun schedule(runnable: Runnable) {
            threadPool.submit(runnable)
        }
    }
}