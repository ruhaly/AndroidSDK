package com.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MyClass {
    public static void main(String[] args) {
//        List<Student> list = new ArrayList<>();
//        Student s = new Student();
//        s.setName("111");
//        Student s1 = new Student();
//        s1.setName("222");
//
//        list.add(s);
//        list.add(s1);
//
//
//        Gson gson = new Gson();
//        String sre = gson.toJson(list);
//        System.out.println(sre);
//        List<Student> l = gson.fromJson(sre, new TypeToken<List<Student>>() {
//        }.getType());
//        System.out.println(l.size());


        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("ÄãºÃÃ´");
            }
        }).doOnNext(new Action1<String>() {
            @Override
            public void call(String s) {
                for (int i = 0; i < 100; i++) {
                    System.out.println(s + i);
                }
            }
        }).subscribeOn(Schedulers.io()).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("subscribe" + s);
            }
        });
        System.out.println("½áÊø22");
        BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            str = strin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }

    static class Student {
        private String name;

        private List<Keen> list = new ArrayList<>();

        public List<Keen> getList() {
            return list;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class Keen {


        private String name;

        public Keen(String name) {

            this.name = name;
        }


        public String getName() {
            return name;
        }

    }
}
