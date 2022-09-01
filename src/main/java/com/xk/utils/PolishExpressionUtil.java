//package com.xk.utils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PolishExpressionUtil {
//
//    private List<String> resolveExpr(String exp){
//        List<String> list=new ArrayList<String>();
//        int pidx=-1;
//        for(int i=0;i<opert.length();i++){
//            String p=opert.substring(i, i+1);
//            pidx=exp.indexOf(p);
//            if(exp.substring(0,pidx).trim().length()!=0){
//                list.add(exp.substring(0, pidx));
//            }
//            list.add(exp.substring(pidx, pidx+1));
//            exp=exp.substring(pidx+1);
//        }
//        if(exp.length()>0){
//            list.add(exp);
//        }
//        return list;
//    }
//
//}
