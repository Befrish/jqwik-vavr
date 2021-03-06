package de.befrish.jqwik.vavr.providers.collection.map;

import de.befrish.jqwik.vavr.arbitraries.collection.map.VavrLinkedHashMultimapArbitrary;
import de.befrish.jqwik.vavr.providers.base.AbstractDoubleTypeArbitraryProvider;
import io.vavr.collection.LinkedHashMultimap;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.providers.ArbitraryProvider;
import org.kohsuke.MetaInfServices;

/**
 * @author Benno Müller
 */
@MetaInfServices(ArbitraryProvider.class)
public class VavrLinkedHashMultimapArbitraryProvider extends AbstractDoubleTypeArbitraryProvider {

    @Override
    protected Class<?> getProvidedType() {
        return LinkedHashMultimap.class;
    }

    @Override
    protected Arbitrary<?> create(final Arbitrary<?> keysArbitrary, final Arbitrary<?> valuesArbitrary) {
        return new VavrLinkedHashMultimapArbitrary<>(keysArbitrary, valuesArbitrary);
    }

}
