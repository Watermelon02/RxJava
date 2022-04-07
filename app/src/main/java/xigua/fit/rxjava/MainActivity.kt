package xigua.fit.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xigua.fit.lib_rxjava.Observable
import xigua.fit.lib_rxjava.Observer
import xigua.fit.rxjava.disposable.Disposable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Observable.create(object :xigua.fit.lib_rxjava.ObservableOnSubscribe<Int>(){
            override fun subscribe(observableEmitter: xigua.fit.lib_rxjava.emitter.ObservableEmitter<Int>) {
                TODO("Not yet implemented")
            }
        }).subscribe(object : Observer<Int> {
            override fun onSubscribe(disposable: Disposable) {
                TODO("Not yet implemented")
            }

            override fun onNext(t: Int) {
                TODO("Not yet implemented")
            }

            override fun onComplete() {
                TODO("Not yet implemented")
            }

            override fun onError(throwable: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}