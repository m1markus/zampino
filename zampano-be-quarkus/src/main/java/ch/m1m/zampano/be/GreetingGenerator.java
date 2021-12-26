package ch.m1m.zampano.be;

import javax.inject.Singleton;

@Singleton
public class GreetingGenerator {

    public String getGreeting(String name) {
        String retText = "Hello ";
        if (name == null) {
            retText += "you";
        } else {
            retText += name;
        }
        return retText;
    }
}
