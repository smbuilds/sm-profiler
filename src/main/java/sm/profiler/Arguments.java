/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.profiler;

import java.io.PrintStream;
import java.util.Map;

/**
 * All the arguments needed for the profiler
 *
 * @author smdeveloper
 */


public class Arguments {
    
    /** The hostname to which the reporter should send data (required) */
    static final String SERVER = "server";
    /** The port number for the server to which the reporter should send data (required) */
    static final String PORT = "port";
    /** The prefix for metrics (optional, defaults to sm-jvm-profiler) */
    static final String METRICS_PREFIX = "prefix";
    /** Colon-delimited list of profiler class names (optional, defaults to CPUTracingProfiler and MemoryProfiler) */
    static final String PROFILERS = "profilers";
    /** Class name of the reporter to use (optional, defaults to JMXReporter) */
    static final String REPORTER = "reporter";
    
    
    private String reportingServer;
    private int port;
    
    public Arguments(Map<String,String> args) {
        reportingServer= args.get(SERVER);
        String portStr = args.get(PORT);
        try {
            port = Integer.parseInt(portStr);
        }catch (NumberFormatException nfe) {
          throw new IllegalArgumentException("Invalid port number provided for reporting host.");       
        }
    }
    
    /**
     * Dumps the arguments into a given PrintStream
     * 
     * @param  ps - the stream to dump the arguments to.
     */
    public void dumpArguments(PrintStream ps) {
        if (null != ps) {
            ps.println(SERVER + " = " + reportingServer);
            ps.println(PORT + " = " + port);
        } else {
            System.out.println("Given printstream is null");
        }        
    }
    
}
