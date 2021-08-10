package bean;

@FunctionalInterface
public interface Condition {
	boolean behavior(Apple apple);
}
