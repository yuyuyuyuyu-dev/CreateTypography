package dev.yuyuyuyuyu.createtypography.example.multiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform