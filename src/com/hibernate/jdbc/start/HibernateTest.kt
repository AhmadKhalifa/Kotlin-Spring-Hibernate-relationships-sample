package com.hibernate.jdbc.start

import com.hibernate.jdbc.start.entity.Student
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration

val sessionFactory: SessionFactory = Configuration()
        .configure("hibernate.config.xml")
        .addAnnotatedClass(Student::class.java)
        .buildSessionFactory()

fun main() = sessionFactory.use {
    with(sessionFactory.currentSession) {
        beginTransaction()
//        val id = save(Student(firstName = "Ahmad", lastName = "Khalifa", email = "Ahmed@gmail.com")).toString().toInt()
//        val student = get(Student::class.java, id)

//        save(Student(firstName = "Hager", lastName = "Gamal", email = "Ahmed@fci.com"))
//        save(Student(firstName = "Sherif", lastName = "Hassan", email = "wahdan@fci.com"))
//        save(Student(firstName = "Rawan", lastName = "Ali", email = "rawan@gmail.com"))
//        save(Student(firstName = "Salma", lastName = "Ahmed", email = "salma@gmail.com"))
//        save(Student(firstName = "Mahmoud", lastName = "Gamal", email = "gamal@gmail.com"))
//        val students = createQuery("from Student s where s.firstName='Hager' OR s.lastName='Hassan'").list().map { it as Student }

//        val students = createQuery("from Student s where s.email like '%fci.com'").list().map { it as Student }

//        students.map { it.apply { email = "${it.firstName}@fci.com" } }
//        students.forEach(::println)
//        students.map { it.apply { email = "${it.firstName}@gmail.com}" } }
//        createQuery("update Student set email='foo@gmail.com'").executeUpdate()

//        delete(get(Student::class.java, 3))
//        createQuery("DELETE FROM Student WHERE firstName='Ahmad'").executeUpdate()
        flush()
        transaction.commit()
        close()
    }
}

