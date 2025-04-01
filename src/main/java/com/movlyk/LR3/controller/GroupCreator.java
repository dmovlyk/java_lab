package com.movlyk.LR3.controller;

import com.movlyk.LR3.model.Faculty;
import com.movlyk.LR3.model.Group;

public class GroupCreator {
    public static void addGroup(Faculty faculty, Group group) {
        faculty.addGroup(group);
    }
}