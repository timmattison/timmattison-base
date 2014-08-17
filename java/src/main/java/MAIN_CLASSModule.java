package PACKAGE_NAME;

import com.google.inject.AbstractModule;

public class MAIN_CLASSModule extends AbstractModule {
    @Override
    protected void configure() {
	// TODO: Add your bindings here
    }

    /* MULTIBINDER_EXAMPLE_START */
    /*
    private void multibinderExample() {
        // This is an example of how to create a multibinder
        Multibinder<YourInterface> multibinder = Multibinder.newSetBinder(binder(), YourInterface.class);

        multibinder.addBinding().to(Implementation1.class);
        multibinder.addBinding().to(Implementation2.class);
        multibinder.addBinding().to(Implementation3.class);
        multibinder.addBinding().to(Implementation4.class);
    }
    */
    /* MULTIBINDER_EXAMPLE_END */

    /* SIMPLE_BINDING_EXAMPLE_START */
    /*
    private void bindingExample() {
        // This is an example of how to create a few simple bindings

        // A standard binding
        bind(YourInterface.class).to(Implementaton.class);

        // A singleton binding
        bind(YourInterface.class).to(Implementation.class).in(Singleton.class);

        // An eager singleton (instantiated as soon as possible)
        bind(YourInterface.class).to(Implementation.class).asEagerSingleton();
    }
    */
    /* SIMPLE_BINDING_EXAMPLE_END */

    /* AUTOMATIC_FACTORY_EXAMPLE_START */
    /*
    private void automaticFactoriesExample() {
        // This is an example of how to use the factory module builder.
        // ImplementationFactory only needs to be an interface with a single method that returns an Implementation object
        install(new FactoryModuleBuilder().implement(YourInterface.class, Implementation.class).build(ImplementationFactory.class));
    }
    */
    /* AUTOMATIC_FACTORY_EXAMPLE_END */
}
