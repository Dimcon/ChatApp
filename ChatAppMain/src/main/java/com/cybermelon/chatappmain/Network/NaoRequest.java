package com.cybermelon.chatappmain.Network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NaoRequest {
    String sBase;
    String sUserID;
    String sSharedSecret;
    String sPath;
    String sClassName;
    String sNaoFile;
    public static final String sSeperator = "\\n/n\\n";
    public static final String sList = "LISTFOLDERCONTENTS";
    public static final String sGetFile = "GETFILE";
    public static final String sPutFolder = "PUTFOLDER";
    public static final String sPutFile = "PUTFILE";
    public static final String sRemoveFile = "REMOVEFILE";
    public static final String sRemoveFolder = "REMOVEFOLDER";
    public static final String sQuoteReplacement = "'''";
    public NaoRequest(String sRequestFromJson) {
        Gson gson = new Gson();
        NaoRequest r = gson.fromJson(sRequestFromJson, this.getClass());
        sBase = r.sBase;
        sUserID = r.sUserID;
        sSharedSecret = r.sSharedSecret;
        sPath = r.sPath;
        sClassName = r.sClassName;
        sNaoFile = ReturnQuotes(r.sNaoFile,sQuoteReplacement);
    }

    public String ToJson() {
        Gson g = new GsonBuilder().create();
        sNaoFile = RemoveQuotes(sNaoFile,sQuoteReplacement);
        String s = g.toJson(this);
        sNaoFile = ReturnQuotes(sNaoFile,sQuoteReplacement);
        return s;
    }

    public String RemoveQuotes(String sIn,String sReplacement) {
        StringBuilder sOut = new StringBuilder();
        int i = 0;
        String sTmp = sIn;
        while (sTmp.length() > 0) {
            if (sTmp.contains("\"")) {
                int iLoc = sTmp.indexOf('"');
                sOut.append(sTmp.substring(0,iLoc) + sReplacement);
                sTmp = sTmp.substring(sTmp.indexOf('"')+1);
            } else {
                sOut.append(sTmp);
                sTmp = "";
            }
        }
        sOut.append(sTmp);
        return sOut.toString();
    }

    public String ReturnQuotes(String sIn,String sReplacement) {
        StringBuilder sOut = new StringBuilder();
        int i = 0;
        String sTmp = sIn;
        while (sTmp.length() > 0) {
            if (sTmp.contains(sReplacement)) {
                int iLoc = sTmp.indexOf(sReplacement);
                sOut.append(sTmp.substring(0,iLoc) + '"');
                sTmp = sTmp.substring(sTmp.indexOf(sReplacement)+sReplacement.length());
            } else {
                sOut.append(sTmp);
                sTmp = "";
            }
        }
        sOut.append(sTmp);
        return sOut.toString();
    }

    public NaoRequest(String sBase, String sUserID, String sSharedSecret, String sPath, String sClassName, String sNaoFile) {
        this.sBase = sBase;
        this.sUserID = sUserID;
        this.sSharedSecret = sSharedSecret;
        this.sPath = sPath;
        this.sClassName = sClassName;
        this.sNaoFile = sNaoFile;
    }
    public NaoRequest() {
    }
}
