package com.cgd.bean;

import java.util.List;

/**
 * Created by cgd on 2017/6/25.
 */

public class BusListBean {

    /**
     * body : {"result":{"list":[{"types":"1,2","terminal_name":"田贝总站","name":"977路","uuid":"bus20170603232749e6013e62e87351e15bf9b8ff6601a6b7","front_name":"辅城坳总站．"},{"types":"0,1,2","terminal_name":"北斗总站","name":"14路","uuid":"bus20170603232633c951efd81f033a6207c72dfdcf6b6e23","front_name":"莲花山总站"},{"types":"0,1,2","terminal_name":"水库总站","name":"17路","uuid":"bus201706032326333668785d97174a56ba9d731b54954693","front_name":"火车站"},{"types":"0,1,2","terminal_name":"火车站西广场","name":"18路","uuid":"bus201706032326334ca6ab962000a183266112901436bffd","front_name":"布吉联检站（草埔总站）"},{"types":"0,1,2","terminal_name":"梅林一村总站","name":"B613","uuid":"bus20170603232754f8d01d38c74f273b7a7682ebb932694f","front_name":"福田口岸总站"},{"types":"0,1,2","terminal_name":"火车站","name":"1路","uuid":"bus201706032326348305debc2537df1161d81f3b48b993a3","front_name":"东湖客运站"},{"types":"1,2","terminal_name":"仙湖植物园总站","name":"202路","uuid":"bus20170603232635702d81d9c80742157dd0789038fd7255","front_name":"福田交通枢纽"},{"types":"0,1,2","terminal_name":"蛇口码头","name":"113路","uuid":"bus20170603232630e20a4d9c0f4f73131e681032d6dc2e8f","front_name":"莲塘梧桐苑总站"},{"types":"0,1,2","terminal_name":"塘朗小学","name":"122路","uuid":"bus20170603232631790bfbdc2e73d75ff0514b9c0e94d5f6","front_name":"荔山工业园总站（青青世界）"},{"types":"0,1,2","terminal_name":"火车站","name":"12路","uuid":"bus20170603232632f952d7d9188a0f8e249a19df8c37d6c3","front_name":"福田农批市场"}]}}
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
         * result : {"list":[{"types":"1,2","terminal_name":"田贝总站","name":"977路","uuid":"bus20170603232749e6013e62e87351e15bf9b8ff6601a6b7","front_name":"辅城坳总站．"},{"types":"0,1,2","terminal_name":"北斗总站","name":"14路","uuid":"bus20170603232633c951efd81f033a6207c72dfdcf6b6e23","front_name":"莲花山总站"},{"types":"0,1,2","terminal_name":"水库总站","name":"17路","uuid":"bus201706032326333668785d97174a56ba9d731b54954693","front_name":"火车站"},{"types":"0,1,2","terminal_name":"火车站西广场","name":"18路","uuid":"bus201706032326334ca6ab962000a183266112901436bffd","front_name":"布吉联检站（草埔总站）"},{"types":"0,1,2","terminal_name":"梅林一村总站","name":"B613","uuid":"bus20170603232754f8d01d38c74f273b7a7682ebb932694f","front_name":"福田口岸总站"},{"types":"0,1,2","terminal_name":"火车站","name":"1路","uuid":"bus201706032326348305debc2537df1161d81f3b48b993a3","front_name":"东湖客运站"},{"types":"1,2","terminal_name":"仙湖植物园总站","name":"202路","uuid":"bus20170603232635702d81d9c80742157dd0789038fd7255","front_name":"福田交通枢纽"},{"types":"0,1,2","terminal_name":"蛇口码头","name":"113路","uuid":"bus20170603232630e20a4d9c0f4f73131e681032d6dc2e8f","front_name":"莲塘梧桐苑总站"},{"types":"0,1,2","terminal_name":"塘朗小学","name":"122路","uuid":"bus20170603232631790bfbdc2e73d75ff0514b9c0e94d5f6","front_name":"荔山工业园总站（青青世界）"},{"types":"0,1,2","terminal_name":"火车站","name":"12路","uuid":"bus20170603232632f952d7d9188a0f8e249a19df8c37d6c3","front_name":"福田农批市场"}]}
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
                 * types : 1,2
                 * terminal_name : 田贝总站
                 * name : 977路
                 * uuid : bus20170603232749e6013e62e87351e15bf9b8ff6601a6b7
                 * front_name : 辅城坳总站．
                 */

                private String types;
                private String terminal_name;
                private String name;
                private String uuid;
                private String front_name;

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
