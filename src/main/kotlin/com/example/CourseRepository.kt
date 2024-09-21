package com.example

import io.micronaut.data.annotation.Join
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.r2dbc.annotation.R2dbcRepository
import io.micronaut.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

@R2dbcRepository(dialect = Dialect.POSTGRES)
interface CourseRepository : CoroutineCrudRepository<Course, UUID> {

    @Join("students")
    suspend fun findStudentsById(id: UUID): List<Student>
}
