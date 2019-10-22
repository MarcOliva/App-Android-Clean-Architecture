package com.oliva.marc.domain.Entity

sealed class Entity {
    data class Contact(
        var id: Int = 0,
        var name: String = "",
        var number: String = ""
    ): Entity()
}