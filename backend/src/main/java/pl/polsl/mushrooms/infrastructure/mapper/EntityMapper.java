package pl.polsl.mushrooms.infrastructure.mapper;

import java.util.Collection;
import java.util.Set;

/**
 * Created by pawel_zaqkxkn on 10.07.2017.
 */
public interface EntityMapper {

    <T, R> Set<R> map(Collection<T> set);

    <R> R map(Object obj);
}
