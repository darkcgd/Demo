package com.cgd.bean;

import java.util.List;

/**
 * Created by cgd on 17/6/26.
 */

public class RegionListBean {

    /**
     * body : {"result":{"list":[{"cover":"https://tour.qinglimedia.com/tour/tour/512/region/cover/1497800857145-0-1a48997f257c1017405b1ad4a17aa80f.jpg","city":"深圳市","name":"罗湖区","uuid":"r201705011150422268da2429e032055163ce9224d5c73b"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/region/cover/1497800801076-0-43ed3d4fff12e1356056974d0557d32c.jpg","city":"深圳市","name":"南山区","uuid":"r20170518222010b3ae06757192482693640a6faf8f310d"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/region/cover/1497800811947-0-1c175378707967334b279c3377df5a0a.jpeg","city":"深圳市","name":"大鹏新区","uuid":"r20170514093632a5f00d7e5e77536cd71c949892d84110"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/region/cover/1497800827319-0-b2b434abbfc038b0918716e5a648ced0.jpeg","city":"深圳市","name":"宝安区","uuid":"r201706041017530582927f82c953dfe84c7aaca8ca1863"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/region/cover/1497800842570-0-f38abf678134820fa5c14d2f2782e65f.jpeg","city":"深圳市","name":"盐田区","uuid":"r2017060410180331b4ef71032df79146408c36c9274953"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/region/cover/1497800757276-0-0dfe27da7f2c135d623f0f5ecff5edd5.jpeg","city":"深圳市","name":"光明新区","uuid":"r201706041018260b3aa0983aa5df02c588df66c0b15e5c"}]}}
     * header : {"msg":"","code":200}
     */

    private BodyBean body;
    private HeaderBean header;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public HeaderBean getHeader() {
        return header;
    }

    public void setHeader(HeaderBean header) {
        this.header = header;
    }

    public static class BodyBean {
        /**
         * result : {"list":[{"cover":"https://tour.qinglimedia.com/tour/tour/512/region/cover/1497800857145-0-1a48997f257c1017405b1ad4a17aa80f.jpg","city":"深圳市","name":"罗湖区","uuid":"r201705011150422268da2429e032055163ce9224d5c73b"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/region/cover/1497800801076-0-43ed3d4fff12e1356056974d0557d32c.jpg","city":"深圳市","name":"南山区","uuid":"r20170518222010b3ae06757192482693640a6faf8f310d"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/region/cover/1497800811947-0-1c175378707967334b279c3377df5a0a.jpeg","city":"深圳市","name":"大鹏新区","uuid":"r20170514093632a5f00d7e5e77536cd71c949892d84110"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/region/cover/1497800827319-0-b2b434abbfc038b0918716e5a648ced0.jpeg","city":"深圳市","name":"宝安区","uuid":"r201706041017530582927f82c953dfe84c7aaca8ca1863"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/region/cover/1497800842570-0-f38abf678134820fa5c14d2f2782e65f.jpeg","city":"深圳市","name":"盐田区","uuid":"r2017060410180331b4ef71032df79146408c36c9274953"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/region/cover/1497800757276-0-0dfe27da7f2c135d623f0f5ecff5edd5.jpeg","city":"深圳市","name":"光明新区","uuid":"r201706041018260b3aa0983aa5df02c588df66c0b15e5c"}]}
         */

        private ResultBean result;

        public ResultBean getResult() {
            return result;
        }

        public void setResult(ResultBean result) {
            this.result = result;
        }

        public static class ResultBean {
            private List<ListBean> list;

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * cover : https://tour.qinglimedia.com/tour/tour/512/region/cover/1497800857145-0-1a48997f257c1017405b1ad4a17aa80f.jpg
                 * city : 深圳市
                 * name : 罗湖区
                 * uuid : r201705011150422268da2429e032055163ce9224d5c73b
                 */

                private String cover;
                private String city;
                private String name;
                private String uuid;

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUuid() {
                    return uuid;
                }

                public void setUuid(String uuid) {
                    this.uuid = uuid;
                }
            }
        }
    }

    public static class HeaderBean {
        /**
         * msg :
         * code : 200
         */

        private String msg;
        private int code;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}
