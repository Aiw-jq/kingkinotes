package com.kingki.studynotes.temptest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("MMdd").format(new Date("2012/09/21")));

    }

}
