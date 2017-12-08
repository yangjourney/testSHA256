import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptAndDecryptInterface {
    public static final String ALGORITHM = "SHA-256";

    public static String SHA256Encrypt(String orignal) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (null != md) {
            byte[] origBytes = orignal.getBytes();
            md.update(origBytes);
            byte[] digestRes = md.digest();
            String digestStr = getDigestStr(digestRes);
            return digestStr;
        }

        return null;
    }

    private static String getDigestStr(byte[] origBytes) {
        String tempStr = null;
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < origBytes.length; i++) {
            tempStr = Integer.toHexString(origBytes[i] & 255);
            if (tempStr.length() == 1) {
                stb.append("0");
            }
            stb.append(tempStr);

        }
        return stb.toString();
    }

    public static void main(String[] args) {
        //String json_str1 = "{\"requestId\":\"20171206171420000001\",\"requestTime\":\"20171206171420\",\"nodeId\":\"371302369\",\"sign\":null,\"count\":1,\"bodyType\":\"planting_sale_record\",\"body\":\"[{'plantingEntId':'371331464','plantingEntName':'蔬送天下河东分公司','buyerId':'371301031','buyerMarketName':'临沂经济技术开发区第一实验小学南校区','batchId':'1','goodsCode':'01235200','goodsName':'芽苗类','weight':'25.88','price':'5.72','operator':'销售员A','remark':'This is load test!','code':'510100198806060078','name':'王晓蛋','buyerCode':'371302329','buyerName':'临沂第二中学','tranId':'2017120717142000002','indate':'20171207171420'}]\"}";
        //String json_str = "{\"requestId\":\"20171206171420000001\",\"requestTime\":\"20171206171420\",\"nodeId\":\"371302369\",\"sign\":null,\"count\":1,\"bodyType\":\"planting_sale_record\",\"body\":\"[{'plantingEntId':'371331464','plantingEntName':'蔬送天下河东分公司','buyerId':'371301031','buyerMarketName':'临沂经济技术开发区第一实验小学南校区','batchId':'1','goodsCode':'01235200','goodsName':'芽苗类','weight':'25.88','price':'5.72','operator':'销售员A','remark':'This is load test!','code':'510100198806060078','name':'王晓蛋','buyerCode':'371302329','buyerName':'临沂第二中学','tranId':'2017120717142000002','indate':'20171207171420'}]\"}4D7A63774E6A41774D444177536C70664D5463774F544535";
        String json_str = "卧槽";
        System.out.println(SHA256Encrypt(json_str));
    }

}