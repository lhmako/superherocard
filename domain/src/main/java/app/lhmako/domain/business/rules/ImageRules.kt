package app.lhmako.domain.business.rules

import app.lhmako.domain.models.ImageModel
import java.net.URL

fun ImageModel.isEmpty(): Boolean {
    return id.isEmpty() || path.isEmpty() || extension.isEmpty()
}

fun ImageModel.isPathValidated(): Boolean {
    return try {
        URL(path)
        true
    } catch (e: Exception) {
        false
    }
}