package app.lhmako.data.retrofit.configuration

open class Endpoint(
    val url: String
) {
    object PostmanMocking : Endpoint("https://182ff552-b890-4332-b237-4934a20186a0.mock.pstmn.io/")
    object Marvel : Endpoint("https://gateway.marvel.com/v1/public/")
}