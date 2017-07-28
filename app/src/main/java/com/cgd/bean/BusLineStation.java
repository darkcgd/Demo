package com.cgd.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by add on 2017/6/8.
 * 显示公交站点和线路附近的景点信息
 */

public class BusLineStation {

    /**
     * body : {"result":{"stations":[{"latitude":"22.542828","name":"黄埔雅苑总站","longitude":"114.052050"},{"latitude":"22.544584","name":"黄埔雅苑","longitude":"114.053120"},{"latitude":"22.547436","name":"儿童医院","longitude":"114.056155"},{"latitude":"22.548530","name":"中心书城北","longitude":"114.057334"},{"latitude":"22.548655","name":"关山月美术馆（２）","longitude":"114.063485"},{"latitude":"22.548566","name":"莲花二村（２）","longitude":"114.069642"},{"latitude":"22.548420","name":"花卉世界（１）","longitude":"114.077312"},{"latitude":"22.548879","name":"华新村","longitude":"114.082831"},{"latitude":"22.548999","name":"圣廷苑酒店","longitude":"114.089948"},{"latitude":"22.549054","name":"妇儿医院","longitude":"114.093872"},{"latitude":"22.549125","name":"少儿图书馆","longitude":"114.099060"},{"latitude":"22.544376","name":"荔枝公园（１）","longitude":"114.104650"},{"latitude":"22.541719","name":"地王大厦","longitude":"114.110010"},{"latitude":"22.542414","name":"人民桥","longitude":"114.113848"},{"latitude":"22.543262","name":"门诊部（１）","longitude":"114.119048"},{"latitude":"22.544362","name":"广深宾馆","longitude":"114.125862"},{"latitude":"22.544983","name":"京鹏大厦","longitude":"114.129499"},{"latitude":"22.545658","name":"冶金大厦","longitude":"114.133687"},{"latitude":"22.546352","name":"黄贝岭地铁站（１）（新秀立交（２）","longitude":"114.137933"},{"latitude":"22.550064","name":"黄贝岭","longitude":"114.143379"},{"latitude":"22.554054","name":"罗湖体委","longitude":"114.150046"},{"latitude":"22.553551","name":"东湖公园南","longitude":"114.146950"}],"scenics":[{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545932508-0-652087177b30c196156898d9e20f62ad.jpeg","latitude":"22.54459977946568","title":"蔡屋围","type":0,"uuid":"rl20170602181330669be49dfcd441436a553e22cff0df67","thumb_content":null,"longitude":"114.1139044717978"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488264764884-0-c6938ab51f85103cc27acd4ddbc196ae.jpg","latitude":"22.5488430000","title":"大剧院","type":2,"uuid":"rl201702281210296769f8989cae3f06a1b16317989c28aa","thumb_content":"大剧院","longitude":"114.1119460000"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545938535-0-db94f467f126d0e2f48005afdd769914.jpeg","latitude":"22.54105447401547","title":"罗湖村","type":2,"uuid":"rl20170602181329235c92fffc2a44daea30595382a3ac73","thumb_content":null,"longitude":"114.1258933945707"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1493006109096-0-6cd80c61cd5c1d21b651e1817a491f8a.jpeg","latitude":"22.5479290000","title":"国贸大厦","type":2,"uuid":"rl20170228103719e8765180530035c02ed89505489c0c39","thumb_content":"国贸大厦","longitude":"114.1255210000"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488264543892-0-6f367cd732b35d5674996bf0a0764004.jpg","latitude":"22.5463950000","title":"深交所（CBD）","type":0,"uuid":"rl20170228135054585e9feb72c4f99cc4870a8dedc86fe6","thumb_content":"深交所","longitude":"114.0610670000"},{"latitude":"22.5484794827","title":"向西村","type":1,"uuid":"rl201705091418138133d276be8ca0183686f4c76b0a895c","thumb_content":"向西村","longitude":"114.1320467729"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488264748298-0-36a6b10d4756faea475086b9120dd200.jpg","latitude":"22.5471370000","title":"上海宾馆","type":2,"uuid":"rl20170228134827bef6a1e7e4447e9b07a02f74903154a7","thumb_content":"上海宾馆","longitude":"114.0885370000"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545935154-0-3396b32b8f7a413c62b3240f5f39d47a.jpeg","latitude":"22.55379281976579","title":"深圳古玩城","type":1,"uuid":"rl20170602181327a7d21da0e782507744e9b1427db05b52","thumb_content":null,"longitude":"114.1499154565104"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545935509-0-e693f0658932cbe59f03e8d503e74c9a.jpeg","latitude":"22.54526705392194","title":"晶都酒店","type":1,"uuid":"rl201706021813258bea1034441b82c0eb0a62908ec7207b","thumb_content":null,"longitude":"114.1123554337769"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488263979048-0-9298d1ed09aa6f32e1f912db83b283f4.jpg","latitude":"22.5473450000","title":"小平画像","type":1,"uuid":"rl20170228140000ca19d9659aa1746b566ce9fe8b1e544f","thumb_content":"小平画像","longitude":"114.1098590000"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545933462-0-e0f2f3c26f1f6476dc86be1c22cf7035.jpeg","latitude":"22.5395811407121","title":"渔民村","type":1,"uuid":"rl20170602181328b0ffa4dcef5c68d1b323696a16802d9f","thumb_content":null,"longitude":"114.1187284720966"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1493006184673-0-d36156b62104cb1fff86d538fe868b58.jpeg","latitude":"22.5487930000","title":"地王大厦","type":0,"uuid":"rl20170228104109ab4c62549713d6a92b803437ee735f00","thumb_content":"地王大厦","longitude":"114.1165200000"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488264447365-0-1f0e80406fddcb0c476445d5f8c712c5.jpg","latitude":"22.5461090000","title":"报业大厦","type":1,"uuid":"rl2017022812082248fa286555af8baab1a9dcbc5350fdbf","thumb_content":"报业大厦","longitude":"114.0521580000"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545936192-0-1ffe4aac00185cbba4bf5eef3bd89f0d.jpeg","latitude":"22.54684902851115","title":"国贸大厦","type":2,"uuid":"rl201706021813249d7388b73a94c490ba030b41cb69e4db","thumb_content":null,"longitude":"114.1261756592296"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488264584250-0-96cf20bf9d02907888f10137c7732a76.jpg","latitude":"22.5449510000","title":"岗厦","type":0,"uuid":"rl201702281212223b9123ef7701090563fd3041c00dd992","thumb_content":"岗厦","longitude":"114.0759810000"},{"latitude":"22.5535101486","title":"凤凰路美食街","type":1,"uuid":"rl20170509142317476b8d9d1d68e9f17ec5c7647908e3f3","thumb_content":"凤凰路美食街","longitude":"114.1398822225"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488264623750-0-fcc477c1bbdd53dd10ac1a3113394c33.jpg","latitude":"22.5473680000","title":"市委","type":2,"uuid":"rl20170228135621f93e93fe21bc99dbc49fd42bf622fac6","thumb_content":"市委","longitude":"114.1046260000"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545934766-0-46ad3c3000b5f88e9987652d228174ca.jpeg","latitude":"22.54514044718324","title":"平乐骨伤科医院 ","type":1,"uuid":"rl201706021813253c7d989d8143dc1c4c60a6e9195f0763","thumb_content":null,"longitude":"114.1138078805995"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545928070-0-60bc27f756fe67e2f4c51055b4785b89.jpeg","latitude":"22.5407021010","title":"鹿丹村","type":0,"uuid":"rl20170509141624f31f18d3171dd95d4817b7ff69b4057e","thumb_content":"鹿丹村","longitude":"114.1136716078"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545937247-0-a06a07cadfa4a446f02eefe2bf5929da.jpeg","latitude":"22.546451926808","title":"深圳万象城","type":1,"uuid":"rl201706021813265ebbf0d0e656bf2f026717133d3b5768","thumb_content":null,"longitude":"114.117210182175"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545921732-0-5735b1f4473db3623098348ea8a52a4d.jpeg","latitude":"22.54592995456294","title":"金光华广场","type":2,"uuid":"rl20170602181330bd5f998643eb5f5700f22e00f032a7a8","thumb_content":null,"longitude":"114.126550184356"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488264049700-0-f8d47841e10d90bb3002eea4c69417f9.jpg","latitude":"22.5465450000","title":"市民中心","type":1,"uuid":"rl201702281352042020d14011bbbe47d9e2750ddf6bbf88","thumb_content":"市民中心，中心区域","longitude":"114.0666720000"},{"latitude":"22.5486994827","title":"春风路新疆风味食街","type":2,"uuid":"rl20170509142344ce507f1cd42928b28046b4a586cc479e","thumb_content":"春风路新疆风味食街","longitude":"114.1386367729"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488264226832-0-45c647fd52c2447b367db4b8d42b7eff.jpg","latitude":"22.5472470000","title":"华强北","type":1,"uuid":"rl20170228134536d32c35af1c3490b2989435b4eb6d0dd7","thumb_content":"华强北","longitude":"114.0918370000"}]}}
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
         * result : {"stations":[{"latitude":"22.542828","name":"黄埔雅苑总站","longitude":"114.052050"},{"latitude":"22.544584","name":"黄埔雅苑","longitude":"114.053120"},{"latitude":"22.547436","name":"儿童医院","longitude":"114.056155"},{"latitude":"22.548530","name":"中心书城北","longitude":"114.057334"},{"latitude":"22.548655","name":"关山月美术馆（２）","longitude":"114.063485"},{"latitude":"22.548566","name":"莲花二村（２）","longitude":"114.069642"},{"latitude":"22.548420","name":"花卉世界（１）","longitude":"114.077312"},{"latitude":"22.548879","name":"华新村","longitude":"114.082831"},{"latitude":"22.548999","name":"圣廷苑酒店","longitude":"114.089948"},{"latitude":"22.549054","name":"妇儿医院","longitude":"114.093872"},{"latitude":"22.549125","name":"少儿图书馆","longitude":"114.099060"},{"latitude":"22.544376","name":"荔枝公园（１）","longitude":"114.104650"},{"latitude":"22.541719","name":"地王大厦","longitude":"114.110010"},{"latitude":"22.542414","name":"人民桥","longitude":"114.113848"},{"latitude":"22.543262","name":"门诊部（１）","longitude":"114.119048"},{"latitude":"22.544362","name":"广深宾馆","longitude":"114.125862"},{"latitude":"22.544983","name":"京鹏大厦","longitude":"114.129499"},{"latitude":"22.545658","name":"冶金大厦","longitude":"114.133687"},{"latitude":"22.546352","name":"黄贝岭地铁站（１）（新秀立交（２）","longitude":"114.137933"},{"latitude":"22.550064","name":"黄贝岭","longitude":"114.143379"},{"latitude":"22.554054","name":"罗湖体委","longitude":"114.150046"},{"latitude":"22.553551","name":"东湖公园南","longitude":"114.146950"}],"scenics":[{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545932508-0-652087177b30c196156898d9e20f62ad.jpeg","latitude":"22.54459977946568","title":"蔡屋围","type":0,"uuid":"rl20170602181330669be49dfcd441436a553e22cff0df67","thumb_content":null,"longitude":"114.1139044717978"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488264764884-0-c6938ab51f85103cc27acd4ddbc196ae.jpg","latitude":"22.5488430000","title":"大剧院","type":2,"uuid":"rl201702281210296769f8989cae3f06a1b16317989c28aa","thumb_content":"大剧院","longitude":"114.1119460000"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545938535-0-db94f467f126d0e2f48005afdd769914.jpeg","latitude":"22.54105447401547","title":"罗湖村","type":2,"uuid":"rl20170602181329235c92fffc2a44daea30595382a3ac73","thumb_content":null,"longitude":"114.1258933945707"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1493006109096-0-6cd80c61cd5c1d21b651e1817a491f8a.jpeg","latitude":"22.5479290000","title":"国贸大厦","type":2,"uuid":"rl20170228103719e8765180530035c02ed89505489c0c39","thumb_content":"国贸大厦","longitude":"114.1255210000"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488264543892-0-6f367cd732b35d5674996bf0a0764004.jpg","latitude":"22.5463950000","title":"深交所（CBD）","type":0,"uuid":"rl20170228135054585e9feb72c4f99cc4870a8dedc86fe6","thumb_content":"深交所","longitude":"114.0610670000"},{"latitude":"22.5484794827","title":"向西村","type":1,"uuid":"rl201705091418138133d276be8ca0183686f4c76b0a895c","thumb_content":"向西村","longitude":"114.1320467729"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488264748298-0-36a6b10d4756faea475086b9120dd200.jpg","latitude":"22.5471370000","title":"上海宾馆","type":2,"uuid":"rl20170228134827bef6a1e7e4447e9b07a02f74903154a7","thumb_content":"上海宾馆","longitude":"114.0885370000"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545935154-0-3396b32b8f7a413c62b3240f5f39d47a.jpeg","latitude":"22.55379281976579","title":"深圳古玩城","type":1,"uuid":"rl20170602181327a7d21da0e782507744e9b1427db05b52","thumb_content":null,"longitude":"114.1499154565104"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545935509-0-e693f0658932cbe59f03e8d503e74c9a.jpeg","latitude":"22.54526705392194","title":"晶都酒店","type":1,"uuid":"rl201706021813258bea1034441b82c0eb0a62908ec7207b","thumb_content":null,"longitude":"114.1123554337769"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488263979048-0-9298d1ed09aa6f32e1f912db83b283f4.jpg","latitude":"22.5473450000","title":"小平画像","type":1,"uuid":"rl20170228140000ca19d9659aa1746b566ce9fe8b1e544f","thumb_content":"小平画像","longitude":"114.1098590000"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545933462-0-e0f2f3c26f1f6476dc86be1c22cf7035.jpeg","latitude":"22.5395811407121","title":"渔民村","type":1,"uuid":"rl20170602181328b0ffa4dcef5c68d1b323696a16802d9f","thumb_content":null,"longitude":"114.1187284720966"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1493006184673-0-d36156b62104cb1fff86d538fe868b58.jpeg","latitude":"22.5487930000","title":"地王大厦","type":0,"uuid":"rl20170228104109ab4c62549713d6a92b803437ee735f00","thumb_content":"地王大厦","longitude":"114.1165200000"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488264447365-0-1f0e80406fddcb0c476445d5f8c712c5.jpg","latitude":"22.5461090000","title":"报业大厦","type":1,"uuid":"rl2017022812082248fa286555af8baab1a9dcbc5350fdbf","thumb_content":"报业大厦","longitude":"114.0521580000"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545936192-0-1ffe4aac00185cbba4bf5eef3bd89f0d.jpeg","latitude":"22.54684902851115","title":"国贸大厦","type":2,"uuid":"rl201706021813249d7388b73a94c490ba030b41cb69e4db","thumb_content":null,"longitude":"114.1261756592296"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488264584250-0-96cf20bf9d02907888f10137c7732a76.jpg","latitude":"22.5449510000","title":"岗厦","type":0,"uuid":"rl201702281212223b9123ef7701090563fd3041c00dd992","thumb_content":"岗厦","longitude":"114.0759810000"},{"latitude":"22.5535101486","title":"凤凰路美食街","type":1,"uuid":"rl20170509142317476b8d9d1d68e9f17ec5c7647908e3f3","thumb_content":"凤凰路美食街","longitude":"114.1398822225"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488264623750-0-fcc477c1bbdd53dd10ac1a3113394c33.jpg","latitude":"22.5473680000","title":"市委","type":2,"uuid":"rl20170228135621f93e93fe21bc99dbc49fd42bf622fac6","thumb_content":"市委","longitude":"114.1046260000"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545934766-0-46ad3c3000b5f88e9987652d228174ca.jpeg","latitude":"22.54514044718324","title":"平乐骨伤科医院 ","type":1,"uuid":"rl201706021813253c7d989d8143dc1c4c60a6e9195f0763","thumb_content":null,"longitude":"114.1138078805995"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545928070-0-60bc27f756fe67e2f4c51055b4785b89.jpeg","latitude":"22.5407021010","title":"鹿丹村","type":0,"uuid":"rl20170509141624f31f18d3171dd95d4817b7ff69b4057e","thumb_content":"鹿丹村","longitude":"114.1136716078"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545937247-0-a06a07cadfa4a446f02eefe2bf5929da.jpeg","latitude":"22.546451926808","title":"深圳万象城","type":1,"uuid":"rl201706021813265ebbf0d0e656bf2f026717133d3b5768","thumb_content":null,"longitude":"114.117210182175"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545921732-0-5735b1f4473db3623098348ea8a52a4d.jpeg","latitude":"22.54592995456294","title":"金光华广场","type":2,"uuid":"rl20170602181330bd5f998643eb5f5700f22e00f032a7a8","thumb_content":null,"longitude":"114.126550184356"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488264049700-0-f8d47841e10d90bb3002eea4c69417f9.jpg","latitude":"22.5465450000","title":"市民中心","type":1,"uuid":"rl201702281352042020d14011bbbe47d9e2750ddf6bbf88","thumb_content":"市民中心，中心区域","longitude":"114.0666720000"},{"latitude":"22.5486994827","title":"春风路新疆风味食街","type":2,"uuid":"rl20170509142344ce507f1cd42928b28046b4a586cc479e","thumb_content":"春风路新疆风味食街","longitude":"114.1386367729"},{"cover":"https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1488264226832-0-45c647fd52c2447b367db4b8d42b7eff.jpg","latitude":"22.5472470000","title":"华强北","type":1,"uuid":"rl20170228134536d32c35af1c3490b2989435b4eb6d0dd7","thumb_content":"华强北","longitude":"114.0918370000"}]}
         */

        private ResultBean result;

        public ResultBean getResult() {
            return result;
        }

        public void setResult(ResultBean result) {
            this.result = result;
        }

        public static class ResultBean implements Serializable {
            private List<StationsBean> stations;
            private List<ScenicsBean> scenics;

            public List<StationsBean> getStations() {
                return stations;
            }

            public void setStations(List<StationsBean> stations) {
                this.stations = stations;
            }

            public List<ScenicsBean> getScenics() {
                return scenics;
            }

            public void setScenics(List<ScenicsBean> scenics) {
                this.scenics = scenics;
            }

            public static class StationsBean implements Serializable {
                /**
                 * latitude : 22.542828
                 * name : 黄埔雅苑总站
                 * longitude : 114.052050
                 */

                private double latitude;
                private String name;
                private double longitude;
                private long clickTime;

                public long getClickTime() {
                    return clickTime;
                }

                public void setClickTime(long clickTime) {
                    this.clickTime = clickTime;
                }

                public double getLatitude() {
                    return latitude;
                }

                public void setLatitude(double latitude) {
                    this.latitude = latitude;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public double getLongitude() {
                    return longitude;
                }

                public void setLongitude(double longitude) {
                    this.longitude = longitude;
                }
            }

            public static class ScenicsBean {
                /**
                 * cover : https://tour.qinglimedia.com/tour/tour/512/route/locale/cover/1496545932508-0-652087177b30c196156898d9e20f62ad.jpeg
                 * latitude : 22.54459977946568
                 * title : 蔡屋围
                 * type : 0
                 * uuid : rl20170602181330669be49dfcd441436a553e22cff0df67
                 * thumb_content : null
                 * longitude : 114.1139044717978
                 */

                private String cover;
                private String file;
                private double latitude;
                private String title;
                private int type;
                private String uuid;
                private String thumb_content;
                private double longitude;
                private double distance;/*距离用户定位的距离*/
                private HostStarBean hostStar;

                public HostStarBean getHostStar() {
                    return hostStar;
                }

                public void setHostStar(HostStarBean hostStar) {
                    this.hostStar = hostStar;
                }

                public double getDistance() {
                    return distance;
                }

                public void setDistance(double distance) {
                    this.distance = distance;
                }

                public String getFile() {
                    return file;
                }

                public void setFile(String file) {
                    this.file = file;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public double getLatitude() {
                    return latitude;
                }

                public void setLatitude(double latitude) {
                    this.latitude = latitude;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getUuid() {
                    return uuid;
                }

                public void setUuid(String uuid) {
                    this.uuid = uuid;
                }

                public String getThumb_content() {
                    return thumb_content;
                }

                public void setThumb_content(String thumb_content) {
                    this.thumb_content = thumb_content;
                }

                public double getLongitude() {
                    return longitude;
                }

                public void setLongitude(double longitude) {
                    this.longitude = longitude;
                }

                public static class HostStarBean {
                    /**
                     * portrait : https://tour.qinglimedia.com/tour/tour/128/hostStar/portrait/1490425078878-0-94b1f5f78c4b413ca87d04e27a50160b.jpeg
                     * uuid : hs201703231029361f5a91808b5973e7022faea8b7df5ec6
                     */

                    private String portrait;
                    private String uuid;

                    public String getPortrait() {
                        return portrait;
                    }

                    public void setPortrait(String portrait) {
                        this.portrait = portrait;
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
