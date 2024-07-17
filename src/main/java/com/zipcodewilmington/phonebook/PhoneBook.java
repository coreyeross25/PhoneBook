package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    public final Map<String, List<String>> phoneBook;
// initializing phonebook
    public PhoneBook(Map<String, List<String>> map) {
        this.phoneBook = map != null ? new HashMap<>(map) : new HashMap<>();
    }

    public PhoneBook() {
    this(null);
    }

    public void add(String name, String phoneNumber) {
       // this method checks to see if the phonebook already has the name stored
        // key = name value = an array list that will hold phone numbers
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new ArrayList<>());
        }
        // its getting the arraylist that goes with name, then adding an array list for the number
        phoneBook.get(name).add(phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new ArrayList<>());
        }
        Collections.addAll(phoneBook.get(name), phoneNumbers);
    }

    public void remove(String name) {
        phoneBook.remove(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            List<String> phoneNumbers = phoneBook.get(name);
            return phoneNumbers.contains(phoneNumber);
        }
        return false;
    }

    public List<String> lookup(String name) {
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String>getAllContactNames() {
        return new ArrayList<>();
    }


    public Map<String, List<String>> getMap() {
        return new HashMap<>(phoneBook);
    }

}
