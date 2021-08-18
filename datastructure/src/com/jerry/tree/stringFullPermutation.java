package com.jerry.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class stringFullPermutation {

    HashSet hashSet = new LinkedHashSet();
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str != null && str.length() > 1){
            helper(0,str.toCharArray(),res);
            Collections.sort(res);
            return res;
        }else{
            res.add(str);
            return res;
        }

    }

    public static void helper( int i,char[] cha,ArrayList<String> res){
        if(i == cha.length -1){
            String val = String.valueOf(cha);
            if(!res.contains(val)){
                res.add(val);
            }
        }else{
            for(int j=i;j<cha.length;j++){
                swap(i,j,cha);
                helper(i+1,cha,res);
                swap(i,j,cha);
            }
        }
    }

    public static void swap(int i,int j,char[] cha){
        char temp = cha[i];
        cha[i] = cha[j];
        cha[j] = temp;
    }
}
