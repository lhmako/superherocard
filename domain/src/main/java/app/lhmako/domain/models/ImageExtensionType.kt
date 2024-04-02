package app.lhmako.domain.models

enum class ImageExtensionType(val ext: String) {

    NAN(""),
    JPG("jpg"),
    JPEG("jpeg"),
    PNG("png");

    fun isEmpty(): Boolean {
        return this == NAN
    }
}