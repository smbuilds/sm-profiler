
package sm.profiler;



public class Main {

    /**
     * This is where the profiler will be loaded into the host jvm as a java
     * agent.
     * 
     * @param args 
     */
   
    public static void main(String[] args) {
        System.out.println("My name is " + System.getProperty("jdev.name"));
        Arguments profilerargs = new ProfilerCLI().parseArguments(System.getProperty("jagent.args"));
        profilerargs.dumpArguments(System.out);
    }
}
