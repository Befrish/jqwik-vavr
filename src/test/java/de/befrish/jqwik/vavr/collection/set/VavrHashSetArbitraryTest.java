package de.befrish.jqwik.vavr.collection.set;

import de.befrish.jqwik.vavr.VavrArbitraries;
import de.befrish.jqwik.vavr.base.VavrTraversableArbitraryTestBase;
import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.arbitraries.StreamableArbitrary;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class VavrHashSetArbitraryTest extends VavrTraversableArbitraryTestBase<HashSet<Integer>, HashSet<Boolean>> {

    @Override
    protected StreamableArbitrary<Integer, ? extends HashSet<Integer>> createCollectionArbtitrary(
            final Arbitrary<Integer> elementArbitrary) {
        return VavrArbitraries.hashSet(elementArbitrary);
    }

    @Property
    void generateDistinct(@ForAll final HashSet<Integer> hashSet) { // no @Unique because set should be always distinct
        assertThat(hashSet.distinct().size(), is(hashSet.size()));
    }

}
