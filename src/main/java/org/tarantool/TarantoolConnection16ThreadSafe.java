package org.tarantool;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by noviiden on 21.05.16.
 */
public class TarantoolConnection16ThreadSafe extends TarantoolConnection16Impl {
    private ReentrantLock evalLock = new ReentrantLock();

    public TarantoolConnection16ThreadSafe(String host, int port) throws IOException {
        super(host, port);
    }

    @Override
    public List exec(Code code, Object... args) {
        List result = null;
        evalLock.lock();
        try{
            result = super.exec(code, args);
        }finally {
            evalLock.unlock();
        }
        return result;
    }
}
