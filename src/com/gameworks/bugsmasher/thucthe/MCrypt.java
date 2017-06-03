package com.gameworks.bugsmasher.thucthe;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MCrypt {

   private String SecretKey = "faizahalkaff1954";
   private Cipher cipher;
   private String iv = "farwafatimah1994";
   private IvParameterSpec ivspec;
   private SecretKeySpec keyspec;


   public MCrypt() {
      this.ivspec = new IvParameterSpec(this.iv.getBytes());
      this.keyspec = new SecretKeySpec(this.SecretKey.getBytes(), "AES");

      try {
         this.cipher = Cipher.getInstance("AES/CBC/NoPadding");
      } catch (NoSuchAlgorithmException var3) {
         var3.printStackTrace();
      } catch (NoSuchPaddingException var4) {
         var4.printStackTrace();
      }
   }

   public static String bytesToHex(byte[] var0) {
      String var2;
      if(var0 == null) {
         var2 = null;
      } else {
         int var1 = var0.length;
         var2 = "";

         for(int var3 = 0; var3 < var1; ++var3) {
            if((255 & var0[var3]) < 16) {
               var2 = var2 + "0" + Integer.toHexString(255 & var0[var3]);
            } else {
               var2 = var2 + Integer.toHexString(255 & var0[var3]);
            }
         }
      }

      return var2;
   }

   public static byte[] hexToBytes(String var0) {
      byte[] var1 = null;
      if(var0 != null) {
         int var2 = var0.length();
         var1 = null;
         if(var2 >= 2) {
            int var3 = var0.length() / 2;
            var1 = new byte[var3];

            for(int var4 = 0; var4 < var3; ++var4) {
               var1[var4] = (byte)Integer.parseInt(var0.substring(var4 * 2, 2 + var4 * 2), 16);
            }
         }
      }

      return var1;
   }

   private static String padString(String var0) {
      int var1 = 16 - var0.length() % 16;

      for(int var2 = 0; var2 < var1; ++var2) {
         var0 = var0 + ' ';
      }

      return var0;
   }

   public byte[] decrypt(String var1) throws Exception {
      if(var1 != null && var1.length() != 0) {
         byte[] var10000 = (byte[])null;

         try {
            this.cipher.init(2, this.keyspec, this.ivspec);
            byte[] var4 = this.cipher.doFinal(hexToBytes(var1));
            return var4;
         } catch (Exception var5) {
            throw new Exception("[decrypt] " + var5.getMessage());
         }
      } else {
         throw new Exception("Empty string");
      }
   }

   public byte[] encrypt(String var1) {
      if(var1 != null) {
         var1.length();
      }

      byte[] var2 = (byte[])null;

      try {
         this.cipher.init(1, this.keyspec, this.ivspec);
         byte[] var4 = this.cipher.doFinal(padString(var1).getBytes());
         return var4;
      } catch (Exception var5) {
         return var2;
      }
   }
}
