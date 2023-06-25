package net.learning.demo.common;

import java.util.function.BiFunction;

public interface IMultiMapper<R,T> extends BiFunction<R,T,R> {
}
