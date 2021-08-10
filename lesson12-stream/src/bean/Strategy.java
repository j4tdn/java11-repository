package bean;

@FunctionalInterface
public interface Strategy {
	boolean behavior(Apple apple);
}