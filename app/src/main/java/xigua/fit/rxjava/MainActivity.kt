package xigua.fit.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Scheduler
import io.reactivex.internal.operators.observable.ObservableSubscribeOn
import io.reactivex.schedulers.Schedulers
import xigua.fit.lib_rxjava.observable.Observable
import xigua.fit.lib_rxjava.observable.ObservableObserveOn
import xigua.fit.lib_rxjava.observer.Observer
import xigua.fit.lib_rxjava.scheduler.NewThreadScheduler
import xigua.fit.rxjava.disposable.Disposable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Observable.create(object : xigua.fit.lib_rxjava.ObservableOnSubscribe<Int>() {
            override fun subscribe(observableEmitter: xigua.fit.lib_rxjava.emitter.ObservableEmitter<Int>) {
                Log.d("testTag", "subscribe:${Thread.currentThread()} ")
                observableEmitter.onNext(1)
            }
        })
            .subscribeOn(NewThreadScheduler())
            .observeOn(NewThreadScheduler())
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(disposable: Disposable) {
                    Log.d("testTag", "onSubscribe:${Thread.currentThread()}")
                }

                override fun onNext(t: Int) {
                    Log.d("testTag", "obNext:${Thread.currentThread()}")
                }

                override fun onComplete() {
                    TODO("Not yet implemented")
                }

                override fun onError(throwable: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        io.reactivex.Observable.create(ObservableOnSubscribe<Int> { TODO("Not yet implemented") }).subscribe()
    }
}