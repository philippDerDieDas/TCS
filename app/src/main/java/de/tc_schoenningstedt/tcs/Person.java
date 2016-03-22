package de.tc_schoenningstedt.tcs;

/**
 * Created by philipp on 19.03.2016.
 */
class Person {
    String name;
    String age;
    int photoId;
    String job;
    String email;

    Person(String name, String age, int photoId, String job, String email) {
        this.name = name;
        this.age = age;
        this.photoId = photoId;
        this.job = job;
        this.email = email;
    }
}