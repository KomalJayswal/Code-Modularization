package net.learning.demo.mapper;

import java.util.function.BiFunction;

public interface IMapper<R,T> extends BiFunction<R,T,R> {
}
