package com.taskmanager.Enum;

public enum Status {
    Assigned(1),
    Completed(2),
    Overdue(3);
   private  int value;
    private Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Status fromValue(int value) {
        for (Status d : values()) {
            if (d.getValue() == value) {
                return d;
            }
        }
        throw new IllegalArgumentException("Invalid Status value: " + value);
    }


    }
