package de.befrish.jqwik.vavr.arbitraries;

import de.befrish.jqwik.vavr.arbitraries.base.DoublevalueArbitraryBase;
import io.vavr.concurrent.Future;
import net.jqwik.api.Arbitrary;


public class VavrFutureArbitrary<T> extends DoublevalueArbitraryBase<T, Throwable, Future<T>> implements Arbitrary<Future<T>> {

    public VavrFutureArbitrary(final Arbitrary<T> innerArbitrary, final Arbitrary<Throwable> exceptionArbitrary) {
        super(innerArbitrary, exceptionArbitrary);
    }

    @Override
    protected Future<T> mapFirstValue(final T value) {
        return Future.successful(value);
    }

    @Override
    protected Future<T> mapSecondValue(final Throwable value) {
        return Future.failed(value);
    }

}
