package xigua.fit.lib_rxjava

import xigua.fit.lib_rxjava.emitter.CreateEmitter
import java.lang.Exception

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/4/7 15:01
 */
class ObservableCreate<T>(private val source: ObservableOnSubscribe<T>): Observable<T>() {

    override fun subscribeActual(observer: Observer<T>) {
        val parent = CreateEmitter(observer)
        observer.onSubscribe(parent)
        try {
            source.subscribe(parent)
        }catch (e:Exception){
            parent.onError(e)
        }
    }
}