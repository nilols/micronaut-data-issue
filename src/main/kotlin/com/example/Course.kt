package com.example

import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation
import io.micronaut.serde.annotation.Serdeable
import java.util.UUID

@Serdeable
@MappedEntity
data class Course(

    @field:Id
    val id: UUID,

    val name: String,

    @Relation(value = Relation.Kind.MANY_TO_MANY, mappedBy = "courses", cascade = [Relation.Cascade.ALL])
    val students: List<Student>
)