package org.mx.erp.tools;

public class IPDataUtil
{

    public static void main(String args[]) {  
        int num = ipToLong("192.168.100.203");
        System.out.println(num);
        System.out.println(longToIp(1052275711l));  
    }  
  
    /** 
     * 通过左移位操作（<<）给每一段的数字加权 
     * 第一段的权为2的24次方  
     * 第二段的权为2的16次方  
     * 第三段的权为2的8次方  
     * 最后一段的权为1 
     *  
     * @param ip 
     * @return int 
     */  
    public static int ipToLong(String ip) {  
        String[] ips = ip.split("\\.");  
        return (Integer.parseInt(ips[0]) << 24) + (Integer.parseInt(ips[1]) << 16)  
                + (Integer.parseInt(ips[2]) << 8) + Integer.parseInt(ips[3]);  
    }  
  
    /** 
     * 将整数值进行右移位操作（>>）  
     * 右移24位，右移时高位补0，得到的数字即为第一段IP  
     * 右移16位，右移时高位补0，得到的数字即为第二段IP 
     * 右移8位，右移时高位补0，得到的数字即为第三段IP  
     * 最后一段的为第四段IP 
     *  
     * @param i 
     * @return String 
     */  
    public static String longToIp(long i) {  
        return ((i >> 24) & 0xFF) + "." + ((i >> 16) & 0xFF) + "."  
                + ((i >> 8) & 0xFF) + "." + (i & 0xFF);  
    }  
}
