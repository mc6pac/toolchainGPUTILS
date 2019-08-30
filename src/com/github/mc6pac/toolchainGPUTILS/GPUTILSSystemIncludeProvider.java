package com.github.mc6pac.toolchainGPUTILS;

import com.microchip.mplab.nbide.embedded.spi.IncludeProvider;
import com.microchip.mplab.nbide.toolchainCommon.properties.CommonLanguageToolchainPropertiesUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ProjectConfiguration;

public class GPUTILSSystemIncludeProvider implements IncludeProvider {

    private final CommonLanguageToolchainPropertiesUtils utils = new CommonLanguageToolchainPropertiesUtils();

    public GPUTILSSystemIncludeProvider() {
    }
    
    @Override
    public List<String> getIncludes(Project project, ProjectConfiguration projectConf, String itemPath) {
      
        final List<String> ret = new ArrayList<>();
        final String pathToBin = utils.pathToBin(projectConf);
        ret.add(pathToBin + File.separator + ".." + File.separator + "header");
        return ret;
    }
}
