package org.jaxlan.assemble;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ServiceLoader;

/**
 * Assemble some fun with this random quote loader. Pick up any of the modules available or implement your own version
 * of the {@link FunProvider} service and call {@link #assemble()}!
 */
public class Assemble {
    private static final List<FunProvider> PROVIDERS = new ArrayList<>();
    private static final Random RANDOM = new Random();

    static {
        ServiceLoader<FunProvider> loader = ServiceLoader.load(FunProvider.class);
        for (FunProvider provider : loader) {
            PROVIDERS.add(provider);
        }
    }

    public static String assemble() {
        // Get a random provider
        FunProvider provider = PROVIDERS.get(RANDOM.nextInt(PROVIDERS.size()));
        return provider.getFun();
    }
}
