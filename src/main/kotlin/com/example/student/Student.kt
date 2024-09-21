package com.example.student

import com.example.course.Course
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.MappedProperty
import io.micronaut.data.annotation.Relation
import io.micronaut.data.annotation.Relation.Cascade.ALL
import io.micronaut.data.annotation.Relation.Kind.MANY_TO_MANY

@MappedEntity
data class Student(

    @field:Id
    @field:MappedProperty(converter = StudentIdAttributeConverter::class)
    val id: StudentId,

    val name: String,

    @Relation(value = MANY_TO_MANY, cascade = [ALL])
    val courses: List<Course>
)