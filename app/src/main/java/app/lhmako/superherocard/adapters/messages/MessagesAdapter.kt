package app.lhmako.superherocard.adapters.messages

import android.content.Context
import app.lhmako.domain.adapters.IMessagesAdapter
import app.lhmako.superherocard.R

class MessagesAdapter(
    private val context: Context
) : IMessagesAdapter {

    override val comicListEmpty: String by lazy {
        context.getString(R.string.comic_list_empty)
    }

    override val comicNotFound: String by lazy {
        context.getString(R.string.comic_list_empty)
    }

    override fun imagePathMalformed(path: String): String {
        return context.getString(R.string.image_path_malformed, path)
    }
}