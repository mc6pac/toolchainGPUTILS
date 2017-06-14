package com.github.mc6pac.toolchainGPUTILS;

import com.microchip.mplab.nbide.embedded.makeproject.spi.configurations.UserIncludeProvider;

public class GPUTILSUserIncludeProvider extends UserIncludeProvider {
    
    public static final String OPT_ID = "GPUTILS";
    public static final String OPT_PROP = "user-includes";

    public GPUTILSUserIncludeProvider() {
        super(OPT_ID, OPT_PROP);
    }    
}
