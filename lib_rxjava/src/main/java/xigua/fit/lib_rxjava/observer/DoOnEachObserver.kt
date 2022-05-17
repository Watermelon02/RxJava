package xigua.fit.lib_rxjava.observer

/**
 * description ： TODO:类的作用
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/5/17 09:40
 */
class DoOnEachObserver(
    private val onNext: (() -> Unit)? = null,
    private val onComplete: (() -> Unit)? = null,
    private val onError: (() -> Unit)? = null
) {
}