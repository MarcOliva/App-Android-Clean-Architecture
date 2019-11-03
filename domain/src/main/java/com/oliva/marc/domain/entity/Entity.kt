package com.oliva.marc.domain.entity

sealed class Entity {
    data class Contact(
        var id: Int,
        var name: String,
        var number: String
    ): Entity()
}