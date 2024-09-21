package com.example

import com.example.course.Course
import com.example.course.CourseRepository
import com.example.student.Student
import com.example.student.StudentId
import com.example.student.StudentRepository
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.equals.shouldBeEqual
import java.util.*

@MicronautTest
class MicronautDataIssueTest(
    private val courseRepository: CourseRepository,
    private val studentRepository: StudentRepository
): StringSpec({

    "works - should create a student" {
        val student = Student(
            id = StudentId(UUID.randomUUID()),
            name = "test",
            courses = emptyList()
        )
        studentRepository.save(student)
        studentRepository.findById(student.id)!! shouldBeEqual student
    }

    "fails - should find students attending a course" {
        // create a new course
        val course = Course(
            id = UUID.randomUUID(),
            name = "computer science",
            students = emptyList()
        )
        courseRepository.save(course)

        // create a new student and join the existing course
        val student = Student(
            id = StudentId(UUID.randomUUID()),
            name = "test",
            courses = listOf(course)
        )
        studentRepository.save(student) shouldBeEqual student

        // we should now be able to find the student that attends the course
        courseRepository.findStudentsById(course.id)[0].name shouldBeEqual student.name
    }
})
