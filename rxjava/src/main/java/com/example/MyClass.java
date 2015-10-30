package com.example;

import java.util.ArrayList;
import java.util.List;

public class MyClass {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student s = new Student();
        s.setName("111");
        Student s1 = new Student();
        s1.setName("222");

        list.add(s);
        list.add(s1);
//
//
//        Gson gson = new Gson();
//        String sre = gson.toJson(list);
//        System.out.println(sre);
//        List<Student> l = gson.fromJson(sre, new TypeToken<List<Student>>() {
//        }.getType());
//        System.out.println(l.size());

//        Observable.from(a).scan(new Func2<Integer, Integer, Integer>() {
//            @Override
//            public Integer call(Integer integer, Integer integer2) {
//                return integer * integer2;
//            }
//        }).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                System.out.println(integer);
//            }
//        });
//
//        Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("ÄãºÃÃ´");
//            }
//        }).map(new Func1<String, String>() {
//            @Override
//            public String call(String s) {
//                return "1111";
//            }
//        }).flatMap(new Func1<String, Observable<String>>() {
//            @Override
//            public Observable<String> call(String s) {
//                return null;
//            }
//        }).doOnNext(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                List<String> list = new ArrayList<>();
//                String ss = list.get(12);
//            }
//        }).subscribeOn(Schedulers.io()).subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                System.out.println("´íÎó"+e.getMessage());
//            }
//
//            @Override
//            public void onNext(String s) {
//
//            }
//        });
//        System.out.println("½áÊø22");
//        BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
//        String str = null;
//        try {
//            str = strin.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(str);
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
