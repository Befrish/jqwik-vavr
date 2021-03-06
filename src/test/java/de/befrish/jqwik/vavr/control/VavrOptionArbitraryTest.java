package de.befrish.jqwik.vavr.control;

import de.befrish.jqwik.vavr.VavrArbitraries;
import de.befrish.jqwik.vavr.base.VavrArbitraryTestBase;
import io.vavr.control.Option;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.From;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.constraints.IntRange;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.notNullValue;

class VavrOptionArbitraryTest extends VavrArbitraryTestBase<Option<Integer>> {

    @Provide
    Arbitrary<Option<Integer>> integersMin3() {
        return VavrArbitraries.option(Arbitraries.integers().greaterOrEqual(3));
    }

    @Property
    void generateFrom(@ForAll @From("integersMin3") final Option<Integer> option) {
        assertThat(option.getOrElse(3), is(greaterThanOrEqualTo(3)));
    }

    @Property
    void generateWithValueContraints(@ForAll final Option<@IntRange(min = 3, max = 42) Integer> option) {
        final Integer value = option.getOrElse(3);
        assertThat(value, is(greaterThanOrEqualTo(3)));
        assertThat(value, is(lessThanOrEqualTo(42)));
    }

}
