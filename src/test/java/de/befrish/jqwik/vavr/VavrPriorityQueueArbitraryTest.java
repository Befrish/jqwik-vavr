package de.befrish.jqwik.vavr;

import de.befrish.jqwik.vavr.base.VavrTraversableArbitraryTestBase;
import io.vavr.collection.PriorityQueue;
import io.vavr.collection.Queue;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.arbitraries.StreamableArbitrary;
import net.jqwik.api.constraints.Unique;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class VavrPriorityQueueArbitraryTest extends VavrTraversableArbitraryTestBase<
        PriorityQueue<Integer>,
        PriorityQueue<Boolean>> {

    @Override
    protected StreamableArbitrary<Integer, ? extends PriorityQueue<Integer>> createCollectionArbtitrary(
            final Arbitrary<Integer> elementArbitrary) {
        return VavrArbitraries.priorityQueue(elementArbitrary);
    }

    @Property
    void generateDistinct(@ForAll final PriorityQueue<@Unique Integer> priorityQueue) {
        assertThat(priorityQueue.distinct().size(), is(priorityQueue.size()));
    }

}
