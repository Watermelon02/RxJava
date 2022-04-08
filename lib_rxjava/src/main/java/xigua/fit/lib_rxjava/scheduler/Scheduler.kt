package xigua.fit.lib_rxjava.scheduler

import java.util.concurrent.TimeUnit

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/4/8 20:18
 */
abstract class Scheduler {
    abstract fun createWorker():Worker

    abstract inner class Worker{
        abstract fun schedule(runnable: Runnable)
    }
}