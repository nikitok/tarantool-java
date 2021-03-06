package org.tarantool.generic;

import java.util.concurrent.Future;

import org.tarantool.async.TarantoolAsyncConnection16;

/**
 * You should use NamedConnections instead
 */
@Deprecated
public interface TarantoolAsyncGenericConnection16 extends TarantoolAsyncConnection16 {
    <T> Future<T> select(Class<T> clz, int space, int index, Object key, int offset, int limit, int iterator);

    <T> Future<T> insert(Class<T> clz, int space, Object tuple);

    <T> Future<T> replace(Class<T> clz, int space, Object tuple);

    <T> Future<T> update(Class<T> clz, int space, Object key, Object... args);

    <T> Future<T> delete(Class<T> clz, int space, Object key);

    <T> Future<T> call(Class<T> clz, String function, Object... args);

    <T> Future<T> eval(Class<T> clz, String expression, Object... args);

}
