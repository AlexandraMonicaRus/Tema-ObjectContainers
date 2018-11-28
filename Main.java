package com.assignment5.java;


import java.util.*;

public class Main {
    public static void main(String[] args) {

        // TreeSet part
        List<Person> peopleList = new ArrayList<>();

        peopleList.add(new Student("Gina", 19, "1234"));
        peopleList.add(new Employee("George", 30, "4567"));
        peopleList.add(new Unemployed("Casian", 27, "6789"));
        peopleList.add(new Student("Melinda", 20, "3251"));
        peopleList.add(new Employee("Sofia", 30, "1234"));
        peopleList.add(new Unemployed("Carol", 40, "9876"));

        TreeSet<Person> orderByNameSet = new TreeSet<>(new NameComparator());
        orderByNameSet.addAll(peopleList);

        System.out.println("List of persons ordered by name is: ");
        for (Object object : orderByNameSet) {
            Person person = (Person) object;
            System.out.println(person.getName() + " " + person.getAge() + "\n");
        }

        TreeSet<Person> orderByAgeSet = new TreeSet<>(new AgeComparator());
        orderByAgeSet.addAll(peopleList);

        System.out.println("List of persons ordered by age is:");
        for (Object object : orderByAgeSet) {
            Person person = (Person) object;
            System.out.println(person.getAge() + " " + person.getName() + "\n");
        }

        // HashMap part
        HashMap<Person, List<Hobby>> hmap = populateHashmap(peopleList);

        for (Object o : hmap.entrySet()) {
            Map.Entry personEntry = (Map.Entry) o;
            Person person = (Person) personEntry.getKey();

            System.out.println("\n" + "The list of hobbies for " + person.getName() + " are:");

            List<Hobby> hobbies = (List<Hobby>) personEntry.getValue();
            for (Hobby hobby : hobbies) {
                for (Address address : hobby.getAddresses()) {
                    System.out.println(hobby.getHobbyName() + " where can be practiced in: " + address.getCountry()
                            + ", " + address.getCity() + ", " + address.getStreet() + ", " + address.getNumber());
                }
            }
        }
    }

    private static HashMap<Person, List<Hobby>> populateHashmap(List<Person> persons) {

        HashMap<Person, List<Hobby>> hmap = new HashMap<>();

        //Create first hobbyList
        List<Hobby> hobbies = new ArrayList<>();

        Address icelandAddress = new Address("Iceland", "Akureyri", "Skipagata", "14A");
        Address southKoreaAddress = new Address("South Korea", "Seoul", "Myeongdong", "128C");
        Address chinaAddress = new Address("China", "Beijing", "Wangfujing", "1");

        List<Address> photographyAddressList = new ArrayList<>();
        photographyAddressList.add(icelandAddress);
        photographyAddressList.add(southKoreaAddress);
        photographyAddressList.add(chinaAddress);

        List<Address> karaokeAddressList = new ArrayList<>();
        karaokeAddressList.add(southKoreaAddress);
        karaokeAddressList.add(chinaAddress);

        List<Address> hikingAddressList = new ArrayList<>();
        hikingAddressList.add(chinaAddress);

        Hobby hobbyPhotography = new Hobby("photography", 20, photographyAddressList);
        Hobby hobbyKaraoke = new Hobby("karaoke", 30, karaokeAddressList);
        Hobby hobbyHiking = new Hobby("hiking", 5, hikingAddressList);

        hobbies.add(hobbyPhotography);
        hobbies.add(hobbyKaraoke);
        hobbies.add(hobbyHiking);

        hmap.put(persons.get(0), hobbies);

        //Create second hobbyList
        hobbies = new ArrayList<>();

        Address germanydAddress = new Address("Germany", "Munchen", "StephanStrasse", "14A");
        Address austriaAddress = new Address("Austria", "Vienna", "MariaStrasse", "128C");
        Address romanieAddress = new Address("Romania", "Cluj", "BunaZiua", "37D");

        List<Address> dancingAddressList = new ArrayList<>();
        dancingAddressList.add(germanydAddress);
        dancingAddressList.add(austriaAddress);

        List<Address> singingAddressList = new ArrayList<>();
        singingAddressList.add(romanieAddress);
        singingAddressList.add(austriaAddress);

        Hobby hobbyDancing = new Hobby("dancing", 10, dancingAddressList);
        Hobby hobbySinging = new Hobby("singing", 3, singingAddressList);

        hobbies.add(hobbyDancing);
        hobbies.add(hobbySinging);

        hmap.put(persons.get(1), hobbies);

        return hmap;
    }

}
