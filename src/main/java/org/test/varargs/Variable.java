package org.test.varargs;

public class Variable {
	private final String foo = "1, 2, 3";

	public String getFoo() {
		return foo;
	}

	public String format(String format) {
		System.out.println("no arguments");
		return format;
	}

	public String format(String format, Object... args) {
		System.out.println("length: " + args.length);
		for(Object arg : args) {
			System.out.println("object: " + arg);
		}
		return String.format(format, args);
	}
}
