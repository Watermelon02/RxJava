package xigua.fit.lib_rxjava.emitter

/**
 * description ： TODO:类的作用
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/4/7 20:53
 */
interface Emitter<T>{
    fun onNext(t:T)
    fun onComplete()
    fun onError(throwable: Throwable)
}
interface ObservableEmitter<T>: Emitter<T> {
}