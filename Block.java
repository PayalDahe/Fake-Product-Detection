/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fddb;

/**
 *
 * @author Admin
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
public class Block {
    private String version;
    private Date timestamp;
    private String hash;
    private String previousHash;
    private String data;
    private int blockNo;

    
    public Block(String version, Date timestamp, String data, String blockDescription, int blockNo)
    {
        this.version=version;
        this.timestamp=timestamp;
        this.data=data+blockDescription;
        this.blockNo=blockNo;      
        this.hash=computeHash();      
        
    }
     
    public Block(String version, Date timestamp, String path, int blockNo)
    {
        this.version=version;
        this.timestamp=timestamp;
       // this.data=data+blockDescription;
        this.blockNo=blockNo;      
        this.hash=computeDirectoryHash(path);      
        
    }
    
    public String computeHash()
    {
        String dataToHash=""+this.version+this.timestamp+this.previousHash+this.blockNo+this.data;
        
        MessageDigest digest;
        String encoded=null;
        try{
            digest=MessageDigest.getInstance("SHA-256");
            byte[] hash =digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
            encoded=Base64.getEncoder().encodeToString(hash);            
        }
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();            
        }
        this.hash=encoded;
        return encoded;
    }
   public static String computeHashofData(String s)
    {
        String dataToHash=s;
        MessageDigest digest;
        String encoded=null;
        try{
            digest=MessageDigest.getInstance("SHA-256");
            byte[] hash =digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
            encoded=Base64.getEncoder().encodeToString(hash);            
        }
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();            
        }
        
        return encoded;
    }
   
   public static String computeDirectoryHash(String path) {

        File dir = new File(path);
        //file:///D:/MarkSheets/ALL12547.pdf
        String directoryHash = null;
        try {
            MessageDigest shaDigest = MessageDigest.getInstance("SHA-256");
            directoryHash = getFileChecksum(shaDigest, dir);
        } catch (Exception e) {
            System.out.println(e.toString());
        }         
       
        directoryHash=directoryHash.replace('+','s');
        return directoryHash;
        
    }
   
   private static String getFileChecksum(MessageDigest digest, File file) throws IOException {
        //Get file input stream for reading the file content
        FileInputStream fis = new FileInputStream(file);

        //Create byte array to read data in chunks
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;

        //Read file data and update in message digest
        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        };

        //close the stream; We don't need it now.
        fis.close();

        //Get the hash's bytes
        byte[] bytes = digest.digest();

        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        //return complete hash
        return sb.toString();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public int getBlockNo() {
        return blockNo;
    }
    
    
}
