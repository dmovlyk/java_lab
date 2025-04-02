package com.movlyk.LR4.controller;

import com.movlyk.LR4.model.Faculty;
import com.movlyk.LR4.model.Group;

public class GroupCreator {
    public static void addGroup(Faculty faculty, Group group) {
        faculty.addGroup(group);
    }
}