package app.lhmako.data.retrofit.configuration

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilderAdapter(
    private val endpoint: Endpoint
) {

    private val builder by lazy {
        Retrofit.Builder()
            .baseUrl(endpoint.url)
            .addConverterFactory(GsonConverterFactory.create())
    }

    fun config(intercept: (Retrofit.Builder) -> Unit) {
        intercept(builder)
    }

    fun build(): Retrofit {
        return builder.build()
    }
}