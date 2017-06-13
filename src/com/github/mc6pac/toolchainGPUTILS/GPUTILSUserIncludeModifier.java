package com.github.mc6pac.toolchainGPUTILS;

import com.microchip.mplab.nbide.embedded.makeproject.spi.configurations.UserIncludeModifier;

public class GPUTILSUserIncludeModifier extends UserIncludeModifier{

    public GPUTILSUserIncludeModifier(String id, String prop) {
        super(GPUTILSUserIncludeProvider.OPT_ID, GPUTILSUserIncludeProvider.OPT_PROP);
    }
}
