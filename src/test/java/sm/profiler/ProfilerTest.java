package sm.profiler;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import sm.profiler.ProfilerCLI;

public class ProfilerTest {
    ProfilerCLI pcli = new ProfilerCLI();
    
    /**
     * Use the following annotations to check for exceptions.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testProfilerCLIInvalidArguments() {
        pcli.parseArguments("AB");
    }
    
    @Test
    public void testProfilerCLIServerDetails() {
        pcli.parseArguments("server=localhost,reporter=com.sm.Hello.class,port=9090");
    }
    
}
