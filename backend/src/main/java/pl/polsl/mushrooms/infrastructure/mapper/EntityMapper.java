package pl.polsl.mushrooms.infrastructure.mapper;

import java.util.Collection;
import java.util.Set;


public interface EntityMapper {

    <T, R> Set<R> map(Collection<T> set);

    <R> R map(Object obj);
}
