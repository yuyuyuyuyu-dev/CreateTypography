package dev.yuyuyuyuyu.createtypography

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform