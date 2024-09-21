package com.example

import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.MappedProperty
import io.micronaut.data.annotation.Relation
import io.micronaut.data.model.DataType
import io.micronaut.serde.annotation.Serdeable

@Serdeable
@MappedEntity
data class Student(

    @field:Id
    @field:MappedProperty(type = DataType.OBJECT, converter = StudentIdEntityConverter::class)
    val id: StudentId,

    val name: String,

    @Relation(value = Relation.Kind.MANY_TO_MANY, cascade = [Relation.Cascade.ALL])
    val courses: List<Course>
)