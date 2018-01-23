package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public enum TaskObjectName {
        SMALL_SHOPPING,
        BIG_SHOPPING,
        SMALL_PAINTING,
        BIG_PAINTING,
        SHORT_WAY_DRIVING,
        LONG_WAY_DRIVING
    }

    public final Task createTask(TaskObjectName taskObjectName) {
        switch(taskObjectName) {
            case SMALL_SHOPPING:
                return new ShoppingTask("Very small shopping", "bread", 0.5, "kg");
            case BIG_SHOPPING:
                return new ShoppingTask("Expensive shopping", "house", 1, "item");
            case SMALL_PAINTING:
                return new PaintingTask("Very small painting", "white", "door");
            case BIG_PAINTING:
                return new PaintingTask("Very big painting", "yellow", "house elevation");
            case SHORT_WAY_DRIVING:
                return new DrivingTask("Very short way driving", "Warsaw", "a car");
            case LONG_WAY_DRIVING:
                return new DrivingTask("Very long way driving", "New York", "aeroplane");
            default:
                throw new IllegalArgumentException("Unsupported object name");
        }
    }
}
