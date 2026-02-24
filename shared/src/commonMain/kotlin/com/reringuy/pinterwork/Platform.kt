package com.reringuy.pinterwork

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform