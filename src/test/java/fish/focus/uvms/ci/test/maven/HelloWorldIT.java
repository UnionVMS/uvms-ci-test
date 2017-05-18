package fish.focus.uvms.ci.test.maven;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;

@RunWith(Arquillian.class)
public class HelloWorldIT {

    @Inject
    HelloWorld helloWorld;

    @Deployment
    public static JavaArchive createDeployment() {
        final JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addClasses(HelloWorld.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(jar.toString(true));
        return jar;
    }

    @Test
    public void helloIT() {
        assertEquals(helloWorld.hello("world of IT "), "Hello world  of IT ");

    }

}
