import com.autocfs.core.AutocfsConventionHandlerTest;
import com.autocfs.core.AutocfsMetadataDescriptorFactoryTest;
import com.autocfs.core.AutocfsMetadataDescriptorTest;
import com.autocfs.core.AutocfsMetadataTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        AutocfsMetadataTest.class, AutocfsMetadataDescriptorTest.class,
        AutocfsMetadataDescriptorFactoryTest.class,
        AutocfsConventionHandlerTest.class
})
public class AutocfsCoreTestSuite {
}
