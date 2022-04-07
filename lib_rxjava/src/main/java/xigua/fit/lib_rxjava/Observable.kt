package xigua.fit.lib_rxjava

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/4/7 14:54
 */
abstract class Observable<T> {
    companion object{
        fun <T>create(source: ObservableOnSubscribe<T>): Observable<T> {
            return ObservableCreate(source)
        }
    }

    fun subscribe(observer: Observer<T>){
        subscribeActual(observer)
    }

    abstract fun subscribeActual(observer: Observer<T>)
}