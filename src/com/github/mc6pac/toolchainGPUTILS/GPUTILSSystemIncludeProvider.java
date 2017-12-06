/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.mc6pac.toolchainGPUTILS;

import com.microchip.mplab.nbide.embedded.makeproject.api.configurations.MakeConfiguration;
import com.microchip.mplab.nbide.embedded.spi.IncludeProvider;
import com.microchip.mplab.nbide.toolchainCommon.LTUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ProjectConfiguration;

/**
 *
 * @author Patrick
 */
public class GPUTILSSystemIncludeProvider implements IncludeProvider {
    
    public GPUTILSSystemIncludeProvider() {
        
    }
    
    @Override
    public List<String> getIncludes(Project project, ProjectConfiguration projectConf, String itemPath) {
      
        final List<String> ret = new ArrayList<>();
        final String pathToBin = LTUtils.pathToBin(projectConf);
        ret.add(pathToBin + File.separator + ".." + File.separator + "header");
        return ret;
    }
    
}
