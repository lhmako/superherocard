package app.lhmako.domain.models

data class ID(val id: String) {
    constructor(id: Int) : this(id = id.toString())
}