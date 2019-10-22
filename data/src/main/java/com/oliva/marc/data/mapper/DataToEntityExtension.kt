package com.oliva.marc.data.mapper

import com.oliva.marc.data.db.ContactData
import com.oliva.marc.domain.Entity.Entity

fun ContactData.Contact.map() = Entity.Contact(
    id= id,
    name = name,
    number = number
)


