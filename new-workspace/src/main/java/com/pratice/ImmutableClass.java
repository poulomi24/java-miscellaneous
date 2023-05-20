package com.pratice;

class Engine
{
    int speed;
    Engine(int speed)
    {
        this.speed = speed;
    }
}

public final class ImmutableClass {
    private final int id;
    private final String name;
    private final Engine engine;

    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
     return this.name;
    }

    public ImmutableClass(int id, String name, Engine e)
    {
        this.id= id;
        this.name = name;
        Engine newEngine = new Engine(e.speed);
        this.engine = newEngine;
    }

    public static void main(String[] args) {
        Engine e = new Engine(50);
        ImmutableClass a = new ImmutableClass(1, "polo", e);
        System.out.println(a.name == "polo");
        System.out.println(a.engine.speed);
        e.speed=70;
        System.out.println(a.engine.speed);
    }
}
