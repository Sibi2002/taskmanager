package com.taskmanager.Enum;

public enum Roles {
    Admin(1),
    User(2);
    private int value;
    private Roles (int value){
        this.value=value;
    }
    public int getValue() {
        return value;
    }

    public static Roles fromValue(int value) {
        for (Roles d : values()) {
            if (d.getValue() == value) {
                return d;
            }
        }
        throw new IllegalArgumentException("Invalid Role value: " + value);
    }
}
