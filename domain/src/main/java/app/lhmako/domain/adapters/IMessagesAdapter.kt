package app.lhmako.domain.adapters

interface IMessagesAdapter {
    val comicListEmpty: String
    val comicNotFound: String
    fun imagePathMalformed(path: String):String
}