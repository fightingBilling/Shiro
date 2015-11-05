package com.somnus.module.maintenance.model;

import java.util.Properties;

public class LogOptMapping {

    public Properties getMappings() {
        return mappings;
    }

    public void setMappings(Properties mappings) {
        this.mappings = mappings;
    }

    public String getLogDesc(String key){
        String logDesc=null;
        if(mappings!=null){
            logDesc = (String)mappings.get(key);
        }

        return logDesc;
    }

    private Properties mappings;


}
