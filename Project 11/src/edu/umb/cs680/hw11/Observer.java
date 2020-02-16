package edu.umb.cs680.hw11;

public interface Observer<T> {
    void update(T event);
}
