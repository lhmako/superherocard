package app.lhmako.domain.business.rules

import app.lhmako.domain.models.ID

fun ID.toInt() {
    id.toInt()
}

fun ID.isEmpty(): Boolean {
    return id.isEmpty()
}