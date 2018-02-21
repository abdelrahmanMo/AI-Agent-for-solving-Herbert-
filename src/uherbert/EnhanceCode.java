package uherbert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hagarmohamad75
 */
public class EnhanceCode {
    String FullCode="";

    public EnhanceCode(String FullCode) {
        this.FullCode=FullCode;
    }
   static String c="ssssr";
   static String b="sls";
   static String d="srs";
   static String f="rsr";
   static String e="lsl";
   static String g="rss";
   static String j="brbrbr";
   static String h="ssssssssss";
   static String z="sssssssss";
    public String  AddFunctions(){
        
        FullCode=FullCode.replaceAll(c, "c");
        FullCode=FullCode.replaceAll(b, "b");
        FullCode=FullCode.replaceAll(d, "d");
        FullCode=FullCode.replaceAll(e, "e");
        FullCode=FullCode.replaceAll(f, "f");
        FullCode=FullCode.replaceAll(g, "g");
        FullCode=FullCode.replaceAll(j, "j");
        FullCode=FullCode.replaceAll(h, "h");
        FullCode=FullCode.replaceAll(z, "z");

    return FullCode;
    }
    
    
    
    
    
    
}
