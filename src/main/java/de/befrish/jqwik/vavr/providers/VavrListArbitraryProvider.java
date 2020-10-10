package de.befrish.jqwik.vavr.providers;

import de.befrish.jqwik.vavr.arbitraries.VavrListArbitrary;
import de.befrish.jqwik.vavr.providers.base.AbstractVavrContainerArbitraryProvider;
import io.vavr.collection.List;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.providers.ArbitraryProvider;
import org.kohsuke.MetaInfServices;

@MetaInfServices(ArbitraryProvider.class)
public class VavrListArbitraryProvider extends AbstractVavrContainerArbitraryProvider {

    @Override
    protected Class<?> getProvidedType() {
        return List.class;
    }

    @Override
    protected VavrListArbitrary<?> create(final Arbitrary<?> innerArbitrary) {
        return new VavrListArbitrary<>(innerArbitrary, innerArbitrary.isUnique());
    }

    @Override
    public int priority() {
        return 2; //  provider for Seq and LinearSeq
    }

}
