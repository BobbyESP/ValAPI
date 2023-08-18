package com.bobbyesp.valapi.library.util.throwables

class ValAPIParsingError(message: String, val errorCode: Int, val response: String) : Throwable(message) {
    override fun toString(): String {
        return "ValAPIParsingError(errorCode=$errorCode, response='$response', message='$message')"
    }
}
