package com.github.mc6pac.toolchainGPUTILS;

import com.microchip.mplab.nbide.embedded.makeproject.spi.configurations.UserDefineModifier;

public class GPUTILSUserDefineModifier extends UserDefineModifier {

    public GPUTILSUserDefineModifier() {
        super(GPUTILSUserDefineProvider.OPT_ID, GPUTILSUserDefineProvider.OPT_PROP);
    }    
}
