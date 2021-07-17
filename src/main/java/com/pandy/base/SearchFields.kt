package com.pandy.base

enum class SearchFields(val filedName: String, val boostValue: Float) {
    DOC_CONTENT( "docContent", 1F),
    FILE_NAME( "fileName",2F),
    DOC_TAGS( "docTags", 2F),
    DOC_TITLE( "docTitle", 2F),
    DOC_AUTHOR( "docAuthor", 2F),
    DOC_MODIFIER( "docModifier", 2F),
    DOC_CREATOR( "docCreator", 2F),
    DOC_CONTENT_TYPE( "docContentType", 2F),
    SECRET_LEVEL( "secretLevel", 2F),
}

fun main() {
    SearchFields.values().forEach {
        println(it.filedName)
    }
}
