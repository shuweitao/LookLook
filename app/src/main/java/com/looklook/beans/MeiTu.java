package com.looklook.beans;

import java.io.Serializable;
import java.util.List;

/**
 * @author swt
 * @time 2016/11/9 11:28
 */
public class MeiTu implements Serializable {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-11-09 10:00","title":"[分享]日本美少女荒井萌比基尼清纯写真","description":"华声美女","picUrl":"http://img.sc601.com/photo_files/news/20151127/9952492e-7bd0-45f5-bf9f-f64f40e38143.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7527303-0-1.html"},{"ctime":"2016-11-09 08:00","title":"室内气质美女百合花镂空线衫性感高清写真","description":"THE美女","picUrl":"http://img1.wyss.net.cn/uploadfiles/cover/2016/11/02/20161102141445609.jpg","url":"http://www.the6688.com/siwameinv/loukongxingganmeinvtupian.html"},{"ctime":"2016-11-09 08:00","title":"慵懒美女床上露背性感私房照","description":"THE美女","picUrl":"http://img1.wyss.net.cn/uploadfiles/cover/2016/11/02/20161102141622625.jpg","url":"http://www.the6688.com/gaoqing/yonglanmeinvxinggantupian.html"},{"ctime":"2016-11-09 08:00","title":"性感美女长发床上粉红比基尼迷人私房照","description":"THE美女","picUrl":"http://img1.wyss.net.cn/uploadfiles/cover/2016/11/02/20161102141839296.jpg","url":"http://www.the6688.com/rhmeinv/chuangshangfenhongbijinimeinv.html"},{"ctime":"2016-11-09 02:00","title":"[贴图]午后的阳光美女与咖啡更配","description":"华声美女","picUrl":"http://s.image.hnol.net/x/246x0/auto/http://image.hnol.net/c/2016-11/09/00/201611090042439561-5358094.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7527040-0-1.html"},{"ctime":"2016-11-08 20:00","title":"真空美人 chen美妍  奶油抹胸大尺度诱惑","description":"美女写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/08/m.xxxiao.com_9d2f1ddaa068d53d4468d31efe1c8c00-683x1024.jpg","url":"http://m.xxxiao.com/63045"},{"ctime":"2016-11-08 20:00","title":"琳琳ailin(黄锦琳) 泰国皮卡丘尼泳池比基尼诱惑","description":"美女写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2016/08/m.xxxiao.com_82faecb7fe4f7927d7f2447fe7f4f7d1-682x1024.jpg","url":"http://m.xxxiao.com/70125"},{"ctime":"2016-11-08 16:00","title":"美腿秀474（Avril 2016.11.08）","description":"华声美女","picUrl":"http://s.image.hnol.net/x/246x0/auto/http://image.hnol.net/c/2016-11/08/15/20161108155307651-2285289.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7526440-0-1.html"},{"ctime":"2016-11-08 14:00","title":"[贴图]花如人艳 人似花娇【2016・11・08】","description":"华声美女","picUrl":"http://s.image.hnol.net/x/246x0/auto/http://image.hnol.net/c/2016-11/08/10/201611081051193731-4761447.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7525737-0-1.html"},{"ctime":"2016-11-08 14:00","title":"[分享]慕羽茜沙发上制服诱惑私房照","description":"华声美女","picUrl":"http://img.sc601.com/photo_files/news/20161105/52bfbb98-5eb6-481c-841c-897cfe27851c.jpg","url":"http://bbs.voc.com.cn/mm/meinv-7525719-0-1.html"}]
     */

    private int code;
    private String msg;
    /**
     * ctime : 2016-11-09 10:00
     * title : [分享]日本美少女荒井萌比基尼清纯写真
     * description : 华声美女
     * picUrl : http://img.sc601.com/photo_files/news/20151127/9952492e-7bd0-45f5-bf9f-f64f40e38143.jpg
     * url : http://bbs.voc.com.cn/mm/meinv-7527303-0-1.html
     */

    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
