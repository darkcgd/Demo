package com.cgd.bean;

import java.util.List;

/**
 * Created by add on 2017/6/7.
 */

public class BusLine {

    /**
     * body : {"result":{"list":[{"types":null,"terminal_name":"动物园总站（西丽总站）","name":"104路","uuid":"bus2017060323262981ff4c715214a89eee7fc3860c4bb45d","front_name":"宁水花园"},{"types":null,"terminal_name":"侨城东总站","name":"108路","uuid":"bus20170603232629235c5eff4c3ace3aec937f5c888c1882","front_name":"国贸"},{"types":null,"terminal_name":"深圳东站西广场（布吉枢纽西广场）","name":"954路","uuid":"bus201706032327483da6431c993f0fe6806683216120ff7c","front_name":"山厦村"},{"types":null,"terminal_name":"火车站","name":"97路","uuid":"bus201706032327505f316d1de51d66f2c092dd2befc35e11","front_name":"黄贝岭总站"},{"types":null,"terminal_name":"大梅沙海滨总站","name":"M437","uuid":"bus20170603233031dfc62c8b68907d3449dac0742d41fbca","front_name":"梅林检查站"}]}}
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
         * result : {"list":[{"types":null,"terminal_name":"动物园总站（西丽总站）","name":"104路","uuid":"bus2017060323262981ff4c715214a89eee7fc3860c4bb45d","front_name":"宁水花园"},{"types":null,"terminal_name":"侨城东总站","name":"108路","uuid":"bus20170603232629235c5eff4c3ace3aec937f5c888c1882","front_name":"国贸"},{"types":null,"terminal_name":"深圳东站西广场（布吉枢纽西广场）","name":"954路","uuid":"bus201706032327483da6431c993f0fe6806683216120ff7c","front_name":"山厦村"},{"types":null,"terminal_name":"火车站","name":"97路","uuid":"bus201706032327505f316d1de51d66f2c092dd2befc35e11","front_name":"黄贝岭总站"},{"types":null,"terminal_name":"大梅沙海滨总站","name":"M437","uuid":"bus20170603233031dfc62c8b68907d3449dac0742d41fbca","front_name":"梅林检查站"}]}
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
                 * types : null
                 * terminal_name : 动物园总站（西丽总站）
                 * name : 104路
                 * uuid : bus2017060323262981ff4c715214a89eee7fc3860c4bb45d
                 * front_name : 宁水花园
                 */

                private String types;
                private String terminal_name;
                private String name;
                private String uuid;
                private String front_name;
                private String mapUid;
                private int groupType;
                private BusLinePoint BusLinePoint;

                public com.cgd.bean.BusLinePoint getBusLinePoint() {
                    return BusLinePoint;
                }

                public void setBusLinePoint(com.cgd.bean.BusLinePoint busLinePoint) {
                    BusLinePoint = busLinePoint;
                }

                public int getGroupType() {
                    return groupType;
                }

                public void setGroupType(int groupType) {
                    this.groupType = groupType;
                }

                public String getMapUid() {
                    return mapUid;
                }

                public void setMapUid(String mapUid) {
                    this.mapUid = mapUid;
                }

                public String getTypes() {
                    return types;
                }

                public void setTypes(String types) {
                    this.types = types;
                }

                public String getTerminal_name() {
                    return terminal_name;
                }

                public void setTerminal_name(String terminal_name) {
                    this.terminal_name = terminal_name;
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

                public String getFront_name() {
                    return front_name;
                }

                public void setFront_name(String front_name) {
                    this.front_name = front_name;
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
