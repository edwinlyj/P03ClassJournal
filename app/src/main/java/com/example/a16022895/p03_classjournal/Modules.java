package com.example.a16022895.p03_classjournal;

import java.io.Serializable;

public class Modules implements Serializable{

    private int moduleNum;
    private String moduleName;
    private String moduleCode;

    public Modules(int moduleNum, String moduleName, String moduleCode) {
        this.moduleNum = moduleNum;
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
    }

    public int getModuleNum() {
        return moduleNum;
    }

    public void setModuleNum(int moduleNum) {
        this.moduleNum = moduleNum;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }
}
