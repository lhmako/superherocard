package app.lhmako.domain.business.rules

import app.lhmako.domain.models.ComicModel

fun ComicModel.isEmpty(): Boolean {
    return id.isEmpty() || title.isEmpty() || image.isEmpty()
}