/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.mc6pac.toolchainGPUTILS;

import com.microchip.mplab.nbide.embedded.makeproject.api.configurations.MakeConfiguration;
import com.microchip.mplab.nbide.embedded.spi.DefineProvider;
import com.microchip.mplab.nbide.toolchainCommon.LTUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ProjectConfiguration;

/**
 *
 * @author Patrick
 */
public class GPUTILSSystemDefineProvider implements DefineProvider {

    private static final String[] PREDEFINED_MACROS = {
//        "__asm nop __endasm",
//        "__asm crwdt __endasm",
//        "__asm sleep __endasm",
//        "__asm reset __endasm"
    };
    
    @Override
    public List<String> getDefines(Project project, ProjectConfiguration projectConf, String itemPath) {
        List<String> res = Arrays.asList(PREDEFINED_MACROS);
        res = new ArrayList<>(res);

        MakeConfiguration makeConf = (MakeConfiguration)projectConf;
        
        // These defines can be found by running the compiler in verbose mode.
        res.add("__" + GPUTILSDeviceNameProvider.getProcessorShortNameForCompiler(makeConf).toUpperCase());  // __16F628A
        res.add("__GPUTILS_SVN_VERSION");
        res.add("__GPUTILS_VERSION_MAJOR");
        res.add("__GPUTILS_VERSION_MINOR");
        res.add("__GPUTILS_VERSION_MICRO");

        res.add("__12_BIT");
        res.add("__ENHANCED");
        res.add("__EXTENDED");

        res.add("__ACC_RAM_LOW_START");
        res.add("__ACC_RAM_LOW_END");

        res.add("__BANK_BITS");
        res.add("__BANK_MASK");
        res.add("__BANK_SHIFT");
        res.add("__BANK_SIZE");
        res.add("__BANK_INV");
        res.add("__NUM_BANKS");
        res.add("__BANK_0");
        res.add("__BANK_n");
        res.add("__BANK_FIRST");
        res.add("__BANK_LAST");

        res.add("__PAGE_BITS");
        res.add("__PAGE_MASK");
        res.add("__PAGE_SHIFT");
        res.add("__PAGE_SIZE");
        res.add("__PAGE_INV");
        res.add("__NUM_PAGES");
        res.add("__PAGE_0");
        res.add("__PAGE_n");
        res.add("__PAGE_FIRST");
        res.add("__PAGE_LAST ");

        res.add("__COMMON_RAM_START");
        res.add("__COMMON_RAM_END");
        res.add("__COMMON_RAM_MAX");

        res.add("__LINEAR_RAM_START");
        res.add("__LINEAR_RAM_END");

        res.add("__IDLOCS_START");
        res.add("__IDLOCS_END");

        res.add("__CONFIG_START");
        res.add("__CONFIG_END");

        res.add("__EEPROM_START");
        res.add("__EEPROM_END");

        res.add("__CODE_START");
        res.add("__CODE_END");

        res.add("__VECTOR_RESET");
        res.add("__VECTOR_INT");
        res.add("__VECTOR_INT_EXT");
        res.add("__VECTOR_INT_TMR0");
        res.add("__VECTOR_INT_T0CKI");
        res.add("__VECTOR_INT_PERI ");
        res.add("__VECTOR_INT_HIGH ");
        res.add("__VECTOR_INT_LOW ");

        res.add("__WHILE_LOOP_COUNT_MAX");

//        res.add("__SDCC_" + SDCCChipDependentProperties.getProcessorNameForCompiler(makeConf));                 // __SDCC_PIC16F628A
//        res.add("__SDCC_USE_NON_FREE");                                                                         // option!!
//        res.add("__SDCC=" + getCompilerVersion(makeConf));                                                      // __SDCC=3_5_0
//        res.add("SDCC=" + getCompilerVersion2(makeConf));                                                       // SDCC=350
//        res.add("__SDCC_REVISION=" + getCompilerRevision());                                                    // __SDCC_REVISION=9253
//        res.add("__SDCC_" + SDCCChipDependentProperties.getProcessorFamilyForCompiler(makeConf));               // __SDCC_pic14
//        res.add("__STDC_NO_COMPLEX__");                                                                         // option??
//        res.add("__STDC_NO_THREADS__");                                                                         // option??
//        res.add("__STDC_NO_ATOMICS__");                                                                         // option??
//        res.add("__STDC_NO_VLA__");                                                                             // option??
        return res;
    }
     public static String getCompilerVersion(MakeConfiguration makeConf) {
        String ver = LTUtils.getVersion(makeConf);
        return ver.replace(".", "_");
    }

    public static String getCompilerVersion2(MakeConfiguration makeConf) {
        String ver = LTUtils.getVersion(makeConf);
        return ver.replace(".", "");
    }
}
