package com.catenax.tdm;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.catenax.tdm.model.v1.MemberCompanyRole;
import com.catenax.tdm.model.v1.PartRelationshipWithInfos;
import com.catenax.tdm.model.v1.Traceability;
import com.catenax.tdm.sampledata.PartRelationshipSampleData;
import com.catenax.tdm.sampledata.TraceabilitySampleData;

public class TestDataGenerator {

    public static List<MemberCompanyRole> getAllCompanyRoles() {
        List<MemberCompanyRole> result = new ArrayList<MemberCompanyRole>();

        for (MemberCompanyRole role : MemberCompanyRole.values()) {
            result.add(role);
        }

        return result;
    }
    
    public static List<PartRelationshipWithInfos> generatePrsDataFromVehicle(BOM bom) {
    	List<PartRelationshipWithInfos> result = new ArrayList<PartRelationshipWithInfos>();
    			
    	result.add(PartRelationshipSampleData.bomToPri(bom, 100));

    	return result;
    }

    public static int genInt(int min, int max) {
        int result = 0;

        return result;
    }
    
    private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String lower = upper.toLowerCase(Locale.ROOT);

    private static final String digits = "0123456789";

    private static final String alphanum = upper + lower + digits;
    
    private static final char[] symbols = alphanum.toCharArray();
    
    private static final Random random = ThreadLocalRandom.current();

    public static char randChar() {
    	int i = random.nextInt(symbols.length);
    	char r = symbols[i];    	
    	return r;
    }
    
    public static String genString(int len) {
    	String result = "";
    	
    	for(int i = 0; i < len; i++) {
    		result += randChar();
    	}

        return result;
    }
    
    public static String genString(String prefix, int len) {
        String result = prefix;
        
        result += genString(len - result.length());

        return result;
    }

    public static String genVIN(String prefix) {
        String result = prefix;
        
        result += genString(17 - result.length());

        return result.toUpperCase();
    }

}
