package com.dev.tvmania.view.util

fun String.removeHtmlTags(): String{
    return Regex(pattern = "<\\w+>|<\\w+>").replace(this, "")
}