package com.github.mc6pac.toolchainGPUTILS;

import com.microchip.mplab.nbide.embedded.api.LanguageToolSupport;
import com.microchip.mplab.nbide.embedded.spi.VersionProvider;
import java.io.File;
import java.util.regex.Matcher;
import org.openide.util.Exceptions;

public class GPUTILSVersionProvider implements VersionProvider {

    private static String extractVersion(String pathToCompiler){
        if (pathToCompiler == null || pathToCompiler.isEmpty())
            return "";
        
        try
        {
            // Completes, but writes to std::err 
            Matcher m = LanguageToolSupport.findInOutput(pathToCompiler, new String[] {"--version"}, "\\d+\\.\\d+\\.\\d+", false, true);
            if (m == null) {
                return "";
            }
            return m.group(0);
        }
        catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }

        return "";
    }
    
    @Override
    public String getVersion(String directory) 
    {
        // Default toolchain version is for gpasm
        return new GPASM().getVersion(directory + File.separator + "gpasm");
    }
    
    public static class GPASM implements VersionProvider {
    
        @Override
        public String getVersion(String directory) {
            String pathToCompiler = directory;
            return extractVersion(pathToCompiler);
        }
    }

    public static class GPLINK implements VersionProvider {
    
        @Override
        public String getVersion(String directory) {
            String pathToCompiler = directory;
            return extractVersion(pathToCompiler);
        }
    }
}
