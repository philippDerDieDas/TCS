package de.tc_schoenningstedt.tcs;

import android.view.View;

/**
 * Created by philipp on 19.03.2016.
 */
class Person {
    String name;
    String age;
    int photoId;
    String job;
    String email;
    View.OnClickListener ec;

    Person(String name, String age, int photoId, String job, String email, View.OnClickListener ec) {
        this.name = name;
        this.age = age;
        this.photoId = photoId;
        this.job = job;
        this.email = email;
        this.ec = ec;
    }
}