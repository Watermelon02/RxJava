package xigua.fit.lib_rxjava.disposable

import xigua.fit.rxjava.disposable.Disposable

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/4/7 21:13
 */
class DisposableHelper: Disposable {
    override fun dispose() {
    }

    override fun isDispose(): Boolean {
        return true
    }
}