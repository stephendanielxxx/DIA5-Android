package app.training.android.utils

data class ViewState <out T>(val responseStatus: ResponseStatus, val data: T?, val message: String?){
    companion object{
        fun <T> success(data: T?): ViewState<T>{
            return ViewState(ResponseStatus.SUCCESS, data, null)
        }
        fun <T> error(message: String?): ViewState<T> {
            return ViewState(ResponseStatus.ERROR, null, message)
        }
        fun <T> empty(): ViewState<T> {
            return ViewState(ResponseStatus.EMPTY, null, null)
        }
        fun <T> loading(): ViewState<T> {
            return ViewState(ResponseStatus.LOADING, null, null)
        }
    }
}
