package de.befrish.jqwik.vavr.arbitraries.collection.map;

import de.befrish.jqwik.vavr.arbitraries.base.AbstractMapBasedArbitrary;
import io.vavr.Tuple2;
import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import net.jqwik.api.Arbitrary;

/**
 * @author Benno Müller
 */
public class VavrHashMapArbitrary<K, V> extends AbstractMapBasedArbitrary<K, V, HashMap<K, V>> {

    public VavrHashMapArbitrary(final Arbitrary<K> keysArbitrary, final Arbitrary<V> valuesArbitrary) {
        super(keysArbitrary, valuesArbitrary);
    }

    @Override
    protected HashMap<K, V> convertTupleListToVavrMap(final List<Tuple2<K, V>> tuple2List) {
        return HashMap.ofEntries(tuple2List);
    }

}
