package com.example.learningfirebase;

public class InsertingValueToFirebase {
    String firstname;
    String lastname;
    String id;
    String email;
    String blood_group;

    public InsertingValueToFirebase(String a, String b, String c, String e, String blood)
    {

        firstname = a;
        lastname = b;
        id = c;
        email = e;
        blood_group = blood;

    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getBlood_group() {
        return blood_group;
    }
}
