package com.github.mc6pac.toolchainGPUTILS;

import com.microchip.crownking.Pair;
import com.microchip.mplab.nbide.embedded.makeproject.api.configurations.MakeConfiguration;
import com.microchip.mplab.nbide.embedded.makeproject.api.configurations.MakeConfigurationBook;
import com.microchip.mplab.nbide.embedded.makeproject.api.configurations.OptionConfiguration;
import java.util.List;
import java.util.Properties;
import org.openide.util.Utilities;

public class GPUTILSMakeRuntimeProperties {
    public GPUTILSMakeRuntimeProperties(MakeConfigurationBook projectDescriptor, MakeConfiguration conf,Properties commandLineProperties) {
        commandLineProperties.put("SINGLE_MODE", getCompilerMode(projectDescriptor, conf));
    }

    private boolean getCompilerMode(MakeConfigurationBook projectDescriptor, MakeConfiguration conf) {
        boolean res = true;
        if (!Utilities.isWindows())
            return res;
        // Check the option value
        OptionConfiguration confObject = projectDescriptor.getSynthesizedOptionConfiguration(conf.getName(), "gpasm-config", null);
        if (confObject != null) {
            List<Pair<String, String>> emissionPairs = confObject.getEmissionPairs(null, null);
            if (emissionPairs != null) {
                for (Pair<String, String> p : emissionPairs) {
                    if (p.first.equals("older_coff_format") || p.first.equals("old_coff_format")) {
                        res = false;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
