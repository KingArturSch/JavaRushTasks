package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        DateFormat dateFormatPrt = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


        switch (args[0]) {
            case "-c":
                for (int i = 1; i < args.length; i += 3) {
                    Date date = null;
                    try {
                        date = dateFormat.parse(args[i + 2]);
                    } catch (ParseException e) {
                        e.getMessage();
                    }
                    if (args[i + 1].startsWith("м")) {
                        Person person = Person.createMale(args[i], date);
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    } else {
                        Person person = Person.createFemale(args[i], date);
                        synchronized (allPeople) {
                            allPeople.add(person);
                        }
                        System.out.println(allPeople.indexOf(person));
                    }
                }

                break;
            case "-u":
                synchronized (allPeople){
                for (int i = 1; i < args.length; i += 4) {
                    int index = Integer.parseInt(args[i]);
                    Person person = allPeople.get(index);
                    person.setName(args[i + 1]);
                    Date date = null;
                    try {
                        date = dateFormat.parse(args[i + 3]);

                    } catch (ParseException e) {
                        e.getMessage();
                    }
                    person.setBirthDay(date);
                    if (args[i + 2].startsWith("м"))
                        person.setSex(Sex.MALE);
                    else
                        person.setSex(Sex.FEMALE);
                }}
                break;
            case "-d":
                synchronized (allPeople) {
                for (int i = 1; i < args.length; i++) {
                    int index = Integer.parseInt(args[i]);
                    Person person = allPeople.get(index);
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDay(null);
                }}
                break;
            case "-i":
                synchronized (allPeople) {
                for (int i = 1; i < args.length; i++) {
                    int index = Integer.parseInt(args[i]);
                    Person person = allPeople.get(index);
                    StringBuffer s = new StringBuffer();
                    s.append(person.getName());
                    s.append(" ");
                    s.append(person.getSex() == Sex.MALE ? "м" : "ж");
                    s.append(" ");
                    s.append(dateFormatPrt.format(person.getBirthDay()));
                    System.out.println(s);
                }}
                break;
        }
    }

}

//        if (args[0].startsWith("-c")) {
//            for (int i = 1; i < args.length; i= i+3) {
//                Date date = null;
//                try {
//                    date = dateFormat.parse(args[i+2]);
//                } catch (ParseException e) {
//                    e.getMessage();
//                }
//                if (args[i+1].startsWith("м")) {
//                    Person person = Person.createMale(args[i], date);
//                    allPeople.add(person);
//                    System.out.println(allPeople.indexOf(person));
//                } else {
//                    Person person = Person.createFemale(args[i], date);
//                    allPeople.add(person);
//                    System.out.println(allPeople.indexOf(person));
//                }
//            }
//        }

//        if (args[0].startsWith("-u")) {
//            for (int i = 1; i < args.length; i= i+4) {
//                int index = Integer.parseInt(args[i]);
//                Person person = allPeople.get(index);
//                person.setName(args[i+1]);
//                Date date = null;
//                try {
//                    date = dateFormat.parse(args[i+3]);
//
//                } catch (ParseException e) {
//                    e.getMessage();
//                }
//                person.setBirthDay(date);
//                if (args[i+2].startsWith("м"))
//                    person.setSex(Sex.MALE);
//                else
//                    person.setSex(Sex.FEMALE);
//            }
//        }

//        if (args[0].startsWith("-d")) {
//            for (int i = 1; i < args.length; i++) {
//                int index = Integer.parseInt(args[i]);
//                Person person = allPeople.get(index);
//                person.setName(null);
//                person.setSex(null);
//                person.setBirthDay(null);
//            }
//
//
//
//        }

//        if (args[0].startsWith("-i")) {
//            for (int i = 1; i < args.length; i++) {
//                int index = Integer.parseInt(args[i]);
//                Person person = allPeople.get(index);
//                StringBuffer s = new StringBuffer();
//                s.append(person.getName());
//                s.append(" ");
//                s.append(person.getSex() == Sex.MALE ? "м" : "ж");
//                s.append(" ");
//                s.append(dateFormatPrt.format(person.getBirthDay()));
//                System.out.println(s);
//            }
//        }

