/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.profiler;

/**
 * A command line interface for the profiler.
 * 
 * @author smdeveloper
 */
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
        
public final class ProfilerCLI {

      
    /** A collection of required parameters. */
    private final Collection<String> REQUIRED = Arrays.asList(Arguments.SERVER,Arguments.PORT);
    
    
    ProfilerCLI() {
    }
    
    /**
     * Raw arguments that needs to be parsed.
     * @param rawArguments 
     */
    public Arguments parseArguments(String rawArguments) {
    
        if (rawArguments == null || rawArguments.trim().length() == 0) {
            throw new IllegalArgumentException("sm-jvm-profiler takes a comma-delimited list of arguments in k=v form.");
        }
        Map<String, String> parsed = new HashMap<>();
        for(String argNameValue : rawArguments.split(",")) {
          String[] tokens = argNameValue.split("=");  
          if (tokens.length !=2) {
              throw new IllegalArgumentException("sm-jvm-profiler takes a comma-delimited list of arguments in k=v form.");
          }
          parsed.put(tokens[0], tokens[1]);
        }
        for (String requiredArg : REQUIRED) {
            if (!parsed.containsKey(requiredArg)) {
                throw new IllegalArgumentException(String.format("%s argument was not supplied", requiredArg));
            }
        }
        return new Arguments(parsed);
    }
}
