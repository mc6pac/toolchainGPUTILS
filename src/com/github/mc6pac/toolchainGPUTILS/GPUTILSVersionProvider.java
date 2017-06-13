package com.github.mc6pac.toolchainGPUTILS;

import com.microchip.mplab.nbide.embedded.api.LanguageToolSupport;
import com.microchip.mplab.nbide.embedded.api.MCHPProcessUtils;
import com.microchip.mplab.nbide.embedded.api.ProcessResult;
import com.microchip.mplab.nbide.embedded.spi.VersionProvider;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import org.openide.util.Exceptions;

public class GPUTILSVersionProvider implements VersionProvider {

    private static String extractVersion(String pathToCompiler){
        if (pathToCompiler == null || pathToCompiler.isEmpty())
            return "";
        
        try
        {
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
        return new GPASM().getVersion(directory);
    }
    
    public static class GPASM implements VersionProvider {
    
        @Override
        public String getVersion(String directory) {
            String pathToCompiler = directory + File.separator + "gpasm";
            return extractVersion(pathToCompiler);
        }
    }

    public static class GPLINK implements VersionProvider {
    
        @Override
        public String getVersion(String directory) {
            String pathToCompiler = directory + File.separator + "gplink";
            return extractVersion(pathToCompiler);
        }
    }
}
