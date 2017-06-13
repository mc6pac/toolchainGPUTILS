package com.github.mc6pac.toolchainGPUTILS;

import com.microchip.mplab.nbide.embedded.makeproject.spi.configurations.UserDefineProvider;

public class GPUTILSUserDefineProvider extends UserDefineProvider {
    public static final String OPT_ID = "GPUTILS";
    public static final String OPT_PROP = "user-defines";    

    public GPUTILSUserDefineProvider() {
        super(OPT_ID, OPT_PROP);
    }
    
}
