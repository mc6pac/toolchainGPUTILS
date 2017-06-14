package com.github.mc6pac.toolchainGPUTILS;

import com.microchip.mplab.nbide.embedded.makeproject.api.configurations.MakeConfiguration;

public class GPUTILSDeviceNameProvider {
    
    private static String getDeviceName(MakeConfiguration makeConf){
        return makeConf.getDevice().getName();    
    }
            
    public static String getProcessorNameForCompiler(MakeConfiguration makeConf){
        // PIC16F1939
        return getDeviceName(makeConf);
    }
    
    public static String getProcessorShortNameForCompiler(MakeConfiguration makeConf) {
        // 16f1939
        String shortname = getDeviceName(makeConf).substring(3);
        return shortname.toLowerCase();
    }
}
