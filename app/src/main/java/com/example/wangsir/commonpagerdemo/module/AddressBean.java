package com.example.wangsir.commonpagerdemo.module;

import java.util.List;

/**
 * Created by wangsir on 2017/7/20.
 */

public class AddressBean {

    /**
     * status : 0
     * data : [{"username":"方世甄","area":"朝阳区","addressid":154,"address":"卡了来了摸摸你默默Mixx哦摸摸YY小武","street":"卡了来了摸摸你默默Mixx哦摸摸YY小武","province":"北京","usertel":"15738962992","isDefaultAddr":1,"city":"北京市"},{"username":"长额","area":"西青区","addressid":149,"address":"大学城姚村姚村景福花园历险记9号楼速速来这里","street":"大学城姚村姚村景福花园历险记9号楼速速来这里","province":"天津","usertel":"15311321019","isDefaultAddr":0,"city":"天津市"},{"username":"长额","area":"西青区","addressid":150,"address":"大学城姚村姚村景福花园历险记9号楼速速来这里","street":"大学城姚村姚村景福花园历险记9号楼速速来这里","province":"天津","usertel":"15311321019","isDefaultAddr":0,"city":"天津市"},{"username":"长额","area":"西青区","addressid":151,"address":"大学城姚村姚村景福花园历险记9号楼速速来这里","street":"大学城姚村姚村景福花园历险记9号楼速速来这里","province":"天津","usertel":"15311321019","isDefaultAddr":0,"city":"天津市"},{"username":"王保军","area":"万州区","addressid":153,"address":"哟哟哟希尔魔攻哦哦哦哦","street":"哟哟哟希尔魔攻哦哦哦哦","province":"重庆","usertel":"13161069743","isDefaultAddr":0,"city":"重庆市"}]
     */

    private int status;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * username : 方世甄
         * area : 朝阳区
         * addressid : 154
         * address : 卡了来了摸摸你默默Mixx哦摸摸YY小武
         * street : 卡了来了摸摸你默默Mixx哦摸摸YY小武
         * province : 北京
         * usertel : 15738962992
         * isDefaultAddr : 1
         * city : 北京市
         */

        private String username;
        private String area;
        private int addressid;
        private String address;
        private String street;
        private String province;
        private String usertel;
        private int isDefaultAddr;
        private String city;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getAddressid() {
            return addressid;
        }

        public void setAddressid(int addressid) {
            this.addressid = addressid;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getUsertel() {
            return usertel;
        }

        public void setUsertel(String usertel) {
            this.usertel = usertel;
        }

        public int getIsDefaultAddr() {
            return isDefaultAddr;
        }

        public void setIsDefaultAddr(int isDefaultAddr) {
            this.isDefaultAddr = isDefaultAddr;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
