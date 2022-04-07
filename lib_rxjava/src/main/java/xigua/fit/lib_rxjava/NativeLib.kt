package xigua.fit.lib_rxjava

class NativeLib {

    /**
     * A native method that is implemented by the 'lib_rxjava' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'lib_rxjava' library on application startup.
        init {
            System.loadLibrary("lib_rxjava")
        }
    }
}