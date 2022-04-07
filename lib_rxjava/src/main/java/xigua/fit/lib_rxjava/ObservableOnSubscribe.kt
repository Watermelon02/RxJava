package xigua.fit.lib_rxjava

import xigua.fit.lib_rxjava.emitter.ObservableEmitter

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/4/7 14:56
 */
abstract class ObservableOnSubscribe<T> {
    abstract fun subscribe(observableEmitter: ObservableEmitter<T>)
}